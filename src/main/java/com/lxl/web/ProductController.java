package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class ProductController {
    @RequestMapping({"/product.html"})
    public ModelAndView productPage()
    {
        return new ModelAndView();
    }

    @RequestMapping({"/product_detail.html","/category.html"})
    public ModelAndView detailPage()
    {
        return new ModelAndView();
    }
}
