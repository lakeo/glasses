package com.lxl.web.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfItem;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.*;

/**
 * Created by xiaolu on 15/5/12.
 */
public class DfGroupVo {
    private Integer id;

    private String name;

    private String type;

    private String description;

    List<DfItem> data;

    public DfGroupVo(DfGroup group) {
        this.id = group.getId();
        this.name = group.getName();
        this.description = group.getDescription();
        this.type = "group";
        this.data = new ArrayList<>();
    }

    public List<DfItem> getData() {
        return data;
    }

    public void setData(List<DfItem> data) {
        this.data = data;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
