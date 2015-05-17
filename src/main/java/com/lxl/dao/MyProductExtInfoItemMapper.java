package com.lxl.dao;

import com.lxl.beans.vo.ProductExtInfoItem;

import java.util.List;

public interface MyProductExtInfoItemMapper {
    List<ProductExtInfoItem> selectByProductId(long productId);
}