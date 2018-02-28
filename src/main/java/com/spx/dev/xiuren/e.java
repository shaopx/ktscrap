package com.spx.dev.xiuren;

/* compiled from: Base64 */
public final class e {
//    private static char a = '=';
//    private static byte[] b = new byte[128];
//    private static char[] c = new char[64];
//
//    static {
//        int i;
//        int i2 = 0;
//        for (i = 0; i < 128; i++) {
//            b[i] = (byte) -1;
//        }
//        for (i = 90; i >= 65; i--) {
//            b[i] = (byte) (i - 65);
//        }
//        for (i = TinkerReport.KEY_APPLIED_DEXOPT_EXIST; i >= 97; i--) {
//            b[i] = (byte) ((i - 97) + 26);
//        }
//        for (i = 57; i >= 48; i--) {
//            b[i] = (byte) ((i - 48) + 52);
//        }
//        b[43] = (byte) 62;
//        b[47] = (byte) 63;
//        for (i = 0; i <= 25; i++) {
//            c[i] = (char) (i + 65);
//        }
//        int i3 = 26;
//        i = 0;
//        while (i3 <= 51) {
//            c[i3] = (char) (i + 97);
//            i3++;
//            i++;
//        }
//        i = 52;
//        while (i <= 61) {
//            c[i] = (char) (i2 + 48);
//            i++;
//            i2++;
//        }
//        c[62] = '+';
//        c[63] = '/';
//    }
//
//    private static boolean a(char c) {
//        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
//    }
//
//    private static boolean b(char c) {
//        return c == a;
//    }
//
//    private static boolean c(char c) {
//        return c < '' && b[c] != (byte) -1;
//    }
//
//    public static String a(byte[] bArr) {
//        int i = 0;
//        if (bArr == null) {
//            return null;
//        }
//        int length = bArr.length * 8;
//        if (length == 0) {
//            return "";
//        }
//        int i2 = length % 24;
//        int i3 = length / 24;
//        char[] cArr = new char[((i2 != 0 ? i3 + 1 : i3) * 4)];
//        int i4 = 0;
//        int i5 = 0;
//        byte b = 0;
//        byte b6;
//        while (i4 < i3) {
//            length = i + 1;
//            b= bArr[i];
//            int i6 = length + 1;
//            byte b2 = bArr[length];
//            int i7 = i6 + 1;
//            byte b3 = bArr[i6];
//            byte b4 = (byte) (b2 & 15);
//            byte b5 = (byte) (b & 3);
//            if ((b & -128) == 0) {
//                i6 = (byte) (b >> 2);
//            } else {
//                byte b6 = (byte) ((b >> 2) ^ 192);
//            }
//            if ((b2 & -128) == 0) {
//                i = (byte) (b2 >> 4);
//            } else {
//                b = (byte) ((b2 >> 4) ^ 240);
//            }
//            length = (b3 & -128) == 0 ? (byte) (b3 >> 6) : (byte) ((b3 >> 6) ^ TinkerReport.KEY_LOADED_EXCEPTION_DEX);
//            int i8 = i5 + 1;
//            cArr[i5] = c[i6];
//            i6 = i8 + 1;
//            cArr[i8] = c[i | (b5 << 4)];
//            i5 = i6 + 1;
//            cArr[i6] = c[length | (b4 << 2)];
//            i = i5 + 1;
//            cArr[i5] = c[b3 & 63];
//            i4++;
//            i5 = i;
//            i = i7;
//        }
//        byte b7;
//        byte b8;
//        if (i2 == 8) {
//            b7 = bArr[i];
//            b8 = (byte) (b7 & 3);
//            i = i5 + 1;
//            cArr[i5] = c[(b7 & -128) == 0 ? (byte) (b7 >> 2) : (byte) ((b7 >> 2) ^ 192)];
//            length = i + 1;
//            cArr[i] = c[b8 << 4];
//            i3 = length + 1;
//            cArr[length] = a;
//            length = i3 + 1;
//            cArr[i3] = a;
//        } else if (i2 == 16) {
//            b7 = bArr[i];
//            b = bArr[i + 1];
//            b6 = (byte) (b & 15);
//            byte b9 = (byte) (b7 & 3);
//            if ((b7 & -128) == 0) {
//                i3 = (byte) (b7 >> 2);
//            } else {
//                b8 = (byte) ((b7 >> 2) ^ 192);
//            }
//            length = (b & -128) == 0 ? (byte) (b >> 4) : (byte) ((b >> 4) ^ 240);
//            i = i5 + 1;
//            cArr[i5] = c[i3];
//            i3 = i + 1;
//            cArr[i] = c[length | (b9 << 4)];
//            length = i3 + 1;
//            cArr[i3] = c[b6 << 2];
//            i3 = length + 1;
//            cArr[length] = a;
//        }
//        return new String(cArr);
//    }
//
//    public static byte[] a(String str) {
//        if (str == null) {
//            return null;
//        }
//        char[] toCharArray = str.toCharArray();
//        int a = a(toCharArray);
//        if (a % 4 != 0) {
//            return null;
//        }
//        int i = a / 4;
//        if (i == 0) {
//            return new byte[0];
//        }
//        byte[] obj = new byte[(i * 3)];
//        int i2 = 0;
//        int i3 = 0;
//        int i4 = 0;
//        byte b = b[c];
//        while (i4 < i - 1) {
//            int i5 = i2 + 1;
//            char c = toCharArray[i2];
//            if (!c(c)) {
//                return null;
//            }
//            i2 = i5 + 1;
//            char c2 = toCharArray[i5];
//            if (!c(c2)) {
//                return null;
//            }
//            int i6 = i2 + 1;
//            char c3 = toCharArray[i2];
//            if (!c(c3)) {
//                return null;
//            }
//            i2 = i6 + 1;
//            char c4 = toCharArray[i6];
//            if (!c(c4)) {
//                return null;
//            }
//
//            byte b2 = b[c2];
//            byte b3 = b[c3];
//            byte b4 = b[c4];
//            int i7 = i3 + 1;
//            obj[i3] = (byte) ((b << 2) | (b2 >> 4));
//            int i8 = i7 + 1;
//            obj[i7] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
//            i3 = i8 + 1;
//            obj[i8] = (byte) ((b3 << 6) | b4);
//            i4++;
//        }
//        i = i2 + 1;
//        char c5 = toCharArray[i2];
//        if (!c(c5)) {
//            return null;
//        }
//        i5 = i + 1;
//        char c6 = toCharArray[i];
//        if (!c(c6)) {
//            return null;
//        }
//        byte b5 = b[c5];
//        byte b6 = b[c6];
//        i8 = i5 + 1;
//        c2 = toCharArray[i5];
//        i6 = i8 + 1;
//        char c7 = toCharArray[i8];
//        if (c(c2) && c(c7)) {
//            byte b7 = b[c2];
//            byte b8 = b[c7];
//            i4 = i3 + 1;
//            obj[i3] = (byte) ((b5 << 2) | (b6 >> 4));
//            i2 = i4 + 1;
//            obj[i4] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
//            i3 = i2 + 1;
//            obj[i2] = (byte) ((b7 << 6) | b8);
//            return obj;
//        } else if (b(c2) && b(c7)) {
//            if ((b6 & 15) != 0) {
//                return null;
//            }
//            r0 = new byte[((i4 * 3) + 1)];
//            System.arraycopy(obj, 0, r0, 0, i4 * 3);
//            r0[i3] = (byte) ((b5 << 2) | (b6 >> 4));
//            return r0;
//        } else if (b(c2) || !b(c7)) {
//            return null;
//        } else {
//            byte b9 = b[c2];
//            if ((b9 & 3) != 0) {
//                return null;
//            }
//            r0 = new byte[((i4 * 3) + 2)];
//            System.arraycopy(obj, 0, r0, 0, i4 * 3);
//            a = i3 + 1;
//            r0[i3] = (byte) ((b5 << 2) | (b6 >> 4));
//            r0[a] = (byte) (((b6 & 15) << 4) | ((b9 >> 2) & 15));
//            return r0;
//        }
//    }
//
//    private static int a(char[] cArr) {
//        int i = 0;
//        if (cArr != null) {
//            int length = cArr.length;
//            int i2 = 0;
//            while (i2 < length) {
//                int i3;
//                if (a(cArr[i2])) {
//                    i3 = i;
//                } else {
//                    i3 = i + 1;
//                    cArr[i] = cArr[i2];
//                }
//                i2++;
//                i = i3;
//            }
//        }
//        return i;
//    }
}