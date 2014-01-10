package com.sun.vo;

import java.util.Date;

public class SysNews {
    private Integer id;

    private String title;

    private Integer newstypeid;

    private String image;

    private Date posttime;

    private Date updatetime;

    private Integer viewcount;

    private Integer userid;

    private String updateip;

    private Integer processinguserid;

    private Integer top;

    private Integer isDel;

    private Integer state;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(Integer newstypeid) {
        this.newstypeid = newstypeid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUpdateip() {
        return updateip;
    }

    public void setUpdateip(String updateip) {
        this.updateip = updateip == null ? null : updateip.trim();
    }

    public Integer getProcessinguserid() {
        return processinguserid;
    }

    public void setProcessinguserid(Integer processinguserid) {
        this.processinguserid = processinguserid;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}