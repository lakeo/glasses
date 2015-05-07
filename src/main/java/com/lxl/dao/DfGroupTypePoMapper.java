package com.lxl.dao;

import com.lxl.beans.po.DfGroupTypePo;
import com.lxl.beans.po.DfGroupTypePoExample;

import java.util.List;

public interface DfGroupTypePoMapper {
    int countByExample(DfGroupTypePoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfGroupTypePo record);

    int insertSelective(DfGroupTypePo record);

    List<DfGroupTypePo> selectByExample(DfGroupTypePoExample example);

    DfGroupTypePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfGroupTypePo record);

    int updateByPrimaryKey(DfGroupTypePo record);
}