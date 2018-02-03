package com.spx.dev;

import com.google.gson.Gson;
import com.spx.dev.domain.TopicResult;
import com.spx.dev.persist.FilePersistImpl;
import okhttp3.*;

import java.io.IOException;
import java.util.List;


public class TopicLoader {

    private String lastId = "";
    private boolean isEnd = false;

    public TopicLoader() {

    }

    private void load() throws InterruptedException, IOException {
        while (!isEnd) {
            loadOnce();
            Thread.sleep(1000);
        }
    }

    private void loadOnce() throws IOException {
        Request request
                = HttpManager.getJKPostJSONRequest("https://app.jike.ruguoapp.com/1.0/users/messages/history",
                "{\"loadMoreKey\":\"" + lastId + "\",\"topic\":\"58b6480a2275da0014628065\"}");
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
            String name = databean.getId();
            content = trimTopicContent(content);
            if (content.indexOf("，") > content.indexOf(" ") && content.indexOf(" ") > 0) {
                name = content.substring(0, content.indexOf(" ")) + "_" + id;
            } else if (content.indexOf("，") > 0) {
                name = content.substring(0, content.indexOf("，")) + "_" + id;
            }

            name = name.replace(" ", "");

            StringBuilder sb = new StringBuilder();
            sb.append("" + id).append("\r\n");
            sb.append(content + "\r\n");
            sb.append(databean.getContent());

            filePersist.onPersist("picture", name, id, sb.toString(), databean.getPictureUrls());
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
