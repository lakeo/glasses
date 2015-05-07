package com.lxl.service;

import com.lxl.beans.po.DfGroupTypePo;
import com.lxl.beans.po.DfGroupTypePoExample;
import com.lxl.beans.po.TypePo;
import com.lxl.beans.po.TypePoExample;
import com.lxl.beans.vo.DfGroupType;
import com.lxl.constants.EType;
import com.lxl.dao.DfGroupTypePoMapper;
import com.lxl.dao.TypePoMapper;
import org.apache.log4j.Logger;
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

    Logger logger = Logger.getLogger(TypeService.class);
    @Resource
    TypePoMapper typePoMapper;

    @Resource
    DfGroupTypePoMapper dfGroupTypePoMapper;

    public List<DfGroupType> getGroupTypeByTypeid(Integer typeid)
    {
        DfGroupTypePoExample example = new DfGroupTypePoExample();
        example.createCriteria().andTypeidEqualTo(typeid);
        example.setOrderByClause("groupid asc");
        List<DfGroupTypePo> list = this.dfGroupTypePoMapper.selectByExample(example);

        List<DfGroupType> ret = new ArrayList<DfGroupType>();
        for(DfGroupTypePo po : list) {
            ret.add(new DfGroupType(po));
        }
        return ret;
    }
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
        example.setOrderByClause("id asc");
        return this.getTypeList(example);
    }

    public List<Type> getLevelTypeList()
    {
        TypePoExample example = new TypePoExample();
        return this.getTypeList(example);
    }

    public List<Type> getLevelOneTypeList()
    {
        TypePoExample example = new TypePoExample();
        example.createCriteria().andLevelEqualTo(EType.LevelOne.getIndex());
        example.setOrderByClause("id asc");
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
        logger.info("addtype"+type.getName());
        TypePo typePo = new TypePo();
        typePo.setName(type.getName());
        typePo.setParentid(type.getParentid());
        typePo.setDescription(type.getDescription());
        typePo.setLevel(type.getLevel());
        try {
            this.typePoMapper.insert(typePo);
            logger.info("add success");
        } catch (Exception e) {
            logger.info("add type false",e);
            return false;
        }
        return true;
    }

    private boolean validDfGroupTypeForAdd(DfGroupType dfGroupType)
    {
        if(dfGroupType.getGroupid() == null || dfGroupType.getGroupid() <= 0) {
            return false;
        } else if (dfGroupType.getTypeid() == null || dfGroupType.getTypeid() <= 0) {
            return false;
        }
        return true;
    }
    public boolean addTypeGroup(DfGroupType dfGroupType)
    {
        logger.info("add typegroup" + dfGroupType);
        if(!this.validDfGroupTypeForAdd(dfGroupType)) {
            return false;
        }
        DfGroupTypePo po = new DfGroupTypePo();
        po.setGroupid(dfGroupType.getGroupid());
        po.setTypeid(dfGroupType.getTypeid());
        try{
            this.dfGroupTypePoMapper.insert(po);
        }catch (Exception e) {
            logger.warn("add typegroup faiil"+dfGroupType, e);
            return false;
        }
        return true;
    }
}
