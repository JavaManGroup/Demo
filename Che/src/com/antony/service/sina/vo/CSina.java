package com.antony.service.sina.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CSina {
    private BigDecimal id;

    private BigDecimal userId;

    private String sinaId;

    private String sinaNick;

    private String sinaSex;

    private BigDecimal sinaAge;

    private String sinaCity;

    private String sinaLocal;

    private String sinaDes;

    private String sinaPicurl;

    private Date updatetime;

    private String status;

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

    public String getSinaId() {
        return sinaId;
    }

    public void setSinaId(String sinaId) {
        this.sinaId = sinaId == null ? null : sinaId.trim();
    }

    public String getSinaNick() {
        return sinaNick;
    }

    public void setSinaNick(String sinaNick) {
        this.sinaNick = sinaNick == null ? null : sinaNick.trim();
    }

    public String getSinaSex() {
        return sinaSex;
    }

    public void setSinaSex(String sinaSex) {
        this.sinaSex = sinaSex == null ? null : sinaSex.trim();
    }

    public BigDecimal getSinaAge() {
        return sinaAge;
    }

    public void setSinaAge(BigDecimal sinaAge) {
        this.sinaAge = sinaAge;
    }

    public String getSinaCity() {
        return sinaCity;
    }

    public void setSinaCity(String sinaCity) {
        this.sinaCity = sinaCity == null ? null : sinaCity.trim();
    }

    public String getSinaLocal() {
        return sinaLocal;
    }

    public void setSinaLocal(String sinaLocal) {
        this.sinaLocal = sinaLocal == null ? null : sinaLocal.trim();
    }

    public String getSinaDes() {
        return sinaDes;
    }

    public void setSinaDes(String sinaDes) {
        this.sinaDes = sinaDes == null ? null : sinaDes.trim();
    }

    public String getSinaPicurl() {
        return sinaPicurl;
    }

    public void setSinaPicurl(String sinaPicurl) {
        this.sinaPicurl = sinaPicurl == null ? null : sinaPicurl.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", sinaId=").append(sinaId);
        sb.append(", sinaNick=").append(sinaNick);
        sb.append(", sinaSex=").append(sinaSex);
        sb.append(", sinaAge=").append(sinaAge);
        sb.append(", sinaCity=").append(sinaCity);
        sb.append(", sinaLocal=").append(sinaLocal);
        sb.append(", sinaDes=").append(sinaDes);
        sb.append(", sinaPicurl=").append(sinaPicurl);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}