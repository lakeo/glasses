package com.lxl.service;

import com.lxl.BaseTest;
import com.lxl.util.Log;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by xiaolu on 15/5/23.
 */
public class QiniuServiceTest extends BaseTest {
    Logger  logger = Logger.getLogger(QiniuServiceTest.class);

    @Resource
    QiniuService qiniuService;

    @Test
    public void testUpload() {
        File file = new File("/Users/xiaolu/Downloads/4BD6B2A320C576758B5EEA5E13DD7FDC.png");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[300000];
            inputStream.read(data);
            this.qiniuService.uploadData(data,"test.png");
        } catch (Exception e) {
            logger.warn(e);
        }

    }
}
