package com.lxl.dao;

import com.lxl.beans.po.DfGroupItem;
public interface DfGroupItemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupItem record);

    int insertSelective(DfGroupItem record);

    DfGroupItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupItem record);

    int updateByPrimaryKeyWithBLOBs(DfGroupItem record);

    int updateByPrimaryKey(DfGroupItem record);
}