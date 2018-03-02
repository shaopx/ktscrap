package com.spx.dev.lanrentingshu;

import com.google.gson.Gson;
import com.spx.dev.HttpLoader;
import com.spx.dev.HttpManager;
import com.spx.dev.domain.JPersistData;
import com.spx.dev.domain.TingShuBookList;
import com.spx.dev.domain.TingShuChapterList;
import com.spx.dev.domain.TopicResult;
import com.spx.dev.persist.FilePersistImpl;
import okhttp3.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanRenTingShuScrap {
    public static String secret = "iJ0DgxmdC83#I&j@iwg";

    // 79939683 王玥波
    // 79939505 单田芳

    public static void main(String[] args) {
        LanRenTingShuScrap scrap = new LanRenTingShuScrap();
        scrap.load();
    }

    private String appendSc(String url) {
        String urlHeader = "http://dapis.mting.info";
        String para = url.replace(urlHeader, "");
        String sc = TingShuCrapo.encode(para + secret);
        System.out.println(sc + "");
        url = urlHeader + para + "&sc=" + sc;
        return url;
    }

    private void load() {
        String url = "http://dapis.mting.info/yyting/snsresource/getBookList.action?imei=MzU4MjM5MDU4Nzk5MDkx&nwt=1&opType=H&q=139&referId=0" +
                "&size=1000&token=nOZN7KUSelXP1SZKF6GjFg**_SVzKnCx2ZnKgUi6WuFZFlA**" +
                "&userId=79939505"
                //"&userId=79939505"
                ;
        url = appendSc(url);
        System.out.println(url + "");
        Request request
                = HttpManager.getTingshuRequest(url);
        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        System.out.println(str);
        TingShuBookList tingShuBookList = gson.fromJson(str, TingShuBookList.class);
        List<TingShuBookList.Listbean> list = tingShuBookList.getList();
        System.out.println("book list size:" + list.size());

        for (int i = 0; i < list.size(); i++) {
            TingShuBookList.Listbean listbean = list.get(i);
            System.out.println(listbean.getBookName() + ", bookid:" + listbean.getBookId() + ", sections:" + listbean.getSections());

            try {
                loadOneBook(listbean);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void loadOneBook(TingShuBookList.Listbean listbean) {
        int bookId = listbean.getBookId();
        String bookName = listbean.getBookName();
        String url = "http://dapis.mting.info/yyting/bookclient/ClientGetBookResource.action?bookId=" + bookId + "&imei=MzU4MjM5MDU4Nzk5MDkx&nwt=1&pageNum=1&pageSize=500&q=72&sortType=0&token=nOZN7KUSelXP1SZKF6GjFg**_SVzKnCx2ZnKgUi6WuFZFlA**"
                //"&userId=79939505"
                ;
        url = appendSc(url);
        System.out.println(url + "");
        Request request
                = HttpManager.getTingshuRequest(url);
        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        System.out.println(str);
        TingShuChapterList tingShuChapterList = gson.fromJson(str, TingShuChapterList.class);
        List<TingShuChapterList.Listbean> list = tingShuChapterList.getList();
        System.out.println(list.size());
        List<JPersistData> persistData = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TingShuChapterList.Listbean chapter = list.get(i);
            System.out.println(chapter.getName()+", path:"+chapter.getPath());
            JPersistData data = new JPersistData();
            if(chapter.getPath()!=null && chapter.getPath().length()>0){
                data.url = chapter.getPath();
                data.format=".mp3";
                data.saveName=chapter.getName();
                persistData.add(data);
            }

//            persist(bookName, chapter);
        }

        if(persistData.size()==0){
            return;
        }

        FilePersistImpl filePersist = new FilePersistImpl("d:/data/tingshu/stf");
        try {
            filePersist.onPersist(bookName, "", "", "", bookName,persistData );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void persist(String bookName, TingShuChapterList.Listbean chapter) {

    }
}
