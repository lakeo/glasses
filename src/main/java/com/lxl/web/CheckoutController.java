package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class CheckoutController {
    @RequestMapping("/checkout")
    public ModelAndView checkoutPage()
    {
        return new ModelAndView();
    }
}
