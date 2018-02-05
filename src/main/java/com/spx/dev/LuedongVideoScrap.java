package com.spx.dev;

import com.google.gson.Gson;
import com.spx.dev.domain.JPersistData;
import com.spx.dev.domain.LdTopicResult;
import com.spx.dev.domain.TopicResult;
import com.spx.dev.persist.FilePersistImpl;
import okhttp3.Request;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LuedongVideoScrap {

    private String downAnthor = "";
    private boolean isEnd = false;

    private static final List<ScrapTarget> targets = new ArrayList<>();
    static {
        targets.add(new ScrapTarget("500648", "宅男必备的宅舞推荐"));
    }

    private String targetTopicId = targets.get(targets.size()-1).topicId;
    private String targetTopicName = targets.get(targets.size()-1).topicName;

    public void load() throws InterruptedException, IOException {
        while (!isEnd) {
            loadOnce();
            Thread.sleep(1000);
        }
    }

    private void loadOnce() throws IOException {
        String luedongUrl = "https://ldapi.sogou.com/wapi/ldapp/topicpage-feedlist?topicId="+targetTopicId+"&limit=20";
        if(downAnthor!=null && downAnthor.length()>0){
            luedongUrl+="&locationAnchor="+downAnthor;
        }
        Request request
                = HttpManager.getLuedongRequst(luedongUrl);
        String str = HttpLoader.load(request);
        Gson gson = new Gson();
        LdTopicResult topicResult = gson.fromJson(str, LdTopicResult.class);
        downAnthor = topicResult.getData().getSlipdownAnchor();
        int size = topicResult.getData().getDataList().size();
        System.out.println("size:" + size);
        System.out.println("downAnthor:" + downAnthor);
        if (size == 0 || downAnthor == null) {
            isEnd = true;
        }

        persist(topicResult);
    }

    private void persist(LdTopicResult topicResult) throws IOException {
        FilePersistImpl filePersist = new FilePersistImpl("d:/data/luedong");
        List<LdTopicResult.Databean.DataListbean> dataList = topicResult.getData().getDataList();
        for (int i = 0; i < dataList.size(); i++) {
            LdTopicResult.Databean.DataListbean dataListbean = dataList.get(i);
            LdTopicResult.Databean.DataListbean.YsArticleInfobean ysArticleInfo = dataListbean.getYsArticleInfo();
            if(ysArticleInfo==null){
                continue;
            }

            String id = ysArticleInfo.get_$Id178()+"";
            long createTime = ysArticleInfo.getCreateTime() *1000L;

            String srcUrl = ysArticleInfo.getSrcUrl();
            Date date = new Date(createTime);
            SimpleDateFormat df=new SimpleDateFormat("yyyy_MM_dd_hhmmss");
            String time=df.format(date);
            System.out.println("createTime:"+createTime +", time:"+time);
            List<LdTopicResult.Databean.DataListbean.YsArticleInfobean.Videosbean> videos = ysArticleInfo.getVideos();

            if(videos==null || videos.size()==0){
                continue;
            }



            String title = ysArticleInfo.getTitle();
            System.out.println("title:"+title);

            String subDirName = time;
//            if (title != null) {
//                subDirName = subDirName + "" + (title.length() > 20 ? title.substring(0, 20) : title);
//            }
            subDirName = format(subDirName);
            System.out.println("subDirName:"+subDirName);
            try {
                List<JPersistData> persistData = new ArrayList<>();

                for (int i1 = 0; i1 < videos.size(); i1++) {
                    LdTopicResult.Databean.DataListbean.YsArticleInfobean.Videosbean videosbean = videos.get(i1);
                    JPersistData video = new JPersistData();
                    video.url = videosbean.getVideoUrl();
                    video.format=".mp4";
                    video.refer = srcUrl;
                    persistData.add(video);
                    JPersistData picture = new JPersistData();
                    picture.url = videosbean.getVideoPic();
                    picture.format=".jpeg";
                    persistData.add(picture);
                }
                filePersist.onPersist(targetTopicName, "video", subDirName, id, title,persistData );
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    private String format(String subDirName) {
        subDirName  =subDirName.replace("\\", "");
        subDirName  =subDirName.replace("/", "");
        subDirName  =subDirName.replace("(", "");
        subDirName  =subDirName.replace(")", "");
        subDirName  =subDirName.replace("*", "");
        subDirName  =subDirName.replace("▽", "");
        subDirName  =subDirName.replace("o", "");
        subDirName  =subDirName.replace("！", "");
        subDirName  =subDirName.replace("O", "");
        subDirName  =subDirName.replace("❀", "");
        subDirName  =subDirName.replace(" ", "");
        return subDirName;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LuedongVideoScrap scrap = new LuedongVideoScrap();
        scrap.load();
    }
}
