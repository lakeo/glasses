package com.lxl.beans.po;

public class ProductPo {
    private Long id;

    private String name;

    private Integer cuser;

    private Long ctime;

    private Integer muser;

    private Long mtime;

    private Integer type1id;

    private Integer type2id;

    private Integer status;

    private String description;

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

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Integer getMuser() {
        return muser;
    }

    public void setMuser(Integer muser) {
        this.muser = muser;
    }

    public Long getMtime() {
        return mtime;
    }

    public void setMtime(Long mtime) {
        this.mtime = mtime;
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
}