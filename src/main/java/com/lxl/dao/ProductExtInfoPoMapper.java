package com.lxl.dao;

import com.lxl.beans.po.ProductExtInfoPo;
import com.lxl.beans.po.ProductExtInfoPoExample;

import java.util.List;

public interface ProductExtInfoPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductExtInfoPo record);

    int insertSelective(ProductExtInfoPo record);

    List<ProductExtInfoPo> selectByExampleWithBLOBs(ProductExtInfoPoExample example);

    List<ProductExtInfoPo> selectByExample(ProductExtInfoPoExample example);

    ProductExtInfoPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductExtInfoPo record);

    int updateByPrimaryKeyWithBLOBs(ProductExtInfoPo record);

    int updateByPrimaryKey(ProductExtInfoPo record);
}