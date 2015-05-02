package com.lxl.dao;

import com.lxl.beans.po.DfItem;

public interface DfItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DfItem record);

    int insertSelective(DfItem record);

    DfItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfItem record);

    int updateByPrimaryKey(DfItem record);
}