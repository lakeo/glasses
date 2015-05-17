package com.lxl.dao;

import com.lxl.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/2.
 */
public class TestDB extends BaseTest{
    Logger logger = Logger.getLogger(TestDB.class);

    @Resource
    DfGroupPoMapper dfGroupPoMapper;

    @Resource
    ProductExtInfoPoMapper productExtInfoPoMapper;

    @Test
    public void test()
    {
        System.out.println("hello");
        Object o = dfGroupPoMapper.selectByPrimaryKey(1);
        System.out.print(o);
    }


    @Test
    public void testProductExt()
    {
        logger.info("get product ext info");
        Object o = productExtInfoPoMapper.selectByPrimaryKey((long)6);
        logger.info(o);
    }
}
