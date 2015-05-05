package com.lxl.web.admin;

import com.lxl.beans.po.TypePoExample;
import com.lxl.beans.vo.Type;
import com.lxl.service.TypeService;
import com.lxl.web.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/type")
@Controller
public class TypeController {

    @Resource
    TypeService typeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addindex()
    {
        ModelAndView view =  new ModelAndView();
        return view;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(Type type)
    {
        boolean ok = this.typeService.addType(type);
        ModelAndView view =  new ModelAndView();
        view.addObject("msg",ok?"添加成功":"添加失败");
        return view;
    }

    @RequestMapping("/levelone/all")
    @ResponseBody
    public Message viewLevelOne()
    {
        Message message = new Message();
        try{
            message.putData(this.typeService.getLevelOneTypeList());
            message.setType(Message.Type.SUCCESS);
        }catch (Exception e) {
            message.setType(Message.Type.DANGER);
            message.putError(e);
        }
        return message;
    }

    @RequestMapping("/index.html")
    public ModelAndView index(HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView();
        String id = request.getParameter("id");
        if(id == null || id=="") {
            id = "0";
        }
        int typeid = Integer.valueOf(id);
        Type type = this.typeService.getTypeById(typeid);
        view.addObject("levelOneList",this.typeService.getLevelOneTypeList());
        view.addObject("levelTwoList",this.typeService.getLevelTwoTypeList(typeid));
        view.addObject("type",type);
        return view;
    }
}
