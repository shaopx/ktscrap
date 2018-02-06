package com.spx.dev;

import com.google.gson.Gson;
import com.spx.dev.domain.LdTopicResult;
import okhttp3.Request;

public class SinaTopicScrap {

    public SinaTopicScrap() {

    }


    public void load() {
        for (int i = 1; i < 2; i++) {
            loadOnce(i);
        }
    }

    private void loadOnce(int i) {
        String url = "https://api.weibo.cn/2/cardlist?networktype=wifi&uicode=10000011&moduleID=708&featurecode=10000085&wb_version=3562&lcardid=more_weibo&c=android&i=98dfa46&s=21ee9999&ft=0&ua=LGE-AOSP%20on%20HammerHead__weibo__8.1.2__android__android6.0.1&wm=9006_2001&aid=01Anq_QUYRuy74HIemL--FBOmNcPMLfwyEa0auvi59m09Jtq4.&fid=2304133195126054_-_WEIBO_SECOND_PROFILE_WEIBO&uid=2947424221&v_f=2&v_p=58&from=1081295010&gsid=_2A253ffmYDeRxGeRH71UV8irOyT2IHXVSKwpQrDV6PUJbkdANLWzzkWpNTbpCKlaGTpo9_21NtEdd-Q9NSBOiylGI&lang=zh_CN&lfid=2302833195126054" +
                "&page=" + i +
                "&skin=default&count=3&oldwm=9006_2001&sflag=1&containerid=2304133195126054_-_WEIBO_SECOND_PROFILE_WEIBO&ignore_inturrpted_error=true&luicode=10000198&need_head_cards=1";
        Request request
                = HttpManager.getSinaRequest(url);
        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        System.out.println(str);
//        ReadContext context = JsonPath.parse(json);
    }

    public static void main(String[] args) {
        SinaTopicScrap scrap = new SinaTopicScrap();
        scrap.load();
    }
}
