package com.lxl.beans.vo;

import com.lxl.beans.po.TypePo;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by xiaolu on 15/5/4.
 */
public class Type {
    int id;
    int level;
    int parentid;
    String name;
    String description;
    String alias;

    public Type()
    {

    }

    public Type(TypePo typePo)
    {
        this.id = typePo.getId();
        this.level = typePo.getLevel();
        this.parentid = typePo.getParentid();
        this.name = typePo.getName();
        this.description = typePo.getDescription();
        this.alias = typePo.getAlias();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
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
