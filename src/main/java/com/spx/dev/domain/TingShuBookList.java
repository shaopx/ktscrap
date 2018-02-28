package com.spx.dev.domain;

import java.util.List;

public class TingShuBookList {

    /**
     * list : [{"announcer":"单田芳","bookId":31754,"bookName":"辽沈战役","cover":"http://bookpic.lrts.me/904e730a3a6642a3a350a1090ab7b08b.jpg","desc":null,"hot":4254266,"payType":0,"recReason":null,"sections":30,"state":2,"strategy":0,"tags":null,"type":"单田芳","typeId":19,"updateTime":1476410172000},{"announcer":"单田芳","bookId":31753,"bookName":"铁伞怪侠","cover":"http://bookpic.lrts.me/ac298c4b33b44ea791e215a0d0a8b882.jpg","desc":null,"hot":40767346,"payType":0,"recReason":null,"sections":160,"state":2,"strategy":0,"tags":null,"type":"单田芳","typeId":19,"updateTime":1476409407000}]
     * msg : null
     * size : 97
     * status : 0
     */

    private Object msg;
    private int size;
    private int status;
    private List<Listbean> list;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Listbean> getList() {
        return list;
    }

    public void setList(List<Listbean> list) {
        this.list = list;
    }

    public static class Listbean {
        /**
         * announcer : 单田芳
         * bookId : 31754
         * bookName : 辽沈战役
         * cover : http://bookpic.lrts.me/904e730a3a6642a3a350a1090ab7b08b.jpg
         * desc : null
         * hot : 4254266
         * payType : 0
         * recReason : null
         * sections : 30
         * state : 2
         * strategy : 0
         * tags : null
         * type : 单田芳
         * typeId : 19
         * updateTime : 1476410172000
         */

        private String announcer;
        private int bookId;
        private String bookName;
        private String cover;
        private Object desc;
        private int hot;
        private int payType;
        private Object recReason;
        private int sections;
        private int state;
        private int strategy;
        private Object tags;
        private String type;
        private int typeId;
        private long updateTime;

        public String getAnnouncer() {
            return announcer;
        }

        public void setAnnouncer(String announcer) {
            this.announcer = announcer;
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public Object getDesc() {
            return desc;
        }

        public void setDesc(Object desc) {
            this.desc = desc;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public Object getRecReason() {
            return recReason;
        }

        public void setRecReason(Object recReason) {
            this.recReason = recReason;
        }

        public int getSections() {
            return sections;
        }

        public void setSections(int sections) {
            this.sections = sections;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getStrategy() {
            return strategy;
        }

        public void setStrategy(int strategy) {
            this.strategy = strategy;
        }

        public Object getTags() {
            return tags;
        }

        public void setTags(Object tags) {
            this.tags = tags;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
