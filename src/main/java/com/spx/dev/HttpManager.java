package com.spx.dev;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

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
}
