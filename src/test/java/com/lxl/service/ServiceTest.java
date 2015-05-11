package com.lxl.service;

import com.lxl.BaseTest;
import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfItem;
import com.lxl.web.util.DfGroupVo;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaolu on 15/5/7.
 */
public class ServiceTest extends BaseTest {
    Logger logger = Logger.getLogger(ServiceTest.class);
    @Resource
    GroupAndItemService groupAndItemService;

    @Test
    public void testGroupAndItem()
    {
        logger.info(this.groupAndItemService.getAllGroup());
    }

    @Test
    public void testAddGroup()
    {
        //add
        DfGroup dfGroup = new DfGroup();
        dfGroup.setName("test");
        dfGroup.setDescription("description");
        this.groupAndItemService.editDfGroup(dfGroup);

    }

    @Test
    public void testAddItem()
    {
        //add
        DfItem dfGroup = new DfItem();
        dfGroup.setName("test");
        dfGroup.setDescription("description");
        //this.groupAndItemService.editDfItem(dfGroup);

        //edit
        dfGroup.setId(1);
        dfGroup.setName("test2");
        this.groupAndItemService.editDfItem(dfGroup);
    }

    @Test
    public  void getItemDataByTypeId()
    {
        List<DfGroupVo> list = this.groupAndItemService.getShowGroupByType2id(4);
        for(DfGroupVo v : list) {
            logger.info(v);
        }
    }

    @Test
    public void getItemDataByProductId()
    {
        List<DfItem> list = this.groupAndItemService.getItemDataByProductId(6);
        for(DfItem i : list) {
            logger.info(i);
        }
    }
}
