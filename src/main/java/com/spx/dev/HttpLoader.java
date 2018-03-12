package com.spx.dev;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import com.spx.dev.net.*;

public class HttpLoader {
    public static String load(Request request){
        return load(request, "UTF-8");
    }
    public static String load(Request request, String encode){
        //创建连接客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new LoggingInterceptor());
        OkHttpClient client = builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();

        //创建"调用" 对象
        Call call = client.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {

                byte[] bytes = response.body().bytes();

                String returnStr = new String(bytes, encode);
//                System.out.println(returnStr);
                return returnStr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
