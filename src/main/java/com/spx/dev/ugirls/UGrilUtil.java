package com.spx.dev.ugirls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UGrilUtil {

    /**
     * unicode转中文
     *
     * @param str
     * @return
     * @author yutao
     * @date 2017年1月24日上午10:33:25
     */
    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

        Matcher matcher = pattern.matcher(str);

        char ch;

        while (matcher.find()) {

            ch = (char) Integer.parseInt(matcher.group(2), 16);

            str = str.replace(matcher.group(1), ch + "");

        }

        return str;

    }

    public static String decode(String output) {
        output = EncrypterUtil.AESDecrypt(EncrypterUtil.getKey(), output);
        output = unicodeToString(output);
        return output;
    }
}
