package com.lxl.beans.vo;

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
        return ToStringBuilder.reflectionToString(this);
    }
}
