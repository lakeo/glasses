package com.lxl.service;

import com.lxl.util.CommonUtil;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by xiaolu on 15/5/21.
 */
@Service
public class ImageService {
    final String IMAGE_WEB = "http://7xifr5.com1.z0.glb.clouddn.com/";

    @Autowired
    QiniuService qiniuService;

    //main method
    public String saveImage(long productId, MultipartFile file)
    {
        try {
            String filename = CommonUtil.generateFileName(file.getOriginalFilename());
            qiniuService.uploadData(file.getBytes(),filename);
            return filename;
        }catch (Exception e) {
            return "";
        }
    }

}
