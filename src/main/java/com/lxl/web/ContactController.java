package com.lxl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lan on 15/4/5.
 */
@Controller
public class ContactController {
    @RequestMapping("/contact.html")
    public ModelAndView contactPage()
    {
        return new ModelAndView();
    }
}
