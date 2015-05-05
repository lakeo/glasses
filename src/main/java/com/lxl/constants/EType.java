package com.lxl.constants;

/**
 * Created by xiaolu on 15/5/4.
 */
public enum EType {
    LevelOne(1),
    LevelTwo(2);

    private int index;
    EType(int index){
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
