package com.lxl.service;

import com.lxl.beans.po.ImagePo;
import com.lxl.beans.po.ImagePoExample;
import com.lxl.beans.vo.ProductImage;
import com.lxl.constants.EImage;
import com.lxl.dao.ImagePoMapper;
import com.lxl.util.CommonUtil;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolu on 15/5/21.
 */
@Service
public class ImageService {
    Logger logger = Logger.getLogger(ImageService.class);
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
            logger.warn(e);
            return "";
        }
    }

    public List<ProductImage> getProductImages(long productId)
    {
        ImagePoExample imagePoExample = new ImagePoExample();
        imagePoExample.createCriteria().andObjidEqualTo(productId).andTypeEqualTo(EImage.PRODUCT.getIndex());
        List<ImagePo> list = this.imagePoMapper.selectByExample(imagePoExample);
        List<ProductImage> ret = new ArrayList<>();
        for(ImagePo imagePo : list) {
            ret.add(new ProductImage(imagePo));
        }
        return ret;
    }

}
