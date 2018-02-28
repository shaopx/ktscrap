package com.spx.dev.xiuren;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class XiuRenDecode {

    public static String decode(String str) {
        String str2 = null;
        try {
            str2 = doDecode(str, "s313sdf23@!/sdfsdf23sWS");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }



    private static String doDecode(String str, String str2) throws UnsupportedEncodingException {
        int i = 0;
        byte[] bytes = b1(newStr(Base64.decode(str)), str2).getBytes();
        List arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < bytes.length) {
            byte b = bytes[i2];
            i2++;
            arrayList.add(Byte.valueOf((byte) (b ^ bytes[i2])));
            i2++;
        }
        bytes = new byte[arrayList.size()];
        while (i < arrayList.size()) {
            bytes[i] = ((Byte) arrayList.get(i)).byteValue();
            i++;
        }
        return newStr(bytes);

    }





    public static String b1(String str, String str2) throws UnsupportedEncodingException {
        String a = a1(str2.getBytes("UTF-8"));
        byte[] bArr = new byte[str.getBytes().length];
        byte[] bytes = str.getBytes();
        byte[] bytes2 = a.getBytes();
        int i = 0;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            int i3;
            if (i == bytes2.length) {
                i3 = 0;
            } else {
                i3 = i;
            }
            i = i3 + 1;
            bArr[i2] = (byte) (bytes2[i3] ^ bytes[i2]);
        }
        return newStr(bArr);
    }

    public static String a1(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            byte[] hash = instance.digest();
            int length = hash.length;
            for (int i = 0; i < length; i++) {
                stringBuffer.append(String.format("%02x", new Object[]{Integer.valueOf(hash[i] & 255)}));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static String newStr(byte[] bArr) throws UnsupportedEncodingException {
        if (bArr == null) {
            return null;
        }
        return new String(bArr);
    }

}
