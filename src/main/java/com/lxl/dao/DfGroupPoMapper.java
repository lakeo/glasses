package com.lxl.dao;

import com.lxl.beans.po.DfGroupPo;

public interface DfGroupPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupPo record);

    int insertSelective(DfGroupPo record);

    DfGroupPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupPo record);

    int updateByPrimaryKey(DfGroupPo record);
}