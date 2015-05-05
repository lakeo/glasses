package com.lxl.dao;

import com.lxl.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/2.
 */
public class TestDB extends BaseTest{
    @Resource
    DfGroupPoMapper dfGroupPoMapper;

    @Test
    @Ignore
    public void test()
    {
        System.out.println("hello");
        Object o = dfGroupPoMapper.selectByPrimaryKey(1);
        System.out.print(o);
    }
}
