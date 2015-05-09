package com.lxl.service;

import com.lxl.beans.po.DfGroupItemPoExample;
import com.lxl.beans.po.ProductPo;
import com.lxl.beans.po.ProductPoExample;
import com.lxl.beans.vo.Product;
import com.lxl.beans.vo.SearchParam;
import com.lxl.constants.EProduct;
import com.lxl.dao.ProductPoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaolu on 15/5/8.
 */
@Service
public class ProductService {
    Logger logger = Logger.getLogger(ProductService.class);

    @Resource
    ProductPoMapper productPoMapper;

    ProductPoExample convertSearchParam(SearchParam searchParam)
    {
        ProductPoExample productPoExample = new ProductPoExample();
        ProductPoExample.Criteria criteria = productPoExample.createCriteria();
        if(searchParam.getProductCreateBeginDate() != null) {
            criteria.andCtimeGreaterThanOrEqualTo(searchParam.getProductCreateBeginDate().getTime());
        }
        if(searchParam.getProductCreateEndDate() != null) {
            criteria.andCtimeLessThanOrEqualTo(searchParam.getProductCreateEndDate().getTime());
        }
        Product product = searchParam.getProduct();
        if(product != null) {
            if(product.getId() != null) {
                criteria.andIdEqualTo(product.getId());
            }
            if(StringUtils.isNotBlank(product.getName())) {
                criteria.andNameLike(product.getName());
            }
            if(StringUtils.isNotBlank(product.getDescription())) {
                criteria.andDescriptionLike(product.getDescription());
            }
        }
        return productPoExample;
    }
    public List<Product> search(SearchParam searchParam)
    {
        ProductPoExample productPoExample = this.convertSearchParam(searchParam);
        List<ProductPo> list = this.productPoMapper.selectByExample(productPoExample);
        List<Product> ret = new ArrayList<Product>();
        for(ProductPo po : list) {
            ret.add(new Product(po));
        }
        return ret;
    }

    boolean validateProductForCreate(Product product)
    {
        return true;
    }

    //success: return productid
    public Long createProdut(Product product)
    {
        if(!this.validateProductForCreate(product)) {
            logger.info("product validate fails "+product);
            return (long)0;
        }
        ProductPo productPo = new ProductPo();
        productPo.setName(product.getName());
        productPo.setDescription(product.getDescription());
        productPo.setCtime((new Date()).getTime());
        productPo.setMtime((new Date()).getTime());
        productPo.setCuser(1);
        productPo.setMuser(1);
        productPo.setType1id(product.getType1id());
        productPo.setType2id(product.getType2id());
        productPo.setStatus(EProduct.waitingProcess.getIndex());
        try {
            this.productPoMapper.insertSelective(productPo);
            logger.info("create product:"+product);
        }catch(Exception e) {
            logger.warn("create prodcut fails " + product, e);
            return (long)0;
        }
        logger.info("create productpo: productid="+productPo.getId());
        return productPo.getId();
    }

    public Product getProductById(Long productid)
    {
        return new Product(this.productPoMapper.selectByPrimaryKey(productid));
    }
}
