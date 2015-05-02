package com.lxl.dao;

import com.lxl.beans.po.DfGroup;

public interface DfGroupMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroup record);

    int insertSelective(DfGroup record);

    DfGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroup record);

    int updateByPrimaryKey(DfGroup record);
}