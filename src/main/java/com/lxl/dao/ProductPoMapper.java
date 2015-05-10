package com.lxl.dao;

import com.lxl.beans.po.ProductPo;
import com.lxl.beans.po.ProductPoExample;

import java.util.List;

public interface ProductPoMapper {
    int countByExample(ProductPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductPo record);

    int insertSelective(ProductPo record);

    List<ProductPo> selectByExample(ProductPoExample example);

    ProductPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductPo record);

    int updateByPrimaryKey(ProductPo record);
}