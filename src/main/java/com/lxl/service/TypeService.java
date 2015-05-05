package com.lxl.service;

import com.lxl.beans.po.TypePo;
import com.lxl.beans.po.TypePoExample;
import com.lxl.constants.EType;
import com.lxl.dao.TypePoMapper;
import org.springframework.stereotype.Service;
import com.lxl.beans.vo.Type;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolu on 15/5/4.
 */
@Service
public class TypeService {
    @Resource
    TypePoMapper typePoMapper;

    public Type getTypeById(int id)
    {
        TypePoExample example = new TypePoExample();
        example.createCriteria()
                .andIdEqualTo(id);
        TypePo typePo;
        try {
             typePo = this.typePoMapper.selectByExample(example).get(0);
        } catch (Exception e) {
            return new Type();
        }
        return new Type(typePo);
    }

    public List<Type> getLevelTwoTypeList(int id)
    {
        TypePoExample example = new TypePoExample();
        example.createCriteria()
                .andLevelEqualTo(EType.LevelTwo.getIndex())
                .andParentidEqualTo(id);
        return this.getTypeList(example);
    }
    public List<Type> getLevelOneTypeList()
    {
        TypePoExample example = new TypePoExample();
        example.createCriteria().andLevelEqualTo(EType.LevelOne.getIndex());
        return this.getTypeList(example);
    }

    public  List<Type> getTypeList(TypePoExample type)
    {
        List<TypePo> typePos = typePoMapper.selectByExample(type);
        List<Type> list = new ArrayList<Type>();
        for(TypePo typePo : typePos) {
            list.add(new Type(typePo));
        }
        return list;
    }

    public boolean addType(Type type)
    {
        TypePo typePo = new TypePo();
        typePo.setName(type.getName());
        typePo.setParentid(type.getParentid());
        typePo.setDescription(type.getDescription());
        typePo.setLevel(type.getLevel());
        try {
            this.typePoMapper.insert(typePo);
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
        return true;
    }
}
