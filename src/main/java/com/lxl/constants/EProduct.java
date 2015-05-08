package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/8.
 */
public enum EProduct {
    online(0,"正在线上"),
    deleted(1,"被删除"),
    offline(2,"下线状态"),
    created(3,"刚被创建"),
    waitingProcess(4,"待完善");
    
    private int index;
    private String description;
    EProduct(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
