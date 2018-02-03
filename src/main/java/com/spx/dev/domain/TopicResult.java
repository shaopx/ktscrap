package com.spx.dev.domain;

import java.util.List;

public class TopicResult {

    /**
     * data : [{"id":"5a755ed51195300017dc478e","content":"#校花女神#她叫吴璐妍，99年，就读于三亚学院，身高168cm，你觉得几分呢？❤@iYiEEK-WU #校花评比#","title":"有新的校花美女分享","messageId":174066659,"topicId":33075,"linkUrl":"https://article.jike.ruguoapp.com/?messageId=5a755ed51195300017dc478e","originalLinkUrl":"https://m.weibo.cn/2731172954/G1peRheKp","videoLink":"","audioLink":"","sourceRawValue":"link","iconUrl":null,"collectCount":109,"commentCount":16,"popularity":109,"repostCount":10,"likeCount":36,"author":"厦门校花","withPush":true,"collected":false,"liked":false,"createdAt":"2018-02-03T07:03:49.131Z","updatedAt":"2018-02-03T08:48:09.217Z","isCommentForbidden":false,"messageType":"NORMAL","targetId":"5a755ed485b88900174baf6c","topic":{"id":"58b6480a2275da0014628065","content":"有新的校花美女分享","subscribersCount":588365,"thumbnailUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30","squarePicture":{"thumbnailUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30","middlePicUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/300/h/300/format/jpeg/q/30","picUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/h/1000/format/jpeg/interlace/0/q/30","format":"jpeg"},"isValid":true,"operateStatus":"ONLINE","subscribedStatusRawValue":2,"enablePictureComments":true},"pictureUrls":[{"thumbnailUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/300/q/30","smallPicUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/400/q/30","middlePicUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/600/interlace/1/q/30","picUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/2000/interlace/1","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":1080,"height":1438}]}]
     * loadMoreKey : 5a70802d3cf9c100115462cb
     */

    private String loadMoreKey;
    private List<Databean> data;

    public String getLoadMoreKey() {
        return loadMoreKey;
    }

    public void setLoadMoreKey(String loadMoreKey) {
        this.loadMoreKey = loadMoreKey;
    }

    public List<Databean> getData() {
        return data;
    }

    public void setData(List<Databean> data) {
        this.data = data;
    }

    public static class Databean {
        /**
         * id : 5a755ed51195300017dc478e
         * content : #校花女神#她叫吴璐妍，99年，就读于三亚学院，身高168cm，你觉得几分呢？❤@iYiEEK-WU #校花评比#
         * title : 有新的校花美女分享
         * messageId : 174066659
         * topicId : 33075
         * linkUrl : https://article.jike.ruguoapp.com/?messageId=5a755ed51195300017dc478e
         * originalLinkUrl : https://m.weibo.cn/2731172954/G1peRheKp
         * videoLink :
         * audioLink :
         * sourceRawValue : link
         * iconUrl : null
         * collectCount : 109
         * commentCount : 16
         * popularity : 109
         * repostCount : 10
         * likeCount : 36
         * author : 厦门校花
         * withPush : true
         * collected : false
         * liked : false
         * createdAt : 2018-02-03T07:03:49.131Z
         * updatedAt : 2018-02-03T08:48:09.217Z
         * isCommentForbidden : false
         * messageType : NORMAL
         * targetId : 5a755ed485b88900174baf6c
         * topic : {"id":"58b6480a2275da0014628065","content":"有新的校花美女分享","subscribersCount":588365,"thumbnailUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30","squarePicture":{"thumbnailUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30","middlePicUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/300/h/300/format/jpeg/q/30","picUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/h/1000/format/jpeg/interlace/0/q/30","format":"jpeg"},"isValid":true,"operateStatus":"ONLINE","subscribedStatusRawValue":2,"enablePictureComments":true}
         * pictureUrls : [{"thumbnailUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/300/q/30","smallPicUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/400/q/30","middlePicUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/600/interlace/1/q/30","picUrl":"https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/2000/interlace/1","cropperPosX":0.5,"cropperPosY":0.5,"format":"jpeg","width":1080,"height":1438}]
         */

