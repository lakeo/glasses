package com.lxl.service;

import com.lxl.BaseTest;
import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfItem;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/7.
 */
public class ServiceTest extends BaseTest {
    Logger logger = Logger.getLogger(ServiceTest.class);
    @Resource
    GroupAndItemService groupAndItemService;

    @Test
    @Ignore
    public void testGroupAndItem()
    {
        logger.info(this.groupAndItemService.getAllGroup());
    }

    @Test
    @Ignore
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
}
