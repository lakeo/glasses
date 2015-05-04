package com.lxl.beans.po;

public class DfGroupItem {
    private Integer id;

    private Integer groupid;

    private Integer itemid;

    private String type;

    private Integer isRequire;

    private String showData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsRequire() {
        return isRequire;
    }

    public void setIsRequire(Integer isRequire) {
        this.isRequire = isRequire;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }
}