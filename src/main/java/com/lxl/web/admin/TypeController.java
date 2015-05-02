package com.lxl.web.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/type")
public class TypeController {
    @RequestMapping("/add")
    public static ModelAndView add()
    {
        return new ModelAndView();
    }
}
