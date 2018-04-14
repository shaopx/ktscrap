package com.spx.dev.kaishu;

import com.spx.dev.HttpLoader;
import com.spx.dev.HttpManager;
import okhttp3.Request;

public class UserInfo {

    public static void main(String[] args) {
        UserInfo test = new UserInfo();
        test.load();
    }

    private void load() {
        for (int i = 90000000; i < 91000000; i++) {
            String url = "https://api.kaishustory.com/userservice/user/index?userid="+i;
            Request request
                    = HttpManager.getKaiShuRequest(url, i);


            String str = HttpLoader.load(request);
            System.out.println(str);
        }

    }
}
