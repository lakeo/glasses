package com.lxl.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:*.xml","classpath:*.xml"})
public class TestDB {
    @Resource
    DfGroupMapper dfGroupMapper;

    @Test
    public void test()
    {
        System.out.println("hello");
        Object o = dfGroupMapper.selectByPrimaryKey(1);
        System.out.print(o);
    }
}
