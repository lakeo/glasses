package com.lxl.dao;

import com.lxl.beans.po.DfGroupType;

public interface DfGroupTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupType record);

    int insertSelective(DfGroupType record);

    DfGroupType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupType record);

    int updateByPrimaryKey(DfGroupType record);
}