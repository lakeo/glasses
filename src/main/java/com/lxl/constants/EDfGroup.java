package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/10.
 */
public  enum EDfGroup {
    other(0,"其他"),
    sale(1,"销售属性"),
    show(2,"展示属性");

    private int index;
    private String description;
    EDfGroup(int index, String desc) {
        this.index = index;
        this.description = desc;
    }
}
