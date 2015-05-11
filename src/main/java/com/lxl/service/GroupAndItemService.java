package com.lxl.service;

import com.lxl.beans.po.*;
import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfGroupItem;
import com.lxl.beans.vo.DfItem;
import com.lxl.dao.DfGroupItemPoMapper;
import com.lxl.dao.DfGroupPoMapper;
import com.lxl.dao.DfItemPoMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolu on 15/5/7.
 */
@Service
public class GroupAndItemService {
    Logger logger = Logger.getLogger(GroupAndItemService.class);

    @Resource
    DfGroupPoMapper dfGroupPoMapper;

    @Resource
    DfItemPoMapper dfItemPoMapper;

    @Resource
    DfGroupItemPoMapper dfGroupItemPoMapper;

    private boolean validGroupForAdd(DfGroup dfGroup)
    {
        if(!StringUtils.isNotBlank(dfGroup.getName())) {
            return false;
        } else if(!StringUtils.isNotBlank(dfGroup.getDescription())) {
            return false;
        } else if (dfGroup.getType() == null) {
            return false;
        }
        return true;
    }

    private boolean validGroupForUpdate(DfGroup dfGroup)
    {
        if(!StringUtils.isNotBlank(dfGroup.getName())) {
            return false;
        } else if(!StringUtils.isNotBlank(dfGroup.getDescription())) {
            return false;
        } else if (dfGroup.getId() == null || dfGroup.getId() <=0) {
            return false;
        } else if (dfGroup.getType() == null) {
            return false;
        }
        return true;
    }

    private boolean validGroupItemForAdd(DfGroupItem dfGroupItem)
    {
        if(dfGroupItem.getGroupid() == null || dfGroupItem.getGroupid() <= 0) {
            return false;
        } else if(dfGroupItem.getItemid() == null || dfGroupItem.getItemid() <= 0) {
            return false;
        } else if (!StringUtils.isNotBlank(dfGroupItem.getType())) {
            return false;
        } else if (dfGroupItem.getIsRequire() == null || dfGroupItem.getIsRequire() < 0) {
            return false;
        }
        return true;
    }

    private boolean validGroupItemForUpdate(DfGroupItem dfGroupItem)
    {
        if(dfGroupItem.getGroupid() == null || dfGroupItem.getGroupid() <= 0) {
            return false;
        } else if (dfGroupItem.getId() == null || dfGroupItem.getId() <= 0) {
            return false;
        } else if(dfGroupItem.getItemid() == null || dfGroupItem.getItemid() <= 0) {
            return false;
        } else if (!StringUtils.isNotBlank(dfGroupItem.getType())) {
            return false;
        } else if (dfGroupItem.getIsRequire() == null || dfGroupItem.getIsRequire() < 0) {
            return false;
        }
        return true;
    }


    private boolean validItemForAdd(DfItem dfItem)
    {
        if(!StringUtils.isNotBlank(dfItem.getName())) {
            return false;
        } else if(!StringUtils.isNotBlank(dfItem.getDescription())) {
            return false;
        }
        return true;
    }

    private boolean validItemForUpdate(DfItem dfItem)
    {
        if(!StringUtils.isNotBlank(dfItem.getName())) {
            return false;
        } else if(!StringUtils.isNotBlank(dfItem.getDescription())) {
            return false;
        } else if (dfItem.getId() == null || dfItem.getId() <=0) {
            return false;
        }
        return true;
    }

    public boolean editDfGroup(DfGroup dfgroup) {
        DfGroupPo dfGroupPo = new DfGroupPo();
        dfGroupPo.setId(dfgroup.getId());
        dfGroupPo.setName(dfgroup.getName());
        dfGroupPo.setDescription(dfgroup.getDescription());
        dfGroupPo.setType(dfgroup.getType());
        dfGroupPo.setComment(dfgroup.getComment());
        //add
        if (dfgroup.getId() == null || dfgroup.getId() <= 0) {
            if (!this.validGroupForAdd(dfgroup)) {
                this.logger.warn("valid group fail " + dfgroup.getName());
                return false;
            }
            try {
                this.dfGroupPoMapper.insert(dfGroupPo);
                this.logger.info("add group: name=" + dfGroupPo.getName() + "; description=" + dfGroupPo.getDescription());
            } catch (Exception e) {
                this.logger.warn("add group fail: name=" + dfGroupPo.getName(), e);
                return false;
            }
            return true;
        } else {
            //update
            if (!this.validGroupForUpdate(dfgroup)) {
                this.logger.warn("valid group fail " + dfgroup.getId());
                return false;
            }

            try {
                this.logger.info("update dfgroup" + dfGroupPo);
                this.dfGroupPoMapper.updateByPrimaryKey(dfGroupPo);
                this.logger.info("update group: name=" + dfGroupPo.getName() + "; description=" + dfGroupPo.getDescription());
            } catch (Exception e) {
                this.logger.warn("update group fail: id=" + dfGroupPo.getId(), e);
                return false;
            }
            return true;
        }
    }

