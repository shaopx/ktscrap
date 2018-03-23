package com.spx.dev.ugirls.domain;

public class GetDownloadUrlResult {

    /**
     * Status : 1
     * Url : https://img.youguoquan.com/uploads/mobile/magazine/authed/attachment/2018/03/23/34/1995.zip?st=XxzxMnFMA7gOtw-VxaUmlA&e=1521797686
     * Name : 1995.zip
     * Msg : 获取下载地址成功
     */

    private int Status;
    private String Url;
    private String Name;
    private String Msg;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }
}
