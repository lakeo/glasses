package com.lxl.dao;

import com.lxl.beans.po.DfGroupItemPo;
import com.lxl.beans.po.DfGroupItemPoExample;

import java.util.List;

public interface DfGroupItemPoMapper {
    int countByExample(DfGroupItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupItemPo record);

    int insertSelective(DfGroupItemPo record);

    List<DfGroupItemPo> selectByExampleWithBLOBs(DfGroupItemPoExample example);

    List<DfGroupItemPo> selectByExample(DfGroupItemPoExample example);

    DfGroupItemPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupItemPo record);

    int updateByPrimaryKeyWithBLOBs(DfGroupItemPo record);

    int updateByPrimaryKey(DfGroupItemPo record);
}