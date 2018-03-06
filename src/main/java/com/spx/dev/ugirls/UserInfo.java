package com.spx.dev.ugirls;

public class UserInfo {

    /**
     * Status : 1
     * UserInfo : {"iUserId":2000012,"sNick":"19.","dBalance":"0.0000","iLevel":1,"sImage":"http://q.qlogo.cn/qqapp/1104648695/8F741BC52EF5110F087886B2A74C8613/40","iFever":0,"iStatus":1,"dtExpire":0,"iSex":1,"iIdentityRulesId":1,"sSign":"''","iPropertyMobile":0,"dtExpireMobile":0,"iPeriod":0,"dtPeriodEnd":0,"iDays":0,"sIdentity":"普通会员(LV1)","iPeriodEnd":0,"role":{"iIdentified":0,"iIsPeriod":0,"iIsVip":0},"iMagazineMobileCount":0,"iVideoMobileCount":0,"iAttentionCount":1,"iReadCount":0,"iCollectMagazineCount":0,"iCollectVideoCount":0,"iCollectAudioBookCount":1,"iCriticalCount":0,"iPraiseCount":0,"iShareCount":0,"iTopicReplyCount":0,"iLoginTimes":2,"iUnReadCount":1793,"iLoginType":5,"iIsBinding":0,"sLogo":"https://api.youguoquan.com/vip/logo?userId=2000012","alipay_status":"","PresentCount":0,"PresentUnReceive":0,"RechargeNotice":"","NewRechargeNotice":"","TaskCount":"(1/6)","TaskFinished":0,"iCoinBlance":0,"isAuth":0}
     */

    private int Status;
    private UserInfoBean UserInfo;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public UserInfoBean getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(UserInfoBean UserInfo) {
        this.UserInfo = UserInfo;
    }

    public static class UserInfoBean {
        /**
         * iUserId : 2000012
         * sNick : 19.
         * dBalance : 0.0000
         * iLevel : 1
         * sImage : http://q.qlogo.cn/qqapp/1104648695/8F741BC52EF5110F087886B2A74C8613/40
         * iFever : 0
         * iStatus : 1
         * dtExpire : 0
         * iSex : 1
         * iIdentityRulesId : 1
         * sSign : ''
         * iPropertyMobile : 0
         * dtExpireMobile : 0
         * iPeriod : 0
         * dtPeriodEnd : 0
         * iDays : 0
         * sIdentity : 普通会员(LV1)
         * iPeriodEnd : 0
         * role : {"iIdentified":0,"iIsPeriod":0,"iIsVip":0}
         * iMagazineMobileCount : 0
         * iVideoMobileCount : 0
         * iAttentionCount : 1
         * iReadCount : 0
         * iCollectMagazineCount : 0
         * iCollectVideoCount : 0
         * iCollectAudioBookCount : 1
         * iCriticalCount : 0
         * iPraiseCount : 0
         * iShareCount : 0
         * iTopicReplyCount : 0
         * iLoginTimes : 2
         * iUnReadCount : 1793
         * iLoginType : 5
         * iIsBinding : 0
         * sLogo : https://api.youguoquan.com/vip/logo?userId=2000012
         * alipay_status :
         * PresentCount : 0
         * PresentUnReceive : 0
         * RechargeNotice :
         * NewRechargeNotice :
         * TaskCount : (1/6)
         * TaskFinished : 0
         * iCoinBlance : 0
         * isAuth : 0
         */

        private int iUserId;
        private String sNick;
        private String dBalance;
        private int iLevel;
        private String sImage;
        private int iFever;
        private int iStatus;
        private int dtExpire;
        private int iSex;
        private int iIdentityRulesId;
        private String sSign;
        private int iPropertyMobile;
        private int dtExpireMobile;
        private int iPeriod;
        private int dtPeriodEnd;
        private int iDays;
        private String sIdentity;
        private int iPeriodEnd;
        private RoleBean role;
        private int iMagazineMobileCount;
        private int iVideoMobileCount;
        private int iAttentionCount;
        private int iReadCount;
        private int iCollectMagazineCount;
        private int iCollectVideoCount;
        private int iCollectAudioBookCount;
        private int iCriticalCount;
        private int iPraiseCount;
        private int iShareCount;
        private int iTopicReplyCount;
        private int iLoginTimes;
        private int iUnReadCount;
        private int iLoginType;
        private int iIsBinding;
        private String sLogo;
        private String alipay_status;
        private int PresentCount;
        private int PresentUnReceive;
        private String RechargeNotice;
        private String NewRechargeNotice;
        private String TaskCount;
        private int TaskFinished;
        private int iCoinBlance;
        private int isAuth;

