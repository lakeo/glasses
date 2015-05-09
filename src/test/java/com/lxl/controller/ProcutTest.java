package com.lxl.controller;

import com.lxl.BaseTest;
import com.lxl.beans.vo.Product;
import com.lxl.beans.vo.SearchParam;
import com.lxl.service.ProductService;
import com.lxl.web.admin.AdminProductController;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiaolu on 15/5/8.
 */
public class ProcutTest extends BaseTest {

    @Resource
    AdminProductController adminProductController;

    @Test
    public void insert()
    {
        Product product = new Product();
        product.setName("test");
        product.setType1id(1);
        product.setType2id(2);
        this.adminProductController.createProduct(product);
    }

    @Test
    public void search()
    {
        SearchParam param = new SearchParam();
        Product product = new Product();
        product.setName("test");
        this.adminProductController.productList(param);
    }

}
