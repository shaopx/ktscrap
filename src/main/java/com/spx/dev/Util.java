package com.spx.dev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Util {

    /**
     * 取北京时间
     *
     * @return
     */
    public static String getBeijingTime() {
        return getFormatedDateString(8, "yyyy-MM-dd HH:mm:ss");
    }

    public static int getBeijingHour() {
        String hour = getFormatedDateString(8, "HH");
        return Integer.parseInt(hour);
    }

    /**
     * 取班加罗尔时间
     *
     * @return
     */
    public static String getBangaloreTime() {
        return getFormatedDateString(5.5f, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 取纽约时间
     *
     * @return
     */
    public static String getNewyorkTime() {
        return getFormatedDateString(-5, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 此函数非原创，从网上搜索而来，timeZoneOffset原为int类型，为班加罗尔调整成float类型
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(float timeZoneOffset, String format) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }

        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    public static File mkdir(String name) {
        File file = new File(name);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void saveTextToFile(File dir, String fileName, String content) throws FileNotFoundException {
        File file = new File(dir, fileName);
        PrintWriter pw = new PrintWriter(file);
        pw.write(content);
        pw.close();
    }

    public static void downloadImages(File dir, List<String> imgs) {
        for (int i = 0; i < imgs.size(); i++) {
            String url = imgs.get(i);
            String fileName = getFormatIndex(i + 1, 4);
            String fileType = ".jpg";
            System.out.println("[" + i + "] dl url:" + url);
            DownloadUtil.get().download(url, dir.getAbsolutePath(), fileName + "" + fileType, "");
        }

    }

    public static String getFormatIndex(int i, int pad) {
        String s = "000000000000000000000" + i;
        return s.substring(s.length() - pad);
    }

    public static boolean isNull(String info) {
        return info == null || info.length() == 0 || info.equals("null");
    }

    public static String getHost(String url) {
        if (url.startsWith("http://")) {
            url = url.substring(7);
            if (url.indexOf("/") > 0) {
                url = url.substring(0, url.indexOf("/"));
            }
            return "http://" + url;
        }

        return url;
    }
}
