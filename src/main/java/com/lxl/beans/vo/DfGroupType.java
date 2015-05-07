package com.lxl.beans.vo;

import com.lxl.beans.po.DfGroupTypePo;
import com.lxl.beans.po.DfItemPo;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by xiaolu on 15/5/4.
 */
public class DfGroupType {
    private Integer id;

    private Integer groupid;

    private Integer typeid;

    public DfGroupType()
    {

    }

    public DfGroupType(DfGroupTypePo po)
    {
        this.id =  po.getId();
        this.groupid = po.getGroupid();
        this.typeid = po.getTypeid();
    }

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

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
