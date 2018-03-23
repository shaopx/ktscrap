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

    private void read(){
        String url ="https://a1.pstatp.com/article/full/20/1/6519630121660318222/6519630121660318222/2/0/0/?" +
                "iid=25623880311" +
                "&device_id=48038728811" +
                "&ac=wifi&channel=huawei&aid=13&app_name=news_article&version_code=659&version_name=6.5.9&device_platform=android" +
                "&ab_version=251132%2C267875%2C272870%2C276222%2C271178%2C208276%2C252766%2C249828%2C246859%2C275644%2C249665%2C249685%2C249686%2C249676%2C264843%2C249668%2C274584%2C206078%2C272431%2C229304%2C249672%2C276915%2C270948%2C275045%2C271862%2C276809%2C271581%2C271717%2C259489%2C247027%2C240865%2C277007%2C270389%2C261489%2C276495%2C276759%2C251711%2C229901%2C267594%2C234416%2C274344%2C276952%2C229398%2C276018%2C207252%2C270332%2C266312%2C267095%2C274557%2C270107%2C258356%2C247849%2C276165%2C273808%2C264453%2C276964%2C249045%2C271663%2C210683%2C267067%2C244746%2C273962%2C274294%2C264616%2C275348%2C237136%2C268791%2C260654%2C264973%2C241181%2C276500%2C268341%2C232362%2C265707%2C271191%2C241820%2C239095%2C272014%2C170988%2C269426%2C273499%2C268663%2C265169%2C276204%2C274990%2C272514%2C257283%2C261294%2C265278%2C265120&ab_client=a1%2Cc4%2Ce1%2Cf2%2Cg2%2Cf7" +
                "&ab_group=94564%2C102756%2C181430" +
                "&ab_feature=102756%2C94564" +
                "&abflag=3" +
                "&ssmix=a&device_type=AOSP+on+HammerHead&device_brand=Android&language=zh&os_api=23&os_version=6.0.1" +
                "&uuid=358239058799011" +
                "&openudid=82da3b044aaf98f4" +
                "&manifest_version_code=659&resolution=1080*1776&dpi=480&update_version_code=65902" +
                "&_rticket=1517970320764&plugin=10575&fp=wSTqLWKWFMKuFlHbcSU1FYwIPrsq" +
                "&rom_version=23&ts=1517970325" +
                "&as=a2f5564795094af34a7262" +
                "&mas=0018eff6534840a2bff28bd28a34ae0d88a2e84c8c8aa08289";
        File file = new File("d:/log/1.jpeg");
        Request request
                = HttpManager.getTouTiaoReadReqeust(url);
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
