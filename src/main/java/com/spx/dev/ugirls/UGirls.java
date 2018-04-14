package com.spx.dev.ugirls;

import com.google.gson.Gson;
import com.spx.dev.DownloadUtil;
import com.spx.dev.HttpLoader;
import com.spx.dev.HttpManager;
import com.spx.dev.net.LoggingInterceptor;
import com.spx.dev.ugirls.domain.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UGirls {
    private static final String ROOT_SAVE_DIR = "d:\\data\\ugirls\\picture\\";
    FileWriter fw = new FileWriter("d:/data/ugirls/users_1_3.txt", true);
    FileWriter downloadUrls = new FileWriter("d:/data/ugirls/urls.txt", true);
    BufferedWriter bw;

    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    UGrilsApi api;
    private List<Product> products = new ArrayList<>();


    public UGirls() throws IOException {
        bw = new BufferedWriter(fw);

        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .followRedirects(true)
//                .addInterceptor(new LoggingInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.youguoquan.com/")
                .addConverterFactory(DecodeConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(UGrilsApi.class);
    }

    public void download(String userId, String productId) {
//        String url ="https://api.youguoquan.com/ProductCritical/Critical/GetFreeContentCritical";
        String url = "https://api.youguoquan.com/Users/Common/DownLoad";
        Request request
                = HttpManager.getUGirlsPostRequest(url, userId, productId);
        String str = HttpLoader.load(request, "UTF-8");
        Gson gson = new Gson();

        String decode = UGrilUtil.decode(str);
        if (decode.contains("对不起,您没有权限进行下载")) {
            System.out.println(userId + ", " + decode);
        } else {
            throw new RuntimeException(decode + ":" + userId);
//            System.err.println("SUCCEED!!!"+userId + ", "+decode);
        }
    }


    public static void main(String[] args) throws IOException {
//        String json = "";
//        try {
//            json = EncrypterUtil.AESDecrypt(EncrypterUtil.getKey(), json);
//            json = UGrilUtil.unicodeToString(json);
//            System.out.println(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "8888");
//        System.setProperty("https.proxyPort", "8888");


        UGirls uGirls = new UGirls();
        uGirls.getProductTags();

        uGirls.getAllProducts();

//        uGirls.tryUserInfo();
//        uGirls.getUserInfo("2000152");
    }

    private void getAllProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
//            if(product.tagId==-1001){
//                continue;
//            }
            if(product.tagName.contains("3D")){
                continue;
            }
            try {
                getAlbumlist(product);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        try {
//            Product product = new Product();
//            product.tagName = "热门";
//            product.tagId = -1001;
//            getAlbumlist(product);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void purchseProduct(int productId) throws IOException {
        Map<String, String> parms
                = converToParams("UserId=4000057&Platform=android&Qty=1&Remark=&Version=2.4.5" +
                "&Auth=0&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629" +
                "&ProductId=" + productId +
                "&AgentCode=ugirls&Token=4e77af0ca26d236ff0e632c43241e3dc");

        Call<PurchaseResult> call = api.purchase(parms);
        Response<PurchaseResult> execute = call.execute();
        PurchaseResult purchaseResult = execute.body();
        System.out.println(purchaseResult.getMsg());
    }

    public void getOneProdct(ProductListResult.SpecialListbean specialListbean, int index) throws IOException {
        System.out.println("start handle [" + index + "]. productId:" + specialListbean.getIProductId() + ", name:" + specialListbean.getSProductName());
        List<ProductListResult.SpecialListbean.ModelListbean> modelList = specialListbean.getModelList();
        String info = "";
        String productName = "";
        String modelName = "unknown";
        int modelId = 0;
        if (modelList.size() > 0) {
            ProductListResult.SpecialListbean.ModelListbean modelListbean = modelList.get(0);
            productName += modelListbean.getSName() + "_";
            modelName = modelListbean.getSName();
            modelId = modelListbean.getIModelId();
        }
        productName += specialListbean.getSProductName();

        Map<String, String> parms
                = converToParams("UserId=4000057&Platform=android&Version=2.4.5&Auth=0" +
                "&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629" +
                "&ProductId=" + specialListbean.getIProductId() +
                "&AgentCode=ugirls&Token=4e77af0ca26d236ff0e632c43241e3dc");

        Call<GetDownloadUrlResult> call = api.getDownloadUrl(parms);
        Response<GetDownloadUrlResult> execute = call.execute();
        GetDownloadUrlResult downloadUrlResult = execute.body();
        if (downloadUrlResult.getStatus() == 1) {
            String downloadUrl = downloadUrlResult.getUrl();
            if (downloadUrl != null) {
                // 下载文件:downloadUrl
                info += modelName + "\r\n";
                info += productName + "\r\n";
                info += "id:" + specialListbean.getIProductId() + "\r\n";
                info += "model_id:" + modelId + "\r\n";
                info += "url:" + downloadUrl + "\r\n";
                downloadUrls.append(productName + "\r\n");
                downloadUrls.append(downloadUrl + "\r\n");
                DownloadUtil.get().download(downloadUrl, ROOT_SAVE_DIR + modelName, productName + ".zip", info);
            }
        } else {
            System.out.println("get download fail[" + index + "]. productId:" + specialListbean.getIProductId());
            System.out.println("get download fail[" + index + "]. name:" + specialListbean.getSProductName() + ", content:" + specialListbean.getSContent());
            throw new RuntimeException("found one fail!");
        }
    }

    private void getAlbumlist(Product product) throws IOException {
        System.out.println("start get product list of product:" + product.tagName);
        int pageSize = 200;
        int pageIndex = product.nextPage;
        while (product.totalCount > product.loadedCount) {
            Map<String, String> parms
                    = converToParams(
                    "UserId=4000057&SectionId=3&Platform=android" +
                            "&TagId=" + product.tagId +
                            "&CategoryId=1000" +
                            "&Version=2.4.5&Auth=0" +
                            "&PageIndex=" + product.nextPage +
                            "&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629" +
                            "&Token=4e77af0ca26d236ff0e632c43241e3dc&AgentCode=ugirls&PageSize=" + pageSize);

            Call<ProductListResult> call = api.GetListByTagId(parms);
            Response<ProductListResult> execute = call.execute();
            ProductListResult productListResult = execute.body();

            int status = productListResult.getStatus();

            if (status == 1) {
                String count = productListResult.getCount();
                product.totalCount = Integer.parseInt(count);
                List<ProductListResult.SpecialListbean> specialList = productListResult.getSpecialList();
//                if(product.loadedCount>100){
                for (int i = 0; i < specialList.size(); i++) {
                    ProductListResult.SpecialListbean specialListbean = specialList.get(i);
                    int iProductId = specialListbean.getIProductId();
                    String sProductName = specialListbean.getSProductName();
                    try {
                        getOneProdct(specialListbean, i + 1 + product.loadedCount);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        try {
                            purchseProduct(specialListbean.getIProductId());
                            Thread.sleep(500);

                            getOneProdct(specialListbean, i + 1 + product.loadedCount);
                        } catch (Exception e) {
                            e.printStackTrace();
                            try {
                                Thread.sleep(3000);
                                getOneProdct(specialListbean, i + 1 + product.loadedCount);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                                throw ex;
                            }


                        }
                    }
                }
//                }

//                for (ProductListResult.SpecialListbean specialListbean : specialList) {
//
//                }
                product.loadedCount += specialList.size();
                System.out.println("id:" + product.tagId + ", totalCount:" + count + ", loadedCount:" + product.loadedCount + ", pageIdex:" + product.nextPage);
                product.nextPage++;
            } else {
                System.err.println("id:" + product.tagId + ", " + product.tagName + ", page: " + pageIndex + " fail!");
                break;
            }
        }


    }

    private void getProductTags() throws IOException {

        Map<String, String> parms = converToParams("SectionCategoryId=1000&UserId=4000057&Type=1&Platform=android&Version=2.4.5&Auth=0&EquipmentCode=56acf4ca5e0711e698f91866da5cdd871470729629&Token=4e77af0ca26d236ff0e632c43241e3dc&AgentCode=ugirls");
//        Observable<ProductTagResult> productTag = api.getProductTag(parms);
//        api.getProductTag(parms)
//                .observeOn(Schedulers.newThread())
//                .subscribe(new Observer<ProductTagResult>() {
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                System.out.println("onSubscribe........");
//            }
//
//            @Override
//            public void onNext(ProductTagResult productTagResult) {
//                System.out.println("onNext........");
//                List<ProductTagResult.TagListbean> tagList = productTagResult.getTagList();
//                System.out.println(tagList.size());
//                for (ProductTagResult.TagListbean tagListbean : tagList) {
//                    System.out.println(tagListbean.getSTagName() + ", id:" + tagListbean.getITagId());
//                }
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("onError........");
//            }
//
//            @Override
//            public void onComplete() {
//                System.out.println("onComplete........");
//            }
//        });


        Call<ProductTagResult> call = api.getProductTag(parms);
        Response<ProductTagResult> execute = call.execute();
        ProductTagResult productTagResult = execute.body();
        List<ProductTagResult.TagListbean> tagList = productTagResult.getTagList();
        System.out.println(tagList.size());
        for (ProductTagResult.TagListbean tagListbean : tagList) {
            System.out.println(tagListbean.getSTagName() + ", id:" + tagListbean.getITagId());
            Product product = new Product();
            product.tagId = tagListbean.getITagId();
            product.tagName = tagListbean.getSTagName();
            products.add(product);
        }
    }

    private Map<String, String> converToParams(String str) {
        Map<String, String> result = new LinkedHashMap<>();
        String[] split = str.split("&");
        for (String s : split) {
            if (s.contains("=")) {
                String key = s.substring(0, s.indexOf("="));
                String value = s.substring(s.indexOf("=") + 1);
                result.put(key, value);
            }
        }
        return result;
    }

    private void getHomeData() {
//        try {
//            String url = "https://api.youguoquan.com/Users/Common/GetInfo";
//
//            Request request
//                    = HttpManager.getUGirlsPostRequest(url, userId, "1888");
//            String str = HttpLoader.load(request, "UTF-8");
//            Gson gson = new Gson();
//
//            String decode = decode(str);
//            appendData(userId + "," + decode);
//
//            UserInfo userInfo = gson.fromJson(decode, UserInfo.class);
//            UserInfo.UserInfoBean realInfo = userInfo.getUserInfo();
//            String dBalance = realInfo.getDBalance();
//            UserInfo.UserInfoBean.RoleBean role = realInfo.getRole();
//            int iIsVip = role.getIIsVip();
//            System.out.println(userId + ", balance:" + dBalance + ", vip:" + iIsVip + "," + decode);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            appendData(userId + ",FAIL");
//        }
    }

    public void appendData(String str) {
        try {
            bw.append(str + "\r\n");
            bw.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void getUserInfo(String userId) {
        try {
            String url = "https://api.youguoquan.com/Users/Common/GetInfo";

            Request request
                    = HttpManager.getUGirlsPostRequest(url, userId, "1888");
            String str = HttpLoader.load(request, "UTF-8");
            Gson gson = new Gson();

            String decode = UGrilUtil.decode(str);
            appendData(userId + "," + decode);

            UserInfo userInfo = gson.fromJson(decode, UserInfo.class);
            UserInfo.UserInfoBean realInfo = userInfo.getUserInfo();
            String dBalance = realInfo.getDBalance();
            UserInfo.UserInfoBean.RoleBean role = realInfo.getRole();
            int iIsVip = role.getIIsVip();
            System.out.println(userId + ", balance:" + dBalance + ", vip:" + iIsVip + "," + decode);

        } catch (Exception ex) {
            ex.printStackTrace();
            appendData(userId + ",FAIL");
        }
    }

    private void tryDownload() {

        for (int i = 2000153; i <= 5000000; i++) {

            try {
                String sUserId = i + "";
                download(sUserId, "1954");
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void tryUserInfo() {

        for (int i = 1387598; i <= 2000000; i++) {

            try {
                String sUserId = i + "";
                getUserInfo(sUserId);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
