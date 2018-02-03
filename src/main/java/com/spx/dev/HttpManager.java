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
}
