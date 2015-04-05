package com.lxl.web;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class RegisterController {
    @RequestMapping("/register.html")
    public ModelAndView registerPage()
    {
        return new ModelAndView();
    }
}
