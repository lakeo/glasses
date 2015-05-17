package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/10.
 */
public  enum EDfGroup {
    other(0,"其他"),
    sale(1,"销售属性"),
    basicShow(2,"基本展示属性"),
    images(3,"图片信息"),
    price(4,"价格信息");

    private int index;
    private String description;
    EDfGroup(int index, String desc) {
        this.index = index;
        this.description = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
