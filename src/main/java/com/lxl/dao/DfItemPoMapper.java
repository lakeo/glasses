package com.lxl.dao;

import com.lxl.beans.po.DfItemPo;

public interface DfItemPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfItemPo record);

    int insertSelective(DfItemPo record);

    DfItemPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfItemPo record);

    int updateByPrimaryKey(DfItemPo record);
}