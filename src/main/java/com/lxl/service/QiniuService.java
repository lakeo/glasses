package com.lxl.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by xiaolu on 15/5/23.
 */
@Service
public class QiniuService {
    Logger logger = Logger.getLogger(QiniuService.class);

    final String ACCESS_KEY = "VZvPAMih5-yotsQKuxvpG4T78UDzGkP1MNtThpHH";
    final String SECRET_KEY = "wdR7xGEkM8QOCy9D49uqUhnUwyx4J0E5br6_9TUD";
    final String BUCKET_NAME = "lxlglass";
    final String KEY = "key";

    private Auth auth;
    private UploadManager uploadManager;


    public UploadManager getUploadManager() {
        if(uploadManager == null) {
            synchronized (this){
                if(uploadManager == null) {
                    uploadManager = new UploadManager();
                }
            }
        }
        return uploadManager;
    }

    public Auth getAuth() {
        if(auth == null) {
            synchronized (this) {
                if(auth == null) {
                    auth = Auth.create(ACCESS_KEY, SECRET_KEY);
                }
            }
        }
        return auth;
    }

    private String getUpToken(String filename){
        return this.getAuth().uploadToken(BUCKET_NAME, filename);
    }

    //上传内存中数据
    public void uploadData(byte[] data, String filename){
        try {
            Response res = this.getUploadManager().put(data, filename, this.getUpToken(filename));
            logger.info(res);
        } catch (QiniuException e) {
            logger.error(e.response);
        } catch (Exception e) {
            logger.error(e);
        }
    }


    public void uploadFile(File file, String filename){
        try {
            Response res = this.getUploadManager().put(file, filename, getUpToken(filename));
            logger.info(res);
        } catch (QiniuException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
