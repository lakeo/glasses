package com.lxl.service;

import com.lxl.beans.po.ImagePo;
import com.lxl.constants.EImage;
import com.lxl.dao.ImagePoMapper;
import com.lxl.util.CommonUtil;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by xiaolu on 15/5/21.
 */
@Service
public class ImageService {
    final String IMAGE_WEB = "http://7xifr5.com1.z0.glb.clouddn.com/";

    @Autowired
    QiniuService qiniuService;

    @Resource
    ImagePoMapper imagePoMapper;

    //main method
    public String saveImage(long productId, MultipartFile file)
    {
        try {
            String filename = CommonUtil.generateFileName(file.getOriginalFilename());
            qiniuService.uploadData(file.getBytes(),filename);

            ImagePo imagePo = new ImagePo();
            imagePo.setFilename(this.IMAGE_WEB+filename);
            imagePo.setObjid(productId);
            imagePo.setType(EImage.PRODUCT.getIndex());

            this.imagePoMapper.insert(imagePo);
            return this.IMAGE_WEB+filename;
        }catch (Exception e) {
            return "";
        }
    }

}
