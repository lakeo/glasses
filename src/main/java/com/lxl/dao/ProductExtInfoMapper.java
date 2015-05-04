package com.lxl.dao;

import com.lxl.beans.po.ProductExtInfo;

public interface ProductExtInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ProductExtInfo record);

    int insertSelective(ProductExtInfo record);

    ProductExtInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductExtInfo record);

    int updateByPrimaryKeyWithBLOBs(ProductExtInfo record);

    int updateByPrimaryKey(ProductExtInfo record);
}