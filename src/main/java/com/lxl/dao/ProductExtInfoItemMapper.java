package com.lxl.dao;

import com.lxl.beans.vo.ProductExtInfoItem;

import java.util.List;

public interface ProductExtInfoItemMapper {
    List<ProductExtInfoItem> selectByProductId(long productId);
}