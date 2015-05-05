package com.lxl.dao;

import com.lxl.beans.po.TypePo;
import com.lxl.beans.po.TypePoExample;

import java.util.List;

public interface TypePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TypePo record);

    int insertSelective(TypePo record);

    List<TypePo> selectByExample(TypePoExample example);

    TypePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TypePo record);

    int updateByPrimaryKey(TypePo record);
}