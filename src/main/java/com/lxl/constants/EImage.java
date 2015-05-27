package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/26.
 */
public enum EImage {
    PRODUCT(1);

    public int getIndex() {
        return index;
    }

    int index;
    EImage(int index) {
        this.index = index;
    }
}
