package com.lxl.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/dynamicform")
@Controller
public class DynamicformController
{

    @RequestMapping("/index.html")
    public ModelAndView index()
    {
        return new ModelAndView();
    }
    @RequestMapping("/view/all")
    public  ModelAndView viewList()
    {
        ModelAndView view = new ModelAndView();
        return view;
    }
}
