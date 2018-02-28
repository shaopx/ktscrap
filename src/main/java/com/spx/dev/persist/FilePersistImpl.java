package com.spx.dev.persist;

import com.spx.dev.DownloadUtil;
import com.spx.dev.domain.JPersistData;

import java.io.*;
import java.util.List;

public class FilePersistImpl implements IPersistence {
    public static final String ROOT = "d:/data/jike";
    private String rootDir = ROOT;
    public FilePersistImpl(){
        this(ROOT);
    }
    public FilePersistImpl(String root){
        rootDir = root;
    }

    @Override
    public void onPersist(String tipicName, String type, String subDirName, String id,  String textContent, List<JPersistData> pictures) throws IOException {
        System.out.println("tipicName:"+tipicName+", type:"+type+", subDirName:"+subDirName+", id:"+id+", textContent:"+textContent);
        File rootFile = new File(rootDir+"/"+type, tipicName);
        if (!rootFile.exists()) {
            rootFile.mkdirs();
        }

        File subDir = new File(rootFile, subDirName);
        if (!subDir.exists()) {
            subDir.mkdir();
        }

        File infoFile = new File(subDir, "info.txt");
        if (!infoFile.exists()) {
            try {
                infoFile.createNewFile();
            } catch (Exception ex) {
                System.out.println(subDir + " not valid!");
                throw ex;
            }
        }
        System.out.println("persist ==================================");
        System.out.println("persist :"+textContent);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(textContent.getBytes());
        copyStream(inputStream,  new FileOutputStream(infoFile));

        for (int i = 0; i < pictures.size(); i++) {
            JPersistData persistData = pictures.get(i);
            System.out.println("download picture :"+persistData.url);
            if(persistData.saveName==null){
                DownloadUtil.get().download(persistData.url, subDir.getAbsolutePath(),
                        id+"_"+i+"."+persistData.format, persistData);
            } else {
                DownloadUtil.get().download(persistData.url, subDir.getAbsolutePath(),
                        persistData.saveName+"."+persistData.format, persistData);
            }

        }

    }

    public static boolean saveTextToFile(String str,
                                           String fileNamePath) throws IOException {
        boolean result = true;

        File f = null;
        try {
            f = new File(fileNamePath);
            if (f.exists()) {
                f.delete();
            } else {
                f.createNewFile();
            }

            ByteArrayInputStream inputStream = new ByteArrayInputStream(str.getBytes());

            FileOutputStream fos = new FileOutputStream(f);
            copyStream(inputStream, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            if (f != null && f.exists()) {
                f.delete();
            }
            result = false;
        }
        return result;
    }

    public static void copyStream(InputStream in, OutputStream out)
            throws IOException {
        BufferedInputStream bin = new BufferedInputStream(in);
        BufferedOutputStream bout = new BufferedOutputStream(out);

        byte[] buffer = new byte[4096];

        while (true) {
            int doneLength = bin.read(buffer);
            if (doneLength == -1)
                break;
            bout.write(buffer, 0, doneLength);
        }
        bin.close();
        bout.flush();
        bout.close();
    }
}
