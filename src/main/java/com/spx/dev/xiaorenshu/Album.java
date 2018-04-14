package com.spx.dev.xiaorenshu;

import java.util.List;

public class Album {

    /**
     * cover : http://ofuaex81c.bkt.clouddn.com/mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/101.jpg
     * createdAt : 2017-01-02 09:25:35
     * descri : 07何秀女布施成仙
     * download : bxdcsqcb070zghp0hxnbscx&&&mmwh/xxs/lhh/download/5/bxdcsqcb070zghp0hxnbscx.zip
     * from : readlimit&&&http://ofuaex81c.bkt.clouddn.com/
     * imgs : ["mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/101.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/102.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/103.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/104.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/105.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/106.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/107.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/108.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/109.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/110.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/111.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/112.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/113.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/114.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/115.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/116.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/117.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/118.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/119.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/120.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/121.jpg","mmwh/xxs/lhh/image/5/bxdcsqcb070zghp0hxnbscx/122.jpg"]
     * length : 1.2
     * name : 07何秀女布施成仙
     * objectId : 927f1f0cb6
     * price : 0
     * status : 1
     * type : 3
     * updatedAt : 2017-07-17 04:35:30
     */

    private String cover;
    private String createdAt;
    private String descri;
    private String download;
    private String from;
    private double length;
    private String name;
    private String objectId;
    private int price;
    private int status;
    private int type;
    private String updatedAt;
    private List<String> imgs;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }
}