    public boolean editDfGroupItem(DfGroupItem dfgroupitem) {
        DfGroupItemPo dfGroupItemPo = new DfGroupItemPo();
        dfGroupItemPo.setId(dfgroupitem.getId());
        dfGroupItemPo.setGroupid(dfgroupitem.getGroupid());
        dfGroupItemPo.setItemid(dfgroupitem.getItemid());
        dfGroupItemPo.setType(dfgroupitem.getType());
        dfGroupItemPo.setShowData(dfgroupitem.getShowData());
        dfGroupItemPo.setIsRequire(dfgroupitem.getIsRequire());
        //add
        if (dfgroupitem.getId() == null || dfgroupitem.getId() <= 0) {
            if (!this.validGroupItemForAdd(dfgroupitem)) {
                this.logger.warn("valid groupitem fail:" + dfgroupitem);
                return false;
            }
            try {
                this.dfGroupItemPoMapper.insert(dfGroupItemPo);
                this.logger.info("add groupitem: " + dfgroupitem);
            } catch (Exception e) {
                this.logger.warn("add groupitem: " + dfgroupitem, e);
                return false;
            }
            return true;
        } else {
            //update
            if (!this.validGroupItemForUpdate(dfgroupitem)) {
                this.logger.warn("valid groupitem fail: "+dfgroupitem);
                return false;
            }

            try {
                this.dfGroupItemPoMapper.updateByPrimaryKey(dfGroupItemPo);
                this.logger.info("update dfgroupitem" + dfgroupitem);
            } catch (Exception e) {
                this.logger.warn("update groupitem fail: "+dfgroupitem, e);
                return false;
            }
            return true;
        }
    }


    public boolean editDfItem(DfItem dfitem)
    {
        DfItemPo dfItemPo = new DfItemPo();
        dfItemPo.setId(dfitem.getId());
        dfItemPo.setName(dfitem.getName());
        dfItemPo.setDescription(dfitem.getDescription());
        dfItemPo.setComment(dfitem.getComment());
        //add
        if(dfitem.getId() == null || dfitem.getId() <= 0) {
            if(!this.validItemForAdd(dfitem)) {
                this.logger.warn("valid group fail "+dfitem.getName());
                return false;
            }
            try {
                this.dfItemPoMapper.insert(dfItemPo);
                this.logger.info("add group: name="+dfItemPo.getName()+"; description="+dfItemPo.getDescription());
            } catch (Exception e) {
                this.logger.warn("add group fail: name="+dfItemPo.getName(),e);
                return false;
            }
            return true;
        } else {
            //update
            if(!this.validItemForUpdate(dfitem)) {
                this.logger.warn("valid group fail "+dfitem.getId());
                return false;
            }

            try {
                this.logger.info("update dfgroup"+dfItemPo);
                this.dfItemPoMapper.updateByPrimaryKey(dfItemPo);
                this.logger.info("update group: id="+dfItemPo.getId()+ " name="+dfItemPo.getName()+"; description="+dfItemPo.getDescription());
            } catch (Exception e) {
                this.logger.warn("update group fail: id="+dfItemPo.getId(),e);
                return false;
            }
            return true;
        }

    }


    public List<DfGroup> getAllGroup()
    {
        DfGroupPoExample dfGroupPoExample = new DfGroupPoExample();
        dfGroupPoExample.setOrderByClause("id asc");
        List<DfGroupPo> list = this.dfGroupPoMapper.selectByExample(dfGroupPoExample);
        ArrayList<DfGroup> target = new ArrayList<DfGroup>();

        for(DfGroupPo po : list) {
            target.add(new DfGroup(po));
        }
        return target;
    }

    public List<DfItem> getAllItem()
    {
        DfItemPoExample dfItemPoExample = new DfItemPoExample();
        dfItemPoExample.setOrderByClause("id asc");
        List<DfItemPo> list = this.dfItemPoMapper.selectByExample(dfItemPoExample);
        ArrayList<DfItem> target = new ArrayList<DfItem>();

        for(DfItemPo po : list) {
            target.add(new DfItem(po));
        }
        return target;
    }

    public List<DfGroupItem> getAllGroupItems()
    {
        DfGroupItemPoExample dfGroupItemPoExample = new DfGroupItemPoExample();
        dfGroupItemPoExample.setOrderByClause("groupid asc");
        List<DfGroupItemPo> list = this.dfGroupItemPoMapper.selectByExample(dfGroupItemPoExample);
        ArrayList<DfGroupItem> target = new ArrayList<DfGroupItem>();

        for(DfGroupItemPo po : list) {
            target.add(new DfGroupItem(po));
        }
        return target;
    }
}