        private String id;
        private String content;
        private String title;
        private int messageId;
        private int topicId;
        private String linkUrl;
        private String originalLinkUrl;
        private String videoLink;
        private String audioLink;
        private String sourceRawValue;
        private Object iconUrl;
        private int collectCount;
        private int commentCount;
        private int popularity;
        private int repostCount;
        private int likeCount;
        private String author;
        private boolean withPush;
        private boolean collected;
        private boolean liked;
        private String createdAt;
        private String updatedAt;
        private boolean isCommentForbidden;
        private String messageType;
        private String targetId;
        private Topicbean topic;
        private List<PictureUrlsbean> pictureUrls;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getMessageId() {
            return messageId;
        }

        public void setMessageId(int messageId) {
            this.messageId = messageId;
        }

        public int getTopicId() {
            return topicId;
        }

        public void setTopicId(int topicId) {
            this.topicId = topicId;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public String getOriginalLinkUrl() {
            return originalLinkUrl;
        }

        public void setOriginalLinkUrl(String originalLinkUrl) {
            this.originalLinkUrl = originalLinkUrl;
        }

        public String getVideoLink() {
            return videoLink;
        }

        public void setVideoLink(String videoLink) {
            this.videoLink = videoLink;
        }

        public String getAudioLink() {
            return audioLink;
        }

        public void setAudioLink(String audioLink) {
            this.audioLink = audioLink;
        }

        public String getSourceRawValue() {
            return sourceRawValue;
        }

        public void setSourceRawValue(String sourceRawValue) {
            this.sourceRawValue = sourceRawValue;
        }

        public Object getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(Object iconUrl) {
            this.iconUrl = iconUrl;
        }

        public int getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getPopularity() {
            return popularity;
        }

        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }

        public int getRepostCount() {
            return repostCount;
        }

