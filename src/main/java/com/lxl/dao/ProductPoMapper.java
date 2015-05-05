package com.lxl.dao;

import com.lxl.beans.po.ProductPo;

public interface ProductPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductPo record);

    int insertSelective(ProductPo record);

    ProductPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductPo record);

    int updateByPrimaryKey(ProductPo record);
}