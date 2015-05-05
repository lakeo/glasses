package com.lxl.dao;

import com.lxl.beans.po.DfGroupTypePo;

public interface DfGroupTypePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupTypePo record);

    int insertSelective(DfGroupTypePo record);

    DfGroupTypePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupTypePo record);

    int updateByPrimaryKey(DfGroupTypePo record);
}