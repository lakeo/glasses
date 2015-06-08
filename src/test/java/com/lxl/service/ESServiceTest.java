package com.lxl.service;

import com.lxl.BaseTest;
import org.apache.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/6/8.
 */
public class ESServiceTest extends BaseTest {
    Logger logger = Logger.getLogger(ESServiceTest.class);

    @Resource
    ESService esService;

    @Test
    public void getResponse()
    {
        GetResponse t = this.esService.getResponseByIndexTypeId("customer", "external", "1");
        return ;
    }
}