        public int getIUserId() {
            return iUserId;
        }

        public void setIUserId(int iUserId) {
            this.iUserId = iUserId;
        }

        public String getSNick() {
            return sNick;
        }

        public void setSNick(String sNick) {
            this.sNick = sNick;
        }

        public String getDBalance() {
            return dBalance;
        }

        public void setDBalance(String dBalance) {
            this.dBalance = dBalance;
        }

        public int getILevel() {
            return iLevel;
        }

        public void setILevel(int iLevel) {
            this.iLevel = iLevel;
        }

        public String getSImage() {
            return sImage;
        }

        public void setSImage(String sImage) {
            this.sImage = sImage;
        }

        public int getIFever() {
            return iFever;
        }

        public void setIFever(int iFever) {
            this.iFever = iFever;
        }

        public int getIStatus() {
            return iStatus;
        }

        public void setIStatus(int iStatus) {
            this.iStatus = iStatus;
        }

        public int getDtExpire() {
            return dtExpire;
        }

        public void setDtExpire(int dtExpire) {
            this.dtExpire = dtExpire;
        }

        public int getISex() {
            return iSex;
        }

        public void setISex(int iSex) {
            this.iSex = iSex;
        }

        public int getIIdentityRulesId() {
            return iIdentityRulesId;
        }

        public void setIIdentityRulesId(int iIdentityRulesId) {
            this.iIdentityRulesId = iIdentityRulesId;
        }

        public String getSSign() {
            return sSign;
        }

        public void setSSign(String sSign) {
            this.sSign = sSign;
        }

        public int getIPropertyMobile() {
            return iPropertyMobile;
        }

        public void setIPropertyMobile(int iPropertyMobile) {
            this.iPropertyMobile = iPropertyMobile;
        }

        public int getDtExpireMobile() {
            return dtExpireMobile;
        }

        public void setDtExpireMobile(int dtExpireMobile) {
            this.dtExpireMobile = dtExpireMobile;
        }

        public int getIPeriod() {
            return iPeriod;
        }

        public void setIPeriod(int iPeriod) {
            this.iPeriod = iPeriod;
        }

        public int getDtPeriodEnd() {
            return dtPeriodEnd;
        }

        public void setDtPeriodEnd(int dtPeriodEnd) {
            this.dtPeriodEnd = dtPeriodEnd;
        }

        public int getIDays() {
            return iDays;
        }

        public void setIDays(int iDays) {
            this.iDays = iDays;
        }

        public String getSIdentity() {
            return sIdentity;
        }

        public void setSIdentity(String sIdentity) {
            this.sIdentity = sIdentity;
        }

        public int getIPeriodEnd() {
            return iPeriodEnd;
        }

        public void setIPeriodEnd(int iPeriodEnd) {
            this.iPeriodEnd = iPeriodEnd;
        }

        public RoleBean getRole() {
            return role;
        }

        public void setRole(RoleBean role) {
            this.role = role;
        }

        public int getIMagazineMobileCount() {
            return iMagazineMobileCount;
        }

        public void setIMagazineMobileCount(int iMagazineMobileCount) {
            this.iMagazineMobileCount = iMagazineMobileCount;
        }

        public int getIVideoMobileCount() {
            return iVideoMobileCount;
        }

        public void setIVideoMobileCount(int iVideoMobileCount) {
            this.iVideoMobileCount = iVideoMobileCount;
        }

        public int getIAttentionCount() {
            return iAttentionCount;
        }

        public void setIAttentionCount(int iAttentionCount) {
            this.iAttentionCount = iAttentionCount;
        }

        public int getIReadCount() {
            return iReadCount;
        }

        public void setIReadCount(int iReadCount) {
            this.iReadCount = iReadCount;
        }

        public int getICollectMagazineCount() {
            return iCollectMagazineCount;
        }

        public void setICollectMagazineCount(int iCollectMagazineCount) {
            this.iCollectMagazineCount = iCollectMagazineCount;
        }

