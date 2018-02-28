package com.spx.dev.domain;

import java.util.List;

public class TingShuChapterList {

    /**
     * bookId : 425
     * list : [{"buy":0,"downPrice":0,"feeType":0,"hasLyric":0,"id":769021955,"lastModify":1414531859000,"length":1386,"listenPrice":0,"name":"第001集_白眉大侠","path":"http://mting.info/asdb/storytelling/shantianfang/baimeidaxia/9rkkobad.mp3","payType":0,"plays":21120,"section":1,"size":5531722,"strategy":0},{"buy":0,"downPrice":0,"feeType":0,"hasLyric":0,"id":769281862,"lastModify":1414531859000,"length":1393,"listenPrice":0,"name":"第002集_白眉大侠","path":"http://mting.info/asdb/storytelling/shantianfang/baimeidaxia/p1adl9lz.mp3","payType":0,"plays":9001,"section":2,"size":5559935,"strategy":0}]
     * msg : null
     * sections : 400
     * status : 0
     * userType : 0
     */

    private int bookId;
    private Object msg;
    private int sections;
    private int status;
    private int userType;
    private List<Listbean> list;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<Listbean> getList() {
        return list;
    }

    public void setList(List<Listbean> list) {
        this.list = list;
    }

    public static class Listbean {
        /**
         * buy : 0
         * downPrice : 0.0
         * feeType : 0
         * hasLyric : 0
         * id : 769021955
         * lastModify : 1414531859000
         * length : 1386
         * listenPrice : 0.0
         * name : 第001集_白眉大侠
         * path : http://mting.info/asdb/storytelling/shantianfang/baimeidaxia/9rkkobad.mp3
         * payType : 0
         * plays : 21120
         * section : 1
         * size : 5531722
         * strategy : 0
         */

        private int buy;
        private double downPrice;
        private int feeType;
        private int hasLyric;
        private int id;
        private long lastModify;
        private int length;
        private double listenPrice;
        private String name;
        private String path;
        private int payType;
        private int plays;
        private int section;
        private int size;
        private int strategy;

        public int getBuy() {
            return buy;
        }

        public void setBuy(int buy) {
            this.buy = buy;
        }

        public double getDownPrice() {
            return downPrice;
        }

        public void setDownPrice(double downPrice) {
            this.downPrice = downPrice;
        }

        public int getFeeType() {
            return feeType;
        }

        public void setFeeType(int feeType) {
            this.feeType = feeType;
        }

        public int getHasLyric() {
            return hasLyric;
        }

        public void setHasLyric(int hasLyric) {
            this.hasLyric = hasLyric;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getLastModify() {
            return lastModify;
        }

        public void setLastModify(long lastModify) {
            this.lastModify = lastModify;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public double getListenPrice() {
            return listenPrice;
        }

        public void setListenPrice(double listenPrice) {
            this.listenPrice = listenPrice;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public int getPlays() {
            return plays;
        }

        public void setPlays(int plays) {
            this.plays = plays;
        }

        public int getSection() {
            return section;
        }

        public void setSection(int section) {
            this.section = section;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStrategy() {
            return strategy;
        }

        public void setStrategy(int strategy) {
            this.strategy = strategy;
        }
    }
}
