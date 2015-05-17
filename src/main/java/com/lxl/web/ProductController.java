package com.lxl.web;

import com.lxl.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by lan on 15/4/5.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    Logger logger = Logger.getLogger(ProductController.class);

    @Resource
    ProductService productService;

    @RequestMapping({"/category/index/{keyWord}.html"})
    public ModelAndView categoryPage(@PathVariable String keyWord)
    {
        ModelAndView view =  new ModelAndView("/product/category/index");
        return view;
    }

    @RequestMapping("/detail/{productId}.html")
    public ModelAndView detailPage(@PathVariable long productId)
    {
        ModelAndView view =  new ModelAndView("/product/detail");
        view.addObject("product", this.productService.getProductById(productId));
        view.addObject("productExt", this.productService.getProdutExtInfoByProductId(productId));
        return view;
    }
}
