package com.lxl.dao;

import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfItem;
import com.lxl.beans.vo.ProductExtInfoItem;

import java.util.List;

public interface MyGroupAndItemMapper {
    List<DfGroup> selectGroupByType2Id(long typeid);

    List<DfItem> selectItemsByGroupId(long groupid);

    List<DfItem> selectItemsByProductId(long productId);
}