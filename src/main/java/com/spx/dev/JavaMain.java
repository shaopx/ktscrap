package com.spx.dev;

import okhttp3.*;

import java.io.IOException;

public class JavaMain {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {

//        HttpLoggingInterceptor interceptor = null;
        //创建连接客户端
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, "{\"trigger\":\"auto\"}");
        Request request = new Request.Builder()
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
                .addHeader("Content-Length", "" + body.contentLength())
                .addHeader("Host", "app.jike.ruguoapp.com")
                .addHeader("Connection", "Keep-Alive")
//                .addHeader("Accept-Encoding","gzip")
                .addHeader("Cookie", "io=quY-; jike:sess.sig=cH2LLqAoyhSIDU7stRLdsf9irKs; jike:sess=eyJfdWlkIjoiNWE3M2UxYjY5NTYzY2IwMDE3MzY5ZTg5IiwiX3Nlc3Npb25Ub2tlbiI6InhLUGFBUDdTWDN0MzJZc1RaOWFuN056SnAifQ==; jike:config:searchPlaceholderLastInfo=1517544013648#0")
                .addHeader("User-Agent", "okhttp/3.9.1")
                .url("https://app.jike.ruguoapp.com/1.0/recommendFeed/list")
                .post(body)//给post设置参数;
                .build();
        //创建"调用" 对象
        Call call = client.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {
                String returnStr = response.body().string();
                System.out.println(returnStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
