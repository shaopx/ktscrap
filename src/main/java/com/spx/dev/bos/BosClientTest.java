package com.spx.dev.bos;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BucketSummary;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.PutObjectResponse;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class BosClientTest {

    public static final String ACCESS_KEY_ID = "";                   // 用户的Access Key ID
    public static final String SECRET_ACCESS_KEY = "";           // 用户的Secret Access Key
    public static final String xrsBucketName = "xiaorenshu";
    private BosClient client;

    public BosClientTest() {
        // 初始化一个BosClient
        BosClientConfiguration config = new BosClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY));
        client = new BosClient(config);
    }

    public void listBuckets() {
        // 获取用户的Bucket列表
        List<BucketSummary> buckets = client.listBuckets().getBuckets();

        // 遍历Bucket
        for (BucketSummary bucket : buckets) {
            System.out.println(bucket.getName());
        }
    }

    public void queryXiaoRenShu() {
        ListObjectsResponse xiaorenshu = client.listObjects("xiaorenshu");
        List<BosObjectSummary> contents = xiaorenshu.getContents();
        for (BosObjectSummary content : contents) {
            System.out.println(content.getKey() + ", " + content.getETag());
        }
    }

    public static void main(String[] args) {

        BosClientTest test = new BosClientTest();
//        test.listBuckets();
//        test.queryXiaoRenShu();
        test.putXiaoRenShu();
    }

    private void putXiaoRenShu() {
        String rootDir = "D:/data/xiaorenshu_109_2838/";
        List<String> firstChildDirs = getFirstChildDirs(rootDir);
        for (String firstChildDir : firstChildDirs) {
            System.out.println(firstChildDir);
            File file = new File(rootDir + "/" + firstChildDir);
            if (!file.isDirectory()) {
                continue;
            }
            if (firstChildDir.length() < 5) {
                continue;
            }

            int index = Integer.parseInt(firstChildDir.substring(0, 5));
            if (index < 663) {
                continue;
            }

            String[] list = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if (name.toLowerCase().endsWith("jpg") || name.toLowerCase().endsWith("jpeg")) {
                        return true;
                    }
                    return false;
                }
            });

            for (String fileName : list) {
                String key = firstChildDir + "/" + fileName;
                System.out.println(key);
                File uploadFile = new File(rootDir + key);
                if (!uploadFile.exists()) {
                    continue;
                }

                try {
                    putFile(xrsBucketName, key, uploadFile);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    try {
                        putFile(xrsBucketName, key, uploadFile);
                    } catch (Exception ex2) {
                        ex2.printStackTrace();
                        putFile(xrsBucketName, key, uploadFile);
                    }
                }
            }
        }


    }

    private void putFile(String bucketName, String key, File file) {
        PutObjectResponse putObjectResponse = client.putObject(bucketName, key, file);
        System.out.println("put " + key + " succeed!");
        System.out.println(putObjectResponse.getETag());
    }


    public static List<String> getFirstChildDirs(String dirPath) {
        File file = new File(dirPath);
        String[] list = file.list();
        List<String> dirs = new ArrayList<>();
        for (String s : list) {
//            System.out.println(s);
            File f = new File(file, s);
            if (f.isDirectory()) {
                dirs.add(s);
            }
        }
        return dirs;
    }

}

