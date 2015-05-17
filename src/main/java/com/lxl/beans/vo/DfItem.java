package com.lxl.beans.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxl.beans.po.DfItemPo;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by xiaolu on 15/5/4.
 */
public class DfItem {
    private Integer id;

    private String name;

    private String description;

    private String comment;

    private String type;

    private String showData;

    private int isRequire;

    private String value;

    public DfItem()
    {

    }

    public DfItem(DfItemPo po)
    {
        this.id =  po.getId();
        this.name = po.getName();
        this.description = po.getDescription();
        this.comment = po.getComment();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }

    public int getIsRequire() {
        return isRequire;
    }

    public void setIsRequire(int isRequire) {
        this.isRequire = isRequire;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        try {
            return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this);
        }catch (Exception e) {
            return "";
        }
    }
}
