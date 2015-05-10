package com.lxl.beans.vo;

import com.lxl.constants.EDfGroup;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolu on 15/5/4.
 */
public class ProductExtInfo {

    long productId;
    String price;  //当前价格
    String prePrice; //之前价格
    String title1; //标题1
    String title2; //标题2
    String[] contentImages;
    String[] sliderImages;
    String specifications; //规格信息
    String computerFirstImage;//电脑首图

    List<ProductExtInfoItem> saleItems;
    List<ProductExtInfoItem> basicShowItems;
    List<ProductExtInfoItem> imageItems;
    List<ProductExtInfoItem> otherItems;
    List<ProductExtInfoItem> priceItems;

    public ProductExtInfo()
    {
        this.saleItems = new ArrayList<>();
        this.imageItems = new ArrayList<>();
        this.basicShowItems = new ArrayList<>();
        this.otherItems = new ArrayList<>();
        this.priceItems = new ArrayList<>();
    }

    public void addItem(ProductExtInfoItem i)
    {
        switch(i.getName()) {
            case "price":
                this.price = i.getValue();
                break;
            case "prePrice":
                this.prePrice = i.getValue();
                break;
            case "title1":
                this.title1 = i.getValue();
                break;
            case "title2":
                this.title2 = i.getValue();
                break;
            case "contentImages" :
                this.contentImages = i.getValue().split(",");
                break;
            case "sliderImages":
                this.sliderImages = i.getValue().split(",");
                break;
            case "specifications":
                this.specifications = i.getValue();
                break;
            case "computerFirstImage":
                this.computerFirstImage = i.getValue();
                break;
            default:
                if(i.getGroupType() == EDfGroup.basicShow.getIndex()) {
                    this.getBasicShowItems().add(i);
                }else if (i.getGroupType() == EDfGroup.sale.getIndex()) {
                    this.getSaleItems().add(i);
                }else if(i.getGroupType() == EDfGroup.images.getIndex()) {
                    this.getImageItems().add(i);
                } else if(i.getGroupType() == EDfGroup.price.getIndex()) {
                    this.getPriceItems().add(i);
                }else {
                    this.getOtherItems().add(i);
                }
        }
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getComputerFirstImage() {
        return computerFirstImage;
    }

    public void setComputerFirstImage(String computerFirstImage) {
        this.computerFirstImage = computerFirstImage;
    }

    public String[] getContentImages() {
        return contentImages;
    }

    public void setContentImages(String[] contentImages) {
        this.contentImages = contentImages;
    }

    public String[] getSliderImages() {
        return sliderImages;
    }

    public void setSliderImages(String[] sliderImages) {
        this.sliderImages = sliderImages;
    }

    public List<ProductExtInfoItem> getPriceItems() {
        return priceItems;
    }

    public void setPriceItems(List<ProductExtInfoItem> priceItems) {
        this.priceItems = priceItems;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrePrice() {
        return prePrice;
    }

    public void setPrePrice(String prePrice) {
        this.prePrice = prePrice;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<ProductExtInfoItem> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(List<ProductExtInfoItem> saleItems) {
        this.saleItems = saleItems;
    }

    public List<ProductExtInfoItem> getBasicShowItems() {
        return basicShowItems;
    }

    public void setBasicShowItems(List<ProductExtInfoItem> basicShowItems) {
        this.basicShowItems = basicShowItems;
    }

    public List<ProductExtInfoItem> getImageItems() {
        return imageItems;
    }

    public void setImageItems(List<ProductExtInfoItem> imageItems) {
        this.imageItems = imageItems;
    }

    public List<ProductExtInfoItem> getOtherItems() {
        return otherItems;
    }

    public void setOtherItems(List<ProductExtInfoItem> otherItems) {
        this.otherItems = otherItems;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
