package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class HomeController {
    @RequestMapping("/index.html")
    public ModelAndView homePage()
    {
        return new ModelAndView();
    }
}
