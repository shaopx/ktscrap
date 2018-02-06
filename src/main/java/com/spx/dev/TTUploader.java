package com.spx.dev;

import com.spx.dev.net.LoggingInterceptor;
import okhttp3.*;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TTUploader {

    public TTUploader(){

    }

    public static void main(String[] agrs){
//        System.getProperties().setProperty("http.proxyHost", "10.129.233.124");
//        System.getProperties().setProperty("http.proxyPort", "8888");

        TTUploader uploader = new TTUploader();
        uploader.upload();
    }

    private void upload() {
        System.out.println("upload.....");
        String url ="https://mp.toutiao.com/upload_photo/?type=json";
        File file = new File("d:/log/1.jpeg");
        Request request
                = HttpManager.getTouTiaoPostJSONRequest(url, file);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new LoggingInterceptor());
        OkHttpClient client = builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

        //创建"调用" 对象
        Call call = client.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                String str = body.string();
                System.out.println("return:"+str);
            } else {
                System.out.println("fail!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
