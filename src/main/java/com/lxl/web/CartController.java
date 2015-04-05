package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class CartController {
    public CartController()
    {
        return;
    }
    @RequestMapping("/cart.html")
    public ModelAndView defaultMethod()
    {
        ModelAndView model = new ModelAndView();
        model.addObject("myname","兰肖鲁");
        return model;
    }
}
