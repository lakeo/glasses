package com.lxl.service;

import com.lxl.BaseTest;
import com.lxl.beans.vo.Product;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/16.
 */
public class ProductServiceTest extends BaseTest {
    Logger logger = Logger.getLogger(ProductServiceTest.class);
    @Resource
    ProductService productService;

    @Test
    public void testCreate()
    {
        Product product = new Product();
        product.setName("testtt");
        product.setType1id(1);
        product.setType2id(2);
        long productid  = this.productService.createProduct(product);
        logger.info(productid);
    }

    @Test
    @Ignore
    public void testJaconConvert()
    {
        Product product = new Product();
        product.setId((long)6);
        product.setData("[{\"name\":\"title1\",\"value\":\"LOHO2015新品首发 时尚 红色 半框 女款 \"},{\"name\":\"title2\",\"value\":\"【预约到店体验并购买即送价值99元礼盒套装】\"},{\"name\":\"specifications\",\"value\":\"某公司出品\"},{\"name\":\"computerFirstImage\",\"value\":\"/resources/assets/images/single-product/1.jpg\"},{\"name\":\"sliderImages\",\"value\":\"/resources/assets/images/single-product/1.jpg,/resources/assets/images/single-product/2.jpg,/resources/assets/images/single-product/1.jpg,/resources/assets/images/single-product/2.jpg,/resources/assets/images/single-product/1.jpg,/resources/assets/images/single-product/2.jpg\"},{\"name\":\"contentImages\",\"value\":\"/resources/assets/images/products/3.jpg,/resources/assets/images/products/3.jpg\"},{\"name\":\"material\",\"value\":\" <select class=\\\"form-control\\\"><option selected value=\\\"板材\\\">板材</option><option value=\\\"钛合金\\\">钛合金</option><option value=\\\"木质\\\">木质</option></select>\"},{\"name\":\"color\",\"value\":\" <ul class=\\\"list-unstyled list-inline\\\">                                   <li>                                            <a href=\\\"#\\\">                                                <img class=\\\"info-img\\\" src=\\\"/resources/assets/images/single-product/3.jpg\\\" alt=\\\"\\\">                                            </a>                                        </li>                                        <li>                                            <a href=\\\"#\\\">                                                <img class=\\\"info-img\\\" src=\\\"/resources/assets/images/single-product/3.jpg\\\" alt=\\\"\\\">                                            </a>                                        </li>                                        <li>                                            <a href=\\\"#\\\">                                                <img class=\\\"info-img\\\" src=\\\"/resources/assets/images/single-product/3.jpg\\\" alt=\\\"\\\">                                            </a>                                        </li>                                    </ul>\"},{\"name\":\"price\",\"value\":\"160.00\"},{\"name\":\"prePrice\",\"value\":\"870.00\"}]");
        this.productService.setProductExtFromWeb(product);
    }

}
