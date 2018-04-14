package com.spx.dev.xiaorenshu;

import com.google.gson.Gson;
import com.spx.dev.DownloadUtil;
import com.spx.dev.HttpLoader;
import com.spx.dev.HttpManager;
import com.spx.dev.Util;
import com.spx.dev.domain.TopicResult;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class XiaoRenShu {
    private static final String ROOTDIR = "d:/data/xiaorenshu";
    private int index = 100;
    private int limit = 10;

    private OkHttpClient client = null;

    public XiaoRenShu() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new LoggingInterceptor());
        client = builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS).build();
    }

    public static void main(String[] args) {
        XiaoRenShu xiaoRenShu = new XiaoRenShu();
        xiaoRenShu.loadAll();

//        String str = "{\"cover\":\"http://ofuaex81c.bkt.clouddn.com/mmwh/xxs/lhh/image/0/shz31jjrb/101.jpg\",\"createdAt\":\"2016-11-23 21:47:20\",\"descri\":\"水浒传31吴用巧破大名府\",\"from\":\"http://ofuaex81c.bkt.clouddn.com/\",\"imgs\":[\"mmwh/xxs/lhh/image/0/shz31jjrb/101.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/102.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/103.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/104.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/105.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/106.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/107.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/108.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/109.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/110.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/111.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/112.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/113.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/114.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/115.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/116.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/117.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/118.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/119.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/120.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/121.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/122.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/123.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/124.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/125.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/126.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/127.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/128.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/129.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/130.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/131.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/132.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/133.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/134.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/135.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/136.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/137.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/138.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/139.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/140.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/141.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/142.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/143.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/144.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/145.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/146.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/147.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/148.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/149.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/150.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/151.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/152.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/153.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/154.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/155.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/156.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/157.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/158.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/159.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/160.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/161.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/162.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/163.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/164.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/165.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/166.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/167.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/168.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/169.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/170.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/171.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/172.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/173.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/174.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/175.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/176.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/177.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/178.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/179.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/180.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/181.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/182.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/183.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/184.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/185.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/186.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/187.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/188.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/189.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/190.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/191.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/192.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/193.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/194.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/195.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/196.jpg\",\"mmwh/xxs/lhh/image/0/shz31jjrb/197.jpg\"],\"length\":6,\"name\":\"水浒传31吴用巧破大名府\",\"objectId\":\"bbd1f93cdc\",\"price\":0,\"status\":1,\"type\":0,\"updatedAt\":\"2016-11-24 07:24:54\"}";
//        Gson gson = new Gson();
//        AlbumListResult.Resultsbean album = gson.fromJson(str, AlbumListResult.Resultsbean.class);
//        xiaoRenShu.downloadOneAlbum(album);
    }

    private void loadAll() {
        while (true) {
            if (!loadOnePageAlbum()) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean loadOnePageAlbum() {
        System.out.println("load index:" + index + " ... ");
        String url = "https://api.bmob.cn/1/classes/Album?where={\"status\":1}&order=createdAt&skip=" + index + "&keys=cover,name,type&limit=" + limit;
        Request request
                = HttpManager.getXRSGetRequest(url);


        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        AlbumListResult albumListResult = gson.fromJson(str, AlbumListResult.class);
        List<AlbumListResult.Resultsbean> results = albumListResult.getResults();
        if (results == null || results.size() == 0) {
            System.out.println("load index:" + index + " fail!");
            return false;
        }

        for (int i = 0; i < results.size(); i++) {
            AlbumListResult.Resultsbean result = results.get(i);
            result.index = index + i;
            System.out.println(result.getName() + ", " + result.getCover() + ", " + result.getCreatedAt() + ", " + result.getObjectId());
            downloadOneAlbum(result);
        }
//        for (AlbumListResult.Resultsbean result : results) {
//
//
//        }

        index += results.size();
        return true;
    }

    private void downloadOneAlbum(AlbumListResult.Resultsbean result) {
        String url = "https://api.bmob.cn/1/classes/Album/" + result.getObjectId();
        Request request
                = HttpManager.getXRSGetRequest(url);


        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        Album album = gson.fromJson(str, Album.class);
        System.out.println(result.getName() + " loaded! album size:" + album.getImgs().size() + "");

        File dir = Util.mkdir(ROOTDIR + "/" + result.getName());
        try {
            Util.saveTextToFile(dir, "info.txt", str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String from = album.getFrom();
        String host = Util.getHost(album.getCover());
        String fromHost = null;
        System.out.println("host:" + host);
        if (from.indexOf("&&&") > 0) {
            fromHost = from.substring(from.indexOf("&&&") + 3);
        } else if (from != null && from.startsWith("http")) {
            fromHost = from;
        }
        final String theHost = Util.isNull(fromHost) ? host : fromHost;
        System.out.println("theHost:" + theHost);
        List<String> imgs = album.getImgs();

        List<String> finalImgs = new ArrayList<>();
        for (int i = 0; i < imgs.size(); i++) {
            String s = imgs.get(i);
            if (s.toLowerCase().startsWith("http")) {
                finalImgs.add(s);
            } else {
                finalImgs.add(theHost + "/" + s);
            }

        }
        Util.downloadImages(dir, finalImgs);

    }
}
