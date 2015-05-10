package com.lxl.beans.vo;

import java.util.Date;

/**
 * Created by xiaolu on 15/5/8.
 */
public class SearchParam {
    Product product;
    Date productCreateBeginDate;
    Date productCreateEndDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getProductCreateBeginDate() {
        return productCreateBeginDate;
    }

    public void setProductCreateBeginDate(Date productCreateBeginDate) {
        this.productCreateBeginDate = productCreateBeginDate;
    }

    public Date getProductCreateEndDate() {
        return productCreateEndDate;
    }

    public void setProductCreateEndDate(Date productCreateEndDate) {
        this.productCreateEndDate = productCreateEndDate;
    }
}
