package com.lxl.beans.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * Created by xiaolu on 15/5/4.
 */
public class ProductExtInfo {

    long productid;

    List<ProdcutExtInfoItem> saleItems;
    List<ProdcutExtInfoItem> basicShowItems;
    List<ProdcutExtInfoItem> images;
    List<ProdcutExtInfoItem> others;

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public List<ProdcutExtInfoItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<ProdcutExtInfoItem> saleItems) {
        this.saleItems = saleItems;
    }

    public List<ProdcutExtInfoItem> getBasicShowItems() {
        return basicShowItems;
    }

    public void setBasicShowItems(List<ProdcutExtInfoItem> basicShowItems) {
        this.basicShowItems = basicShowItems;
    }

    public List<ProdcutExtInfoItem> getImages() {
        return images;
    }

    public void setImages(List<ProdcutExtInfoItem> images) {
        this.images = images;
    }

    public List<ProdcutExtInfoItem> getOthers() {
        return others;
    }

    public void setOthers(List<ProdcutExtInfoItem> others) {
        this.others = others;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
