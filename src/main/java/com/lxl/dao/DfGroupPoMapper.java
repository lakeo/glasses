package com.lxl.dao;

import com.lxl.beans.po.DfGroupPo;
import com.lxl.beans.po.DfGroupPoExample;

import java.util.List;

public interface DfGroupPoMapper {
    int countByExample(DfGroupPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupPo record);

    int insertSelective(DfGroupPo record);

    List<DfGroupPo> selectByExample(DfGroupPoExample example);

    DfGroupPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupPo record);

    int updateByPrimaryKey(DfGroupPo record);
}