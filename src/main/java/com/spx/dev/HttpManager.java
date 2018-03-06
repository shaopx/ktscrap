package com.spx.dev;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.File;
import java.io.IOException;

public class HttpManager {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static Request getJKPostJSONRequest(String url, String postJsonStr){
        RequestBody body = RequestBody.create(JSON, postJsonStr);
        try {
            Request request = HttpManager.getJKBuilder()
                    .addHeader("Content-Length", "" + body.contentLength())
                    .url(url)
                    .post(body)//给post设置参数;
                    .build();
            return request;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Request getTouTiaoPostJSONRequest(String url, File file){

//        if (file != null) {
//            builder.addFormDataPart("photo",file.getName(),RequestBody.create(MEDIA_TYPE_PNG, file))
//                    .addFormDataPart("token", token);
//        }
//        MultipartBody requestBody = builder.build();


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("photo", file.getName(), RequestBody.create(MediaType.parse("image/jpeg"), file))
                .build();

        try {
            Request request = HttpManager.getTouTiaoBuilder()
                    .addHeader("Content-Length", "" + requestBody.contentLength())
                    .url(url)
                    .post(requestBody)//给post设置参数;
                    .build();
            return request;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Request getMimiGetRequest(String url){
        try {
            Request request = HttpManager.getMimiHeaderRequstBuilder()
                    .url(url).get()
                    .build();
            return request;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Request.Builder getJKBuilder(){
         return new Request.Builder()
                .addHeader("OS-Version", "23")
                .addHeader("Model", "AOSP on HammerHead")
                .addHeader("Resolution", "1080x1776")
                .addHeader("App-BuildNo", "519")
                .addHeader("ApplicationId", "com.ruguoapp.jike")
                .addHeader("Manufacturer", "LGE")
                .addHeader("Market", "debug")
                .addHeader("OS", "android")
                .addHeader("App-Version", "3.12.1")
                .addHeader("NotificationEnabled", "true")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Host", "app.jike.ruguoapp.com")
                .addHeader("Connection", "Keep-Alive")
//                .addHeader("Accept-Encoding","gzip")
                .addHeader("Cookie", "io=quY-; jike:sess.sig=cH2LLqAoyhSIDU7stRLdsf9irKs; jike:sess=eyJfdWlkIjoiNWE3M2UxYjY5NTYzY2IwMDE3MzY5ZTg5IiwiX3Nlc3Npb25Ub2tlbiI6InhLUGFBUDdTWDN0MzJZc1RaOWFuN056SnAifQ==; jike:config:searchPlaceholderLastInfo=1517544013648#0")
                .addHeader("User-Agent", "okhttp/3.9.1");
    }

    public static Request.Builder getTouTiaoBuilder(){
        return new Request.Builder()
                .addHeader("Host", "mp.toutiao.com")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:56.0) Gecko/20100101 Firefox/56.0")
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
//                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Referer", "https://mp.toutiao.com/profile_v2/weitoutiao")
                .addHeader("Cookie", "uuid=\"w:0b127b1b1acb4ad496ee66143c280899\"; UM_distinctid=161265265094b7-0f39cf5cf8e6c78-12666d4a-1fa400-1612652650a5c0; tt_webid=6514462036587070984; _ga=GA1.2.854877482.1516766390; _ba=BA0.2-20180124-5110e-VLJKAgeuvfYkIhC9vlqX; sso_login_status=1; _mp_test_key_1=d4beebc5f9b9b70049809c0c6272a5fd; uid_tt=d3eccc7f50ec025bb039603a0104c6a7; sid_tt=4f49e09d8a740f054500f69832014192; _ga=GA1.3.854877482.1516766390; __tea_sdk__web_id=764716177; __tea_sdk__user_unique_id=3855681631; tt_im_token=1517806910686086435006003208008343540504653654927008616365886057; __tea_sdk__ssid=0; currentMediaId=; sessionid=a569eabe2af15690ba98b495ff434fd4; _mp_auth_key=4f088b5d787b074ad2bf355450cc2f27; _gid=GA1.3.43238067.1517806911; ptcn_no=3b378a91a752872d9e83f7c296f64132; currentMediaId=1590445734064135")
                .addHeader("Connection", "keep-alive");
    }

    public static Request.Builder getJKDownloadBuilder(){
        return new Request.Builder()
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Host", "cdn.ruguoapp.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
    }

    public static Request.Builder getMimiDownloadBuilder(String host){
        System.out.println("host:"+host);
        return new Request.Builder()
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Pragma", "no-cache")
                .addHeader("Host", host)
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
    }

    public static Request.Builder getMimiHeaderRequstBuilder(){
        return new Request.Builder()
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
//                .addHeader("Accept-Encoding", "deflate")
                .addHeader("Accept-Language", "gbk,en;q=0.9")
                .addHeader("Cookie", "is_use_cookied=yes; is_use_cookiex=yes; cdb_sid=cjNFTS; cdb_oldtopics=D1155228D1155672D1155673D")
                .addHeader("Proxy-Connection", "keep-alive")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("Host", "www.bbbmimi.com")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
    }

    public static Request getLuedongRequst(String luedongUrl) {
        return new Request.Builder()
                .addHeader("Host", "ldapi.sogou.com")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("User-Agent", "okhttp/3.9.1")
                .url(luedongUrl)
                .get()
                .build();
    }

    public static Request getSinaRequest(String url) {
        return new Request.Builder()
                .addHeader("Host", "api.weibo.cn")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("User-Agent", "AOSP on HammerHead_6.0.1_weibo_8.1.2_android")
                .url(url)
                .get()
                .build();
    }

    public static Request getTingshuRequest(String url) {
        return new Request.Builder()
                .addHeader("User-Agent", "Android6.0.1/yyting/LGE/AOSP on HammerHead/ch_huawei/153/Android")
                .addHeader("Referer", "yytingting.com")
                .addHeader("Host", "dapis.mting.info")
                .addHeader("Cookie", "aliyungf_tc=AQAAACHygQc+PA4AyWfKb8JJDBLctlyR")
                .url(url)
                .get()
                .build();
    }

    public static Request getCleanRequest(String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }

    public static Request getTouTiaoReadReqeust(String url) {
        return new Request.Builder()
                .addHeader("Host", "a1.pstatp.com")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("User-Agent",
                        "Dalvik/2.1.0 (Linux; U; Android 6.0.1; AOSP on HammerHead Build/M4B30Z) NewsArticle/6.5.9 cronet/58.0.2991.0")
                .url(url)
                .get()
                .build();
    }

    public static Request getUGirlsPostRequest(String url, String userId, String productId) {
        RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"),
                //"UserId=4559600&Platform=android&ContentId=19592&Version=2.4.5&Auth=0&PageIndex=1&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629&ProductId=1888&AgentCode=ugirls&Token=de18bc80cce34f88ee56bd467d88905d&PageSize=20"
                "UserId="+userId+"&Platform=android&Version=2.4.5&Auth=0&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629" +
                        "&ProductId="+productId+"&AgentCode=ugirls&Token=de18bc80cce34f88ee56bd467d88905d"
        );
        try {
            return new Request.Builder()
                    .addHeader("Host", "api.youguoquan.com")
                    .addHeader("Connection", "Keep-Alive")
                    .addHeader("User-Agent", "ugirls/2.4.5(LGE AOSP on HammerHead;Android 6.0.1;1080x1776)")
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Content-Length", "" + body.contentLength())
                    .url(url)
                    .post(body)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
