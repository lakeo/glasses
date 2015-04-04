package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.management.modelmbean.ModelMBean;

/**
 * Created by lan on 15/4/5.
 */
@Controller
//@RequestMapping("/cart")
public class CartController {
    @RequestMapping("/cart")
    public ModelAndView defaultMethod()
    {
        return new ModelAndView();
    }
}
