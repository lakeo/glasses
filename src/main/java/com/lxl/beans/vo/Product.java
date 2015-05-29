package com.lxl.beans.vo;

import com.lxl.beans.po.ProductPo;
import com.lxl.constants.EProduct;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaolu on 15/5/4.
 */
public class Product {
    private Long id;

    private String name;

    private Integer cuser;

    private Date ctime;

    private Integer muser;

    private Date mtime;

    private Integer type1id;

    private Integer type2id;

    private Integer status;

    private String statusString;

    private String description;

    private String data;

    private List<ProductExtInfoItem> items;

    public Product()
    {

    }

    public Product(ProductPo po)
    {
        this.id = po.getId();
        this.name = po.getName();
        this.ctime = new Date(po.getCtime());
        this.mtime = new Date(po.getMtime());
        this.cuser = po.getCuser();
        this.type1id = po.getType1id();
        this.type2id = po.getType2id();
        this.status = po.getStatus();
        this.description = po.getDescription();
        this.statusString = EProduct.getDescriptionFromIndex(this.status);
    }

    public String getStatusString() {
        return statusString;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
    }

    public List<ProductExtInfoItem> getItems() {
        return items;
    }

    public void setItems(List<ProductExtInfoItem> items) {
        this.items = items;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCuser() {
        return cuser;
    }

    public void setCuser(Integer cuser) {
        this.cuser = cuser;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public Integer getMuser() {
        return muser;
    }

    public void setMuser(Integer muser) {
        this.muser = muser;
    }

    public Integer getType1id() {
        return type1id;
    }

    public void setType1id(Integer type1id) {
        this.type1id = type1id;
    }

    public Integer getType2id() {
        return type2id;
    }

    public void setType2id(Integer type2id) {
        this.type2id = type2id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
