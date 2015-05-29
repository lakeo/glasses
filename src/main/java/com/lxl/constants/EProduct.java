package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/8.
 */
public enum EProduct {
    deleted(0,"被删除"),
    online(1,"正在线上"),
    offline(2,"下线状态"),
    waitingProcess(3,"待完善"),
    waitingApproved(4,"待审核");

    private int index;
    private String description;

    EProduct(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public static String getDescriptionFromIndex(int index) {
        if(index >= 0) {
            for(EProduct p : EProduct.values()) {
                if(p.getIndex() == index) {
                    return p.description;
                }
            }
        }
        return "unknown";
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
