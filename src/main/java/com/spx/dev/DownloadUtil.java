package com.spx.dev;

import com.spx.dev.persist.FilePersistImpl;
import okhttp3.*;

import javax.net.ssl.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

public class DownloadUtil {

    private static DownloadUtil downloadUtil;
    private final OkHttpClient okHttpClient;

    public static DownloadUtil get() {
        if (downloadUtil == null) {
            downloadUtil = new DownloadUtil();
        }
        return downloadUtil;
    }

    private DownloadUtil() {
        okHttpClient =  getUnsafeOkHttpClient();
//                .build();
    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS).build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param url      下载连接
     * @param saveDir  储存下载文件的SDCard目录
     */
    public void download(final String url, final String saveDir, String name) throws IOException {
        //log拦截器 打印所有的log
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                LogUtils.e("HttpLog",message);
//            }
//        });
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Request request = //new Request.Builder().url(url).build();
        new Request.Builder()
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Connection", "Keep-Alive")
                .addHeader("Host", "cdn.ruguoapp.com")
                .addHeader("Pragma", "no-cache")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0")
                .url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        // 储存下载文件的目录
        String savePath = isExistDir(saveDir);
        try {
            is = response.body().byteStream();
            long total = response.body().contentLength();
            File file = new File(savePath, name);
            fos = new FileOutputStream(file);
            long sum = 0;
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
                sum += len;
                int progress = (int) (sum * 1.0f / total * 100);
//                System.out.println(""+progress);
                // 下载中
//                listener.onDownloading(progress);
            }
            fos.flush();
            fos.close();
            // 下载完成
//            listener.onDownloadSuccess();
        } catch (Exception e) {
            e.printStackTrace();
//            listener.onDownloadFailed();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
            }
        }
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                // 下载失败
//                listener.onDownloadFailed();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }

    /**
     * @param saveDir
     * @return
     * @throws IOException 判断下载目录是否存在
     */
    private String isExistDir(String saveDir) throws IOException {
        // 下载位置
        File downloadFile = new File(saveDir);
        if (!downloadFile.mkdirs()) {
            downloadFile.createNewFile();
        }
        String savePath = downloadFile.getAbsolutePath();
        return savePath;
    }

    /**
     * @return 从下载连接中解析出文件名
     */
    private String getNameFromUrl(String id, int index) {
        return id+"_"+index+".jpeg";
    }

    public interface OnDownloadListener {
        /**
         * 下载成功
         */
        void onDownloadSuccess();

        /**
         * @param progress 下载进度
         */
        void onDownloading(int progress);

        /**
         * 下载失败
         */
        void onDownloadFailed();
    }

    /**
     * 默认信任所有的证书
     * TODO 最好加上证书认证，主流App都有自己的证书
     *
     * @return
     */
    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory sSLSocketFactory = null;
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllManager()},
                    new SecureRandom());
            sSLSocketFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }
        return sSLSocketFactory;
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

}