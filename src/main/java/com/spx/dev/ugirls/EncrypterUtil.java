package com.spx.dev.ugirls;



import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @auther shaopx
 * @date 2018/3/4.
 */

public class EncrypterUtil {
    private static final String AESTYPE = "AES/ECB/PKCS5Padding";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDih68p4toAXZfHLPVsiOkV7muQvwC4wVUe3d6z/8ygLxdToqeaFZc3HwBkqGbVT68ElPG9KDbcJNPLJe8rpeLxI7WxY1lvH/0hMQkGKGmJ/Bf/2r7u/fgq1EPjfdvpOiC+OzQUhScYX5kBKhH2Hhj/hxdwlK32aEEVq8u5oERTsQIDAQAB";

    public static String AESEncrypt(String keyStr, String plainText) {
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(1, key);
            plainText = URLEncoder.encode(new String(Base64.encode(cipher.doFinal(plainText.getBytes()), 0)));
        } catch (Exception e) {
//            ThrowableExtension.printStackTrace(e);
        }
        return plainText;
    }

    public static String AESEncrypt(String plainText) {
        return AESEncrypt(getKey(), plainText);
    }

    public static String getKey() {
        try {
            String key = EncrypterUtil.decryptKey("kqsfdhKnAbVbQ4fHvsZgZ98j2OyOUTj+1PpFeT15JDn8J86n00VuThRaAYoBDtGiCxPbiFAyULxLR/41KtKfO9Fa0NyDzwAEjy+1IvhZtZrKa8WZmOGTXxfdDlalzUc0g6zF7SWmcRFgh+rZC8bWeJLbSL7gmi13YPmY4VPUp7s=");
            return key;
        } catch (Exception e) {
//            ThrowableExtension.printStackTrace(e);
            e.printStackTrace();
        }
        throw new RuntimeException("no key");
    }

    public static String AESDecrypt(String encryptData) {
        return AESDecrypt(getKey(), encryptData);
    }



    public static String AESDecrypt(String keyStr, String encryptData) {
        byte[] decrypt = null;
        try {
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(2, key);
            decrypt = cipher.doFinal(Base64.decode(encryptData));
        } catch (Exception e) {
        }
        return new String(decrypt).trim();
    }

    private static Key generateKey(String key) throws Exception {
        try {
            return new SecretKeySpec(key.getBytes(), "AES");
        } catch (Exception e) {
//            ThrowableExtension.printStackTrace(e);
            throw e;
        }
    }

    public static RSAPublicKey loadPublicKey() throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUBLIC_KEY)));
    }

    public static byte[] decryptKey(byte[] cipherData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, loadPublicKey());
        return cipher.doFinal(cipherData);
    }

    public static String decryptKey(String data) throws Exception {
        return new String(decryptKey(Base64.decode(data)), "UTF-8");
    }
}
