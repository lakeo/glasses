package com.lxl.dao;

import com.lxl.beans.po.ImagePo;
import com.lxl.beans.po.ImagePoExample;

import java.util.List;

public interface ImagePoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ImagePo record);

    int insertSelective(ImagePo record);

    List<ImagePo> selectByExample(ImagePoExample example);

    ImagePo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImagePo record);

    int updateByPrimaryKey(ImagePo record);
}