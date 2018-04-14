package com.spx.dev.xiaorenshu;

import com.spx.dev.Util;

import java.util.List;

public class AlbumListResult {

    private List<Resultsbean> results;

    public List<Resultsbean> getResults() {
        return results;
    }

    public void setResults(List<Resultsbean> results) {
        this.results = results;
    }

    public static class Resultsbean {
        /**
         * cover : http://file.bmob.cn/M02/CF/08/oYYBAFZe-iKAEoCwAACKA2hZrWo059.jpg
         * createdAt : 2015-12-02 22:17:26
         * name : 英王陈玉成（抗清英雄传）
         * objectId : qy1Picci
         * updatedAt : 2017-07-17 04:08:21
         */
        public int index;
        private String cover;
        private String createdAt;
        private String name;
        private String objectId;
        private String updatedAt;

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

        public String getName() {
            return Util.getFormatIndex(index, 5) + "_" + name;
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

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
