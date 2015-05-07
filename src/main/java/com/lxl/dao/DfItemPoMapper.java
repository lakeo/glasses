package com.lxl.dao;

import com.lxl.beans.po.DfItemPo;
import com.lxl.beans.po.DfItemPoExample;

import java.util.List;

public interface DfItemPoMapper {
    int countByExample(DfItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DfItemPo record);

    int insertSelective(DfItemPo record);

    List<DfItemPo> selectByExample(DfItemPoExample example);

    DfItemPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DfItemPo record);

    int updateByPrimaryKey(DfItemPo record);
}