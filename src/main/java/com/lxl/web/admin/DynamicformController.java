package com.lxl.web.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/dynamicform")
public class DynamicformController
{

    @RequestMapping("/view/all")
    public static ModelAndView viewList()
    {
        ModelAndView view = new ModelAndView();
        return view;
    }
}
