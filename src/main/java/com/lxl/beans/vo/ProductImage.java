package com.lxl.beans.vo;

import com.lxl.beans.po.ImagePo;

/**
 * Created by xiaolu on 15/5/27.
 */
public class ProductImage {

    private Long id;

    private String filename;

    private Long productId;

    private Integer type;

    public ProductImage(ImagePo imagePo) {
        this.id = imagePo.getId();
        this.filename = imagePo.getFilename();
        this.productId = imagePo.getObjid();
        this.type = imagePo.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
