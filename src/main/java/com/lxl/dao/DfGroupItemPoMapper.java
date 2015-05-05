package com.lxl.dao;

import com.lxl.beans.po.DfGroupItemPo;

public interface DfGroupItemPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupItemPo record);

    int insertSelective(DfGroupItemPo record);

    DfGroupItemPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupItemPo record);

    int updateByPrimaryKeyWithBLOBs(DfGroupItemPo record);

    int updateByPrimaryKey(DfGroupItemPo record);
}