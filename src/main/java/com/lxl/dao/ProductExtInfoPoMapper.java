package com.lxl.dao;

import com.lxl.beans.po.ProductExtInfoPo;

public interface ProductExtInfoPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductExtInfoPo record);

    int insertSelective(ProductExtInfoPo record);

    ProductExtInfoPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductExtInfoPo record);

    int updateByPrimaryKeyWithBLOBs(ProductExtInfoPo record);

    int updateByPrimaryKey(ProductExtInfoPo record);
}