package com.lxl.util;

import com.lxl.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by xiaolu on 15/5/5.
 */
public class Log extends BaseTest{
    Logger logger = Logger.getLogger(Log.class);
    @Test
    @Ignore
    public void log()
    {
        System.out.print("heere");
        logger.info("ahdfadsf");
        logger.debug("adfadf2");
        logger.warn("2222");
    }
}
