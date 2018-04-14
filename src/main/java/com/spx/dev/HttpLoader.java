package com.spx.dev;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

import com.spx.dev.net.*;

public class HttpLoader {
    private final static String ENCODING = "UTF-8";
    private final static String GZIPCODING = "gzip";

    public static String load(Request request) {
        return load(request, "UTF-8");
    }

    public static String load(Request request, String encode) {
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
//                String returnStr = readStream(response.body().byteStream(), "gzip");
//                System.out.println(returnStr);
                return returnStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    private static String readStream(InputStream inputStream, String encoding) throws Exception {
        StringBuffer buffer = new StringBuffer();

        InputStreamReader inputStreamReader = null;
        GZIPInputStream gZIPInputStream = null;
        if (GZIPCODING.equals(encoding)) {
            gZIPInputStream = new GZIPInputStream(inputStream);
            inputStreamReader = new InputStreamReader(gZIPInputStream, ENCODING);

        } else {

            inputStreamReader = new InputStreamReader(gZIPInputStream, ENCODING);
        }


        char[] c = new char[1024];

        int lenI;
        while ((lenI = inputStreamReader.read(c)) != -1) {

            buffer.append(new String(c, 0, lenI));

        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (gZIPInputStream != null) {
            gZIPInputStream.close();
        }


        return buffer.toString();


    }
}
