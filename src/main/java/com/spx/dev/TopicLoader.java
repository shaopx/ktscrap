package com.spx.dev;

import com.google.gson.Gson;
import com.spx.dev.domain.JPersistData;
import com.spx.dev.domain.TopicResult;
import com.spx.dev.persist.FilePersistImpl;
import okhttp3.*;

import java.io.IOException;
import java.util.*;


public class TopicLoader {

    private String lastId = "";
    private boolean isEnd = false;


    private static LinkedHashMap<String, String> topics = new LinkedHashMap<>();
    static{
        topics.put("58d8aaa439765500116ab33b", "少女馆写真有更新");
        topics.put("5a151d2b9608fd0016c48a1d", "主要就是美女");
        topics.put("59bd45f2d09f940016b33dd0", "美女模特高清无水印图");
        topics.put("58b6480a2275da0014628065", "厦门校花");
    }

    private static  String topicId = "58d8aaa439765500116ab33b";
    private static String topicName = "少女馆写真有更新";

    public TopicLoader() {

    }

    public void load() throws InterruptedException, IOException {
        while (!isEnd) {
            loadOnce();
            Thread.sleep(1000);
        }
    }

    private void loadOnce() throws IOException {
        Request request
                = HttpManager.getJKPostJSONRequest("https://app.jike.ruguoapp.com/1.0/users/messages/history",
                "{\"loadMoreKey\":\"" + lastId + "\",\"topic\":\""+topicId+"\"}");
        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        TopicResult topicResult = gson.fromJson(str, TopicResult.class);
        lastId = topicResult.getLoadMoreKey();
        int size = topicResult.getData().size();
        System.out.println("size:" + size);
        System.out.println("lastId:" + lastId);
        if (size == 0 || lastId == null) {
            isEnd = true;
        }

        persist(topicResult);
    }

    private void persist(TopicResult topicResult) throws IOException {
        FilePersistImpl filePersist = new FilePersistImpl();
        List<TopicResult.Databean> data = topicResult.getData();
        for (int i = 0; i < data.size(); i++) {
            TopicResult.Databean databean = data.get(i);
            String id = databean.getId();
            String content = databean.getContent();

            String createdAt = databean.getCreatedAt();
            createdAt = createdAt.replace(":", "_");
            createdAt = createdAt.replace("-", "_");
            String name =createdAt+databean.getId();
            content = trimTopicContent(content);
//            if (content.indexOf("，") > content.indexOf(" ") && content.indexOf(" ") > 0) {
//                name = content.substring(0, content.indexOf(" ")) + "_" + id;
//            } else if (content.indexOf("，") > 0) {
//                name = content.substring(0, content.indexOf("，")) + "_" + id;
//            }

            name = name.replace(" ", "");

            StringBuilder sb = new StringBuilder();
            sb.append("" + id).append("\r\n");
            sb.append(content + "\r\n");
            sb.append(databean.getContent());

            try {
                List<JPersistData> imageUrls = new ArrayList<>();
                List<TopicResult.Databean.PictureUrlsbean> pictureUrls = databean.getPictureUrls();
                for (int i1 = 0; i1 < pictureUrls.size(); i1++) {
                    TopicResult.Databean.PictureUrlsbean pictureUrlsbean = pictureUrls.get(i1);
                    JPersistData picture = new JPersistData();
                    picture.url = pictureUrlsbean.getPicUrl();
                    picture.format=pictureUrlsbean.getFormat();
                    imageUrls.add(picture);
                }
                filePersist.onPersist(topicName, "picture", name, id, sb.toString(),imageUrls );
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    private String trimTopicContent(String content) {
        while (content.startsWith("#校花女神#")) {
            content = content.substring(6);
        }
        while (content.startsWith("她叫")) {
            content = content.substring(2);
        }
        while (content.startsWith("@")) {
            content = content.substring(1);
        }
        if (content.startsWith("#校花女神#她叫") && content.indexOf("，") > 8) {
            content = content.substring(8);
        }
        content = content.replace("#校花评比#", "");
        content = content.replace("❤", "");
//        if (content.indexOf("❤") > 0) {
//            content = content.substring(0, content.indexOf("❤"));
//        }
//        if (content.indexOf("@") > 0) {
//            content = content.substring(0, content.indexOf("@"));
//        }
        return content;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TopicLoader loader = new TopicLoader();
        loader.load();
    }


}
