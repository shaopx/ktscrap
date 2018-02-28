package com.spx.dev.lanrentingshu;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class TingShuCrapo {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    static String encode(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
//            Log.e(ISecurity.SIGN_ALGORITHM_MD5, "NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0").append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString().toLowerCase();
    }

}
