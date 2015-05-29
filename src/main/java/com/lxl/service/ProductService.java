package com.lxl.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxl.beans.po.*;
import com.lxl.beans.vo.Product;
import com.lxl.beans.vo.ProductExtInfo;
import com.lxl.beans.vo.ProductExtInfoItem;
import com.lxl.beans.vo.SearchParam;
import com.lxl.constants.EProduct;
import com.lxl.dao.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.*;

/**
 * Created by xiaolu on 15/5/8.
 */
@Service
public class ProductService {
    Logger logger = Logger.getLogger(ProductService.class);

    @Resource
    ProductPoMapper productPoMapper;

    @Resource
    MyProductExtInfoItemMapper myProductExtInfoItemMapper;

    @Resource
    ProductExtInfoPoMapper productExtInfoPoMapper;

    @Resource
    GroupAndItemService groupAndItemService;


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
        productPoExample.setOrderByClause("mtime desc");
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
    public Long createProduct(Product product)
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
        ProductPo productPo = this.productPoMapper.selectByPrimaryKey(productid);
        if(productPo != null) {
            return new Product(productPo);
        }
        return new Product();
    }

    public ProductExtInfo getProdutExtInfoByProductId(Long productId)
    {
        ProductExtInfo productExtInfo = new ProductExtInfo();
        List<ProductExtInfoItem> itemlist = this.myProductExtInfoItemMapper.selectByProductId(productId);
        for(ProductExtInfoItem item : itemlist) {
            productExtInfo.addItem(item);
        }
        return productExtInfo;
    }


    public ProductExtInfoPo getProductExtInfoPoByName(long productId, DfItemPo itemPo)
    {
        if(itemPo == null) {
            return null;
        }
        ProductExtInfoPoExample extInfoPoExample = new ProductExtInfoPoExample();
        extInfoPoExample.createCriteria().andProductidEqualTo(productId).andItemidEqualTo(itemPo.getId());
        List<ProductExtInfoPo> list = this.productExtInfoPoMapper.selectByExample(extInfoPoExample);
        if(list.isEmpty()) {
            return  null;
        } else {
            return list.get(0);
        }
    }

    List<ProductExtInfoItem> convertDataToItems(String data, Long productId)
    {
        if(productId == null)
            return null;
        if(!StringUtils.isNotBlank(data)) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(data);
            JsonParser parser = mapper.treeAsTokens(node);
            Map<String, Object>[] items = mapper.treeToValue(node, Map[].class);
            items = parser.readValueAs(new TypeReference<Map<String, Object>[]>() {});
            List<ProductExtInfoItem> ret = new ArrayList<>();
            for(Map map : items) {
                String name = (String)map.get("name");
                String value = (String)map.get("value");
                DfItemPo dfItemPo = this.groupAndItemService.getItemByName(name);
                if(dfItemPo == null) {
                    logger.warn("add item failed: name="+name);
                    continue;
                }
                ProductExtInfoPo productExtInfoPo = this.getProductExtInfoPoByName(productId, dfItemPo);
                ProductExtInfoItem productExtInfoItem = new ProductExtInfoItem();
                productExtInfoItem.setProductId(productId);
                productExtInfoItem.setItemId(dfItemPo.getId());
                productExtInfoItem.setValue(value);
                if(productExtInfoPo != null) {
                    productExtInfoItem.setId(productExtInfoPo.getId());
                }
                ret.add(productExtInfoItem);
            }
            return ret;
        } catch (Exception e) {
            return null;
        }
    }
     boolean validProductExtDataForSave(Product product)
    {
        if(product.getId() == null || product.getId() <= 0) {
            return false;
        } else if(product.getItems() == null || product.getItems().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean saveProductExtFromWeb(Product product)
    {
        product.setItems(this.convertDataToItems(product.getData(), product.getId()));
        if(!this.validProductExtDataForSave(product)) {
            logger.info("validate product ext failed:"+ product.getId());
            return false;
        }
        //items is not null
        for(ProductExtInfoItem item : product.getItems()) {
            ProductExtInfoPo extInfoPo = new ProductExtInfoPo();
            extInfoPo.setId(item.getId());
            extInfoPo.setProductid(product.getId());
            extInfoPo.setItemid(item.getItemId());
            extInfoPo.setValue(item.getValue());
            try {
                if(extInfoPo.getId() == null || extInfoPo.getId() == 0) {
                    this.productExtInfoPoMapper.insert(extInfoPo);
                } else {
                    this.productExtInfoPoMapper.updateByPrimaryKeyWithBLOBs(extInfoPo);
                }
            }catch (Exception e) {
                logger.warn("save product ext failed",e);
                return false;
            }
        }

        //change product status
        ProductPo productPo = new ProductPo();
        productPo.setId(product.getId());
        productPo.setStatus(EProduct.waitingApproved.getIndex());
        this.productPoMapper.updateByPrimaryKeySelective(productPo);

        logger.info("save product:"+product);
        return true;
    }

    public boolean confirmProduct(long productId)
    {
        ProductPo productPo = new ProductPo();
        productPo.setId(productId);
        productPo.setStatus(EProduct.online.getIndex());
        this.productPoMapper.updateByPrimaryKeySelective(productPo);
        return true;
    }
}
