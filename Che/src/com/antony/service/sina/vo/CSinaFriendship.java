package com.antony.service.sina.vo;

import java.math.BigDecimal;

public class CSinaFriendship {
    private BigDecimal id;

    private BigDecimal userId;

    private BigDecimal friendId;

    private String sinaId;

    private String ainfo;

    private String binfo;

    private String friendSinaId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public BigDecimal getFriendId() {
        return friendId;
    }

    public void setFriendId(BigDecimal friendId) {
        this.friendId = friendId;
    }

    public String getSinaId() {
        return sinaId;
    }

    public void setSinaId(String sinaId) {
        this.sinaId = sinaId == null ? null : sinaId.trim();
    }

    public String getAinfo() {
        return ainfo;
    }

    public void setAinfo(String ainfo) {
        this.ainfo = ainfo == null ? null : ainfo.trim();
    }

    public String getBinfo() {
        return binfo;
    }

    public void setBinfo(String binfo) {
        this.binfo = binfo == null ? null : binfo.trim();
    }

    public String getFriendSinaId() {
        return friendSinaId;
    }

    public void setFriendSinaId(String friendSinaId) {
        this.friendSinaId = friendSinaId == null ? null : friendSinaId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", friendId=").append(friendId);
        sb.append(", sinaId=").append(sinaId);
        sb.append(", ainfo=").append(ainfo);
        sb.append(", binfo=").append(binfo);
        sb.append(", friendSinaId=").append(friendSinaId);
        sb.append("]");
        return sb.toString();
    }
}