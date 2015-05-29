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
@RequestMapping("/category")
public class CategoryController {
    Logger logger = Logger.getLogger(CategoryController.class);

    @Resource
    ProductService productService;

    @RequestMapping({"/women/index.html"})
    public ModelAndView womenCategoryPage()
    {
        ModelAndView view =  new ModelAndView();
        return view;
    }

    @RequestMapping({"/common/index/{keyword}.html"})
    public ModelAndView commonCategoryPage(@PathVariable String keyword)
    {
        ModelAndView view =  new ModelAndView("/category/common/index");
        return view;
    }
}
