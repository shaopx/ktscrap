package com.spx.dev;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HttpLoader {
    public static String load(Request request){
        //创建连接客户端
        OkHttpClient client = new OkHttpClient();

        //创建"调用" 对象
        Call call = client.newCall(request);
        try {
            Response response = call.execute();//执行
            if (response.isSuccessful()) {
                String returnStr = response.body().string();
                System.out.println(returnStr);
                return returnStr;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
