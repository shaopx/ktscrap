package com.spx.dev.net;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
        .addHeader("User-Agent", "ugirls/2.4.5(LGE AOSP on HammerHead;Android 6.0.1;4080x4776)")
        .addHeader("Content-Type", "application/x-www-form-urlencoded")
        .addHeader("Host", "api.youguoquan.com")
        .addHeader("Connection", "Keep-Alive").build();

        long t1 = System.nanoTime();
        System.out.println(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        System.out.println(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        return response;
    }
}