package com.spx.dev.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LdTopicResult {

    @SerializedName("result")
    private Resultbean resultbean; // FIXME check this code
    private Databean data;

    public Resultbean getResultbean() {
        return resultbean;
    }

    public Databean getData() {
        return data;
    }

    public void setData(Databean data) {
        this.data = data;
    }

    public static class Resultbean {
        /**
         * errno : 0
         * errmsg : 操作成功
         * cur_timestamp : 1517803317777
         */

        private int errno;
        private String errmsg;
        private long cur_timestamp;

        public int getErrno() {
            return errno;
        }

        public void setErrno(int errno) {
            this.errno = errno;
        }

        public String getErrmsg() {
            return errmsg;
        }

        public void setErrmsg(String errmsg) {
            this.errmsg = errmsg;
        }

        public long getCur_timestamp() {
            return cur_timestamp;
        }

        public void setCur_timestamp(long cur_timestamp) {
            this.cur_timestamp = cur_timestamp;
        }
    }

    public static class Databean {
        @SerializedName("slipupAnchor")
        private String _$SlipupAnchor315; // FIXME check this code
        private String slipdownAnchor;
        private TopicInfobean topicInfo;
        private List<DataListbean> dataList;

        public String get_$SlipupAnchor315() {
            return _$SlipupAnchor315;
        }

        public void set_$SlipupAnchor315(String _$SlipupAnchor315) {
            this._$SlipupAnchor315 = _$SlipupAnchor315;
        }

        public String getSlipdownAnchor() {
            return slipdownAnchor;
        }

        public void setSlipdownAnchor(String slipdownAnchor) {
            this.slipdownAnchor = slipdownAnchor;
        }

        public TopicInfobean getTopicInfo() {
            return topicInfo;
        }

        public void setTopicInfo(TopicInfobean topicInfo) {
            this.topicInfo = topicInfo;
        }

        public List<DataListbean> getDataList() {
            return dataList;
        }

        public void setDataList(List<DataListbean> dataList) {
            this.dataList = dataList;
        }

        public static class TopicInfobean {
            /**
             * tag_id : 500648
             * tag_name : 宅男必备的宅舞推荐
             * icon : http://img02.sogoucdn.com/v2/thumb/resize/w/500/t/1/retype/ext/auto/q/75?appid=200698&url=http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20170929115805-323660013_jpeg_300_300_19267/500
             * desc : 御宅总是很完美
             * followedNum : 115
             * contentNum : 181
             * isCurUserFollow : 0
             * belongTags : [{"tag_id":105,"tag_name":"动漫","icon":"http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20170122160807-743545436/500","desc":"这里是通往动漫世界的入口，欢迎二次元中毒患者加入。","followedNum":389464,"contentNum":5470,"isCurUserFollow":0,"pushStatus":0,"defaultPushStatus":0,"select":0,"type":0}]
             * flowerRankUsers : [{"uid":5869079,"nickName":"明媚的忧伤","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420175401-309396594_jpeg_200_200_12055.jpg"},{"uid":5866968,"nickName":"Ted","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420174502-840181057_jpeg_200_200_12580.jpg"},{"uid":5866969,"nickName":"STONE","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420174503-1851463378_jpeg_200_200_5457.jpg"},{"uid":5867717,"nickName":"单身情哥","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420174816-80379538_jpeg_200_200_10474.jpg"},{"uid":5867716,"nickName":"斗牛士","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420174815-894181483_jpeg_200_200_7316.jpg"},{"uid":5869549,"nickName":"Way","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420175607-1611875515_jpeg_200_200_7964.jpg"},{"uid":5866680,"nickName":"激情飞扬","portraitUrl":"http://pic.wenwen.soso.com/p/20170420/20170420174352-1316759980_jpeg_200_200_12303.jpg"}]
             * pushStatus : 0
             * defaultPushStatus : 1
             * select : 0
             * type : 0
             */

            private int tag_id;
            private String tag_name;
            private String icon;
            private String desc;
            private int followedNum;
            private int contentNum;
            private int isCurUserFollow;
            private int pushStatus;
            private int defaultPushStatus;
            private int select;
            private int type;
            private List<BelongTagsbean> belongTags;
            private List<FlowerRankUsersbean> flowerRankUsers;

            public int getTag_id() {
                return tag_id;
            }

            public void setTag_id(int tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getFollowedNum() {
                return followedNum;
            }

            public void setFollowedNum(int followedNum) {
                this.followedNum = followedNum;
            }

            public int getContentNum() {
                return contentNum;
            }

            public void setContentNum(int contentNum) {
                this.contentNum = contentNum;
            }

            public int getIsCurUserFollow() {
                return isCurUserFollow;
            }

            public void setIsCurUserFollow(int isCurUserFollow) {
                this.isCurUserFollow = isCurUserFollow;
            }

            public int getPushStatus() {
                return pushStatus;
            }

            public void setPushStatus(int pushStatus) {
                this.pushStatus = pushStatus;
            }

            public int getDefaultPushStatus() {
                return defaultPushStatus;
            }

            public void setDefaultPushStatus(int defaultPushStatus) {
                this.defaultPushStatus = defaultPushStatus;
            }

            public int getSelect() {
                return select;
            }

            public void setSelect(int select) {
                this.select = select;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public List<BelongTagsbean> getBelongTags() {
                return belongTags;
            }

            public void setBelongTags(List<BelongTagsbean> belongTags) {
                this.belongTags = belongTags;
            }

            public List<FlowerRankUsersbean> getFlowerRankUsers() {
                return flowerRankUsers;
            }

            public void setFlowerRankUsers(List<FlowerRankUsersbean> flowerRankUsers) {
                this.flowerRankUsers = flowerRankUsers;
            }

            public static class BelongTagsbean {
                /**
                 * tag_id : 105
                 * tag_name : 动漫
                 * icon : http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20170122160807-743545436/500
                 * desc : 这里是通往动漫世界的入口，欢迎二次元中毒患者加入。
                 * followedNum : 389464
                 * contentNum : 5470
                 * isCurUserFollow : 0
                 * pushStatus : 0
                 * defaultPushStatus : 0
                 * select : 0
                 * type : 0
                 */

                private int tag_id;
                private String tag_name;
                private String icon;
                private String desc;
                private int followedNum;
                private int contentNum;
                private int isCurUserFollow;
                private int pushStatus;
                private int defaultPushStatus;
                private int select;
                private int type;

                public int getTag_id() {
                    return tag_id;
                }

                public void setTag_id(int tag_id) {
                    this.tag_id = tag_id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getFollowedNum() {
                    return followedNum;
                }

                public void setFollowedNum(int followedNum) {
                    this.followedNum = followedNum;
                }

                public int getContentNum() {
                    return contentNum;
                }

                public void setContentNum(int contentNum) {
                    this.contentNum = contentNum;
                }

                public int getIsCurUserFollow() {
                    return isCurUserFollow;
                }

                public void setIsCurUserFollow(int isCurUserFollow) {
                    this.isCurUserFollow = isCurUserFollow;
                }

                public int getPushStatus() {
                    return pushStatus;
                }

                public void setPushStatus(int pushStatus) {
                    this.pushStatus = pushStatus;
                }

                public int getDefaultPushStatus() {
                    return defaultPushStatus;
                }

                public void setDefaultPushStatus(int defaultPushStatus) {
                    this.defaultPushStatus = defaultPushStatus;
                }

                public int getSelect() {
                    return select;
                }

                public void setSelect(int select) {
                    this.select = select;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class FlowerRankUsersbean {
                /**
                 * uid : 5869079
                 * nickName : 明媚的忧伤
                 * portraitUrl : http://pic.wenwen.soso.com/p/20170420/20170420175401-309396594_jpeg_200_200_12055.jpg
                 */

                private int uid;
                private String nickName;
                private String portraitUrl;

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getPortraitUrl() {
                    return portraitUrl;
                }

                public void setPortraitUrl(String portraitUrl) {
                    this.portraitUrl = portraitUrl;
                }
            }
        }

        public static class DataListbean {
            @SerializedName("type")
            private String _$Type1; // FIXME check this code
            private YsArticleInfobean ysArticleInfo;

            public String get_$Type1() {
                return _$Type1;
            }

            public void set_$Type1(String _$Type1) {
                this._$Type1 = _$Type1;
            }

            public YsArticleInfobean getYsArticleInfo() {
                return ysArticleInfo;
            }

            public void setYsArticleInfo(YsArticleInfobean ysArticleInfo) {
                this.ysArticleInfo = ysArticleInfo;
            }

            public static class YsArticleInfobean {
                @SerializedName("id")
                private int _$Id178; // FIXME check this code
                private String title;
                private int reason;
                private Object reasonStr;
                private int createTime;
                private String simpleContent;
                private int hasVideo;
                private Object yuntuPics;
                private int pvNum;
                private String srcUrl;
                private int openType;
                private Object userList;
                private int userNum;
                private String srcName;
                private int status;
                private int isCurUserCollect;
                private int isCurUserPraise;
                private int praisedNum;
                private int collectNum;
                private int commentNum;
                private List<TopicInfobean> tagList;
                private List<TopicInfobean> topicList;
                private List<Videosbean> videos;
                private List<?> pics;

                public int get_$Id178() {
                    return _$Id178;
                }

                public void set_$Id178(int _$Id178) {
                    this._$Id178 = _$Id178;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getReason() {
                    return reason;
                }

                public void setReason(int reason) {
                    this.reason = reason;
                }

                public Object getReasonStr() {
                    return reasonStr;
                }

                public void setReasonStr(Object reasonStr) {
                    this.reasonStr = reasonStr;
                }

                public int getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(int createTime) {
                    this.createTime = createTime;
                }

                public String getSimpleContent() {
                    return simpleContent;
                }

                public void setSimpleContent(String simpleContent) {
                    this.simpleContent = simpleContent;
                }

                public int getHasVideo() {
                    return hasVideo;
                }

                public void setHasVideo(int hasVideo) {
                    this.hasVideo = hasVideo;
                }

                public Object getYuntuPics() {
                    return yuntuPics;
                }

                public void setYuntuPics(Object yuntuPics) {
                    this.yuntuPics = yuntuPics;
                }

                public int getPvNum() {
                    return pvNum;
                }

                public void setPvNum(int pvNum) {
                    this.pvNum = pvNum;
                }

                public String getSrcUrl() {
                    return srcUrl;
                }

                public void setSrcUrl(String srcUrl) {
                    this.srcUrl = srcUrl;
                }

                public int getOpenType() {
                    return openType;
                }

                public void setOpenType(int openType) {
                    this.openType = openType;
                }

                public Object getUserList() {
                    return userList;
                }

                public void setUserList(Object userList) {
                    this.userList = userList;
                }

                public int getUserNum() {
                    return userNum;
                }

                public void setUserNum(int userNum) {
                    this.userNum = userNum;
                }

                public String getSrcName() {
                    return srcName;
                }

                public void setSrcName(String srcName) {
                    this.srcName = srcName;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getIsCurUserCollect() {
                    return isCurUserCollect;
                }

                public void setIsCurUserCollect(int isCurUserCollect) {
                    this.isCurUserCollect = isCurUserCollect;
                }

                public int getIsCurUserPraise() {
                    return isCurUserPraise;
                }

                public void setIsCurUserPraise(int isCurUserPraise) {
                    this.isCurUserPraise = isCurUserPraise;
                }

                public int getPraisedNum() {
                    return praisedNum;
                }

                public void setPraisedNum(int praisedNum) {
                    this.praisedNum = praisedNum;
                }

                public int getCollectNum() {
                    return collectNum;
                }

                public void setCollectNum(int collectNum) {
                    this.collectNum = collectNum;
                }

                public int getCommentNum() {
                    return commentNum;
                }

                public void setCommentNum(int commentNum) {
                    this.commentNum = commentNum;
                }

                public List<TopicInfobean> getTagList() {
                    return tagList;
                }

                public void setTagList(List<TopicInfobean> tagList) {
                    this.tagList = tagList;
                }

                public List<TopicInfobean> getTopicList() {
                    return topicList;
                }

                public void setTopicList(List<TopicInfobean> topicList) {
                    this.topicList = topicList;
                }

                public List<Videosbean> getVideos() {
                    return videos;
                }

                public void setVideos(List<Videosbean> videos) {
                    this.videos = videos;
                }

                public List<?> getPics() {
                    return pics;
                }

                public void setPics(List<?> pics) {
                    this.pics = pics;
                }

                public static class Videosbean {
                    /**
                     * videoUrl : http://upos-hz-mirrorkodo.acgvideo.com/upgcxcode/79/93/31039379/31039379-1-6.mp4?e=ig8g5X10ugNcXBlqNCNEto8g5gNvNE3DN0B59rVE2F8m5JUEnENBhwdVhwdlhWdVhwdVho8_&platform=html5&uipk=5&uipv=5&deadline=1517800205&gen=playurl&um_deadline=1517800205&rate=65000&um_sign=b18865b1cbd6dcfdd61168f214ee86f1&dynamic=1&os=kodo&oi=2071821818&upsig=8a12b3274f6cb018b14ed8e3208fe628
                     * videoDuration : 0
                     * videoPic : http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20180203102005-2096853709_jpeg_2144_1340_384398/
                     * yuntuVideoPic : {"originUrl":"http://img04.sogoucdn.com/v2/thumb/resize/w/1080/t/1/retype/ext/auto/q/75?appid=200698&url=http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20180203102005-2096853709_jpeg_2144_1340_384398/0","yuntuUrl":"http://img04.sogoucdn.com/v2/thumb/resize/w/500/t/1/retype/ext/auto/q/75?appid=200698&url=http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20180203102005-2096853709_jpeg_2144_1340_384398/500","type":"jpeg","height":1340,"width":2144}
                     * state : 0
                     */

                    private String videoUrl;
                    private int videoDuration;
                    private String videoPic;
                    private YuntuVideoPicbean yuntuVideoPic;
                    private int state;

                    public String getVideoUrl() {
                        return videoUrl;
                    }

                    public void setVideoUrl(String videoUrl) {
                        this.videoUrl = videoUrl;
                    }

                    public int getVideoDuration() {
                        return videoDuration;
                    }

                    public void setVideoDuration(int videoDuration) {
                        this.videoDuration = videoDuration;
                    }

                    public String getVideoPic() {
                        return videoPic;
                    }

                    public void setVideoPic(String videoPic) {
                        this.videoPic = videoPic;
                    }

                    public YuntuVideoPicbean getYuntuVideoPic() {
                        return yuntuVideoPic;
                    }

                    public void setYuntuVideoPic(YuntuVideoPicbean yuntuVideoPic) {
                        this.yuntuVideoPic = yuntuVideoPic;
                    }

                    public int getState() {
                        return state;
                    }

                    public void setState(int state) {
                        this.state = state;
                    }

                    public static class YuntuVideoPicbean {
                        /**
                         * originUrl : http://img04.sogoucdn.com/v2/thumb/resize/w/1080/t/1/retype/ext/auto/q/75?appid=200698&url=http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20180203102005-2096853709_jpeg_2144_1340_384398/0
                         * yuntuUrl : http://img04.sogoucdn.com/v2/thumb/resize/w/500/t/1/retype/ext/auto/q/75?appid=200698&url=http://pic.wenwen.soso.com/pqpic/wenwenpic/0/20180203102005-2096853709_jpeg_2144_1340_384398/500
                         * type : jpeg
                         * height : 1340
                         * width : 2144
                         */

                        private String originUrl;
                        private String yuntuUrl;
                        private String type;
                        private int height;
                        private int width;

                        public String getOriginUrl() {
                            return originUrl;
                        }

                        public void setOriginUrl(String originUrl) {
                            this.originUrl = originUrl;
                        }

                        public String getYuntuUrl() {
                            return yuntuUrl;
                        }

                        public void setYuntuUrl(String yuntuUrl) {
                            this.yuntuUrl = yuntuUrl;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public int getHeight() {
                            return height;
                        }

                        public void setHeight(int height) {
                            this.height = height;
                        }

                        public int getWidth() {
                            return width;
                        }

                        public void setWidth(int width) {
                            this.width = width;
                        }
                    }
                }
            }
        }
    }
}