        public int getICollectVideoCount() {
            return iCollectVideoCount;
        }

        public void setICollectVideoCount(int iCollectVideoCount) {
            this.iCollectVideoCount = iCollectVideoCount;
        }

        public int getICollectAudioBookCount() {
            return iCollectAudioBookCount;
        }

        public void setICollectAudioBookCount(int iCollectAudioBookCount) {
            this.iCollectAudioBookCount = iCollectAudioBookCount;
        }

        public int getICriticalCount() {
            return iCriticalCount;
        }

        public void setICriticalCount(int iCriticalCount) {
            this.iCriticalCount = iCriticalCount;
        }

        public int getIPraiseCount() {
            return iPraiseCount;
        }

        public void setIPraiseCount(int iPraiseCount) {
            this.iPraiseCount = iPraiseCount;
        }

        public int getIShareCount() {
            return iShareCount;
        }

        public void setIShareCount(int iShareCount) {
            this.iShareCount = iShareCount;
        }

        public int getITopicReplyCount() {
            return iTopicReplyCount;
        }

        public void setITopicReplyCount(int iTopicReplyCount) {
            this.iTopicReplyCount = iTopicReplyCount;
        }

        public int getILoginTimes() {
            return iLoginTimes;
        }

        public void setILoginTimes(int iLoginTimes) {
            this.iLoginTimes = iLoginTimes;
        }

        public int getIUnReadCount() {
            return iUnReadCount;
        }

        public void setIUnReadCount(int iUnReadCount) {
            this.iUnReadCount = iUnReadCount;
        }

        public int getILoginType() {
            return iLoginType;
        }

        public void setILoginType(int iLoginType) {
            this.iLoginType = iLoginType;
        }

        public int getIIsBinding() {
            return iIsBinding;
        }

        public void setIIsBinding(int iIsBinding) {
            this.iIsBinding = iIsBinding;
        }

        public String getSLogo() {
            return sLogo;
        }

        public void setSLogo(String sLogo) {
            this.sLogo = sLogo;
        }

        public String getAlipay_status() {
            return alipay_status;
        }

        public void setAlipay_status(String alipay_status) {
            this.alipay_status = alipay_status;
        }

        public int getPresentCount() {
            return PresentCount;
        }

        public void setPresentCount(int PresentCount) {
            this.PresentCount = PresentCount;
        }

        public int getPresentUnReceive() {
            return PresentUnReceive;
        }

        public void setPresentUnReceive(int PresentUnReceive) {
            this.PresentUnReceive = PresentUnReceive;
        }

        public String getRechargeNotice() {
            return RechargeNotice;
        }

        public void setRechargeNotice(String RechargeNotice) {
            this.RechargeNotice = RechargeNotice;
        }

        public String getNewRechargeNotice() {
            return NewRechargeNotice;
        }

        public void setNewRechargeNotice(String NewRechargeNotice) {
            this.NewRechargeNotice = NewRechargeNotice;
        }

        public String getTaskCount() {
            return TaskCount;
        }

        public void setTaskCount(String TaskCount) {
            this.TaskCount = TaskCount;
        }

        public int getTaskFinished() {
            return TaskFinished;
        }

        public void setTaskFinished(int TaskFinished) {
            this.TaskFinished = TaskFinished;
        }

        public int getICoinBlance() {
            return iCoinBlance;
        }

        public void setICoinBlance(int iCoinBlance) {
            this.iCoinBlance = iCoinBlance;
        }

        public int getIsAuth() {
            return isAuth;
        }

        public void setIsAuth(int isAuth) {
            this.isAuth = isAuth;
        }

        public static class RoleBean {
            /**
             * iIdentified : 0
             * iIsPeriod : 0
             * iIsVip : 0
             */

            private int iIdentified;
            private int iIsPeriod;
            private int iIsVip;

            public int getIIdentified() {
                return iIdentified;
            }

            public void setIIdentified(int iIdentified) {
                this.iIdentified = iIdentified;
            }

            public int getIIsPeriod() {
                return iIsPeriod;
            }

            public void setIIsPeriod(int iIsPeriod) {
                this.iIsPeriod = iIsPeriod;
            }

            public int getIIsVip() {
                return iIsVip;
            }

            public void setIIsVip(int iIsVip) {
                this.iIsVip = iIsVip;
            }
        }
    }
}
