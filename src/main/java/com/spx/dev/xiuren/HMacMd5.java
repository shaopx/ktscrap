package com.spx.dev.xiuren;

import java.security.MessageDigest;

public class HMacMd5 {
    public static String encode(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append("0" + toHexString);
                } else {
                    stringBuilder.append(toHexString);
                }
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        String encode = HMacMd5.encode("5652447017191237783");
        System.out.println(encode);
    }
}
