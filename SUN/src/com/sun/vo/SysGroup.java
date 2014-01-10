package com.sun.vo;

public class SysGroup {
    private Integer id;

    private String groupName;

    private String groupDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupDes() {
        return groupDes;
    }

    public void setGroupDes(String groupDes) {
        this.groupDes = groupDes == null ? null : groupDes.trim();
    }
}