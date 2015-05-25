package com.lxl.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * Created by xiaolu on 15/5/25.
 */
public class CommonUtil {
    public static String generateFileName(String source) throws Exception {
        if (!StringUtils.isNotBlank(source)) {
            throw new Exception("filename can not be null");
        }
        String suffix = "";
        if(source.lastIndexOf('.') != -1) {
            suffix = source.substring(source.lastIndexOf('.'));
        }
        String randomName = CommonUtil.generateRandomString(1);
        return randomName+suffix;
    }

    public static String generateRandomString(int type) {
        switch (type) {
            case 1:
                return new Date().getTime()+ UUID.randomUUID().toString();
            case 2:
            default:
                return new Date().toString()+"";
        }
    }
}