        public void setRepostCount(int repostCount) {
            this.repostCount = repostCount;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isWithPush() {
            return withPush;
        }

        public void setWithPush(boolean withPush) {
            this.withPush = withPush;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public boolean isIsCommentForbidden() {
            return isCommentForbidden;
        }

        public void setIsCommentForbidden(boolean isCommentForbidden) {
            this.isCommentForbidden = isCommentForbidden;
        }

        public String getMessageType() {
            return messageType;
        }

        public void setMessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }

        public Topicbean getTopic() {
            return topic;
        }

        public void setTopic(Topicbean topic) {
            this.topic = topic;
        }

        public List<PictureUrlsbean> getPictureUrls() {
            return pictureUrls;
        }

        public void setPictureUrls(List<PictureUrlsbean> pictureUrls) {
            this.pictureUrls = pictureUrls;
        }

        public static class Topicbean {
            /**
             * id : 58b6480a2275da0014628065
             * content : 有新的校花美女分享
             * subscribersCount : 588365
             * thumbnailUrl : https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30
             * squarePicture : {"thumbnailUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30","middlePicUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/300/h/300/format/jpeg/q/30","picUrl":"https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/h/1000/format/jpeg/interlace/0/q/30","format":"jpeg"}
             * isValid : true
             * operateStatus : ONLINE
             * subscribedStatusRawValue : 2
             * enablePictureComments : true
             */

            private String id;
            private String content;
            private int subscribersCount;
            private String thumbnailUrl;
            private SquarePicturebean squarePicture;
            private boolean isValid;
            private String operateStatus;
            private int subscribedStatusRawValue;
            private boolean enablePictureComments;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getSubscribersCount() {
                return subscribersCount;
            }

            public void setSubscribersCount(int subscribersCount) {
                this.subscribersCount = subscribersCount;
            }

            public String getThumbnailUrl() {
                return thumbnailUrl;
            }

            public void setThumbnailUrl(String thumbnailUrl) {
                this.thumbnailUrl = thumbnailUrl;
            }

            public SquarePicturebean getSquarePicture() {
                return squarePicture;
            }

            public void setSquarePicture(SquarePicturebean squarePicture) {
                this.squarePicture = squarePicture;
            }

            public boolean isIsValid() {
                return isValid;
            }

            public void setIsValid(boolean isValid) {
                this.isValid = isValid;
            }

            public String getOperateStatus() {
                return operateStatus;
            }

            public void setOperateStatus(String operateStatus) {
                this.operateStatus = operateStatus;
            }

            public int getSubscribedStatusRawValue() {
                return subscribedStatusRawValue;
            }

            public void setSubscribedStatusRawValue(int subscribedStatusRawValue) {
                this.subscribedStatusRawValue = subscribedStatusRawValue;
            }

            public boolean isEnablePictureComments() {
                return enablePictureComments;
            }

            public void setEnablePictureComments(boolean enablePictureComments) {
                this.enablePictureComments = enablePictureComments;
            }

            public static class SquarePicturebean {
                /**
                 * thumbnailUrl : https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/120/h/120/format/jpeg/q/30
                 * middlePicUrl : https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/w/300/h/300/format/jpeg/q/30
                 * picUrl : https://cdn.ruguoapp.com/FhmfdTt1OQzRFxUS32NnDhwjaghy.jpg?imageView2/1/h/1000/format/jpeg/interlace/0/q/30
                 * format : jpeg
                 */

                private String thumbnailUrl;
                private String middlePicUrl;
                private String picUrl;
                private String format;

                public String getThumbnailUrl() {
                    return thumbnailUrl;
                }

                public void setThumbnailUrl(String thumbnailUrl) {
                    this.thumbnailUrl = thumbnailUrl;
                }

                public String getMiddlePicUrl() {
                    return middlePicUrl;
                }

                public void setMiddlePicUrl(String middlePicUrl) {
                    this.middlePicUrl = middlePicUrl;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }
            }
        }

        public static class PictureUrlsbean {
            /**
             * thumbnailUrl : https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/300/q/30
             * smallPicUrl : https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/w/2000/h/400/q/30
             * middlePicUrl : https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/600/interlace/1/q/30
             * picUrl : https://cdn.ruguoapp.com/0823289b9c8067062b5f82728ffcdb5b?imageView2/0/h/2000/interlace/1
             * cropperPosX : 0.5
             * cropperPosY : 0.5
             * format : jpeg
             * width : 1080
             * height : 1438
             */

            private String thumbnailUrl;
            private String smallPicUrl;
            private String middlePicUrl;
            private String picUrl;
            private double cropperPosX;
            private double cropperPosY;
            private String format;
            private int width;
            private int height;

            public String getThumbnailUrl() {
                return thumbnailUrl;
            }

            public void setThumbnailUrl(String thumbnailUrl) {
                this.thumbnailUrl = thumbnailUrl;
            }

            public String getSmallPicUrl() {
                return smallPicUrl;
            }

            public void setSmallPicUrl(String smallPicUrl) {
                this.smallPicUrl = smallPicUrl;
            }

            public String getMiddlePicUrl() {
                return middlePicUrl;
            }

            public void setMiddlePicUrl(String middlePicUrl) {
                this.middlePicUrl = middlePicUrl;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public double getCropperPosX() {
                return cropperPosX;
            }

            public void setCropperPosX(double cropperPosX) {
                this.cropperPosX = cropperPosX;
            }

            public double getCropperPosY() {
                return cropperPosY;
            }

            public void setCropperPosY(double cropperPosY) {
                this.cropperPosY = cropperPosY;
            }

            public String getFormat() {
                return format;
            }

            public void setFormat(String format) {
                this.format = format;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}