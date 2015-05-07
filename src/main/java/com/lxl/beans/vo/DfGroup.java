package com.lxl.beans.vo;

import com.lxl.beans.po.DfGroupPo;

/**
 * Created by xiaolu on 15/5/4.
 */
public class DfGroup {
    private Integer id;

    private String name;

    private String description;

    public DfGroup()
    {

    }

    public DfGroup(DfGroupPo po)
    {
        this.id =  po.getId();
        this.name = po.getName();
        this.description = po.getDescription();
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
}
