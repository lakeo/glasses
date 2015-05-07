package com.lxl.web.admin;

import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfGroupItem;
import com.lxl.beans.vo.DfItem;
import com.lxl.service.GroupAndItemService;
import com.lxl.web.util.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/dynamicform")
@Controller
public class DynamicformController
{
    @Resource
    GroupAndItemService groupAndItemService;

    @RequestMapping("/index.html")
    public ModelAndView index()
    {
        List<DfGroup> groups = this.groupAndItemService.getAllGroup();
        List<DfItem> items = this.groupAndItemService.getAllItem();
        List<DfGroupItem> relations = this.groupAndItemService.getAllGroupItems();

        ModelAndView view = new ModelAndView();
        view.addObject("groups",groups);
        view.addObject("items",items);
        view.addObject("relations",relations);
        return view;
    }

    @RequestMapping("/itemmanager.html")
    public ModelAndView itemmanager()
    {
        return new ModelAndView();
    }

    @RequestMapping("/group/all")
    @ResponseBody
    public Message getGroupAll()
    {
        Message message = new Message();

        try{
            message.putData(this.groupAndItemService.getAllGroup());
        } catch (Exception e) {
            message.putError(e.getMessage());
            message.setType(Message.Type.DANGER);
        }

        return message;
    }

    @RequestMapping("/group/edit")
    public ModelAndView editGroup(DfGroup group)
    {
        ModelAndView view = new ModelAndView("redirect:/admin/dynamicform/index.html");
        this.groupAndItemService.editDfGroup(group);
        return view;
    }

    @RequestMapping("/item/edit")
    public ModelAndView editItem(DfItem dfItem)
    {
        ModelAndView view = new ModelAndView("redirect:/admin/dynamicform/index.html");
        this.groupAndItemService.editDfItem(dfItem);
        return view;
    }

    @RequestMapping("/groupitem/edit")
    public ModelAndView editGroupItem(DfGroupItem dfGroupItem)
    {
        ModelAndView view = new ModelAndView("redirect:/admin/dynamicform/index.html");
        this.groupAndItemService.editDfGroupItem(dfGroupItem);
        return view;
    }
}
