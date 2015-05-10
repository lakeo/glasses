package com.lxl.web.admin;

import com.lxl.beans.vo.DfGroup;
import com.lxl.beans.vo.DfGroupItem;
import com.lxl.beans.vo.DfGroupType;
import com.lxl.beans.vo.DfItem;
import com.lxl.service.GroupAndItemService;
import com.lxl.service.TypeService;
import com.lxl.web.util.Message;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaolu on 15/4/29.
 */
@RequestMapping("/admin/dynamicform")
@Controller
public class AdminDynamicformController
{
    Logger logger = Logger.getLogger(AdminDynamicformController.class);

    @Resource
    GroupAndItemService groupAndItemService;

    @Resource
    TypeService typeService;

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

    @RequestMapping("/typegroup.html")
    public ModelAndView typeGroupIndex(Integer typeid)
    {
        if(typeid == null || typeid < 0) {
            typeid = 0;
        }

        ModelAndView view = new ModelAndView();
        view.addObject("relations",this.typeService.getGroupTypeByTypeid(typeid));
        view.addObject("groups",this.groupAndItemService.getAllGroup());
        view.addObject("typeid", typeid);
        return view;
    }

    @RequestMapping("/typegroup/add")
    public ModelAndView typeGroupAdd(DfGroupType dfGroupType)
    {
        ModelAndView view = new ModelAndView("redirect:/admin/dynamicform/typegroup.html?typeid="+dfGroupType.getTypeid());
        this.typeService.addTypeGroup(dfGroupType);
        return view;
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

    @RequestMapping("/product/data/{productid}")
    @ResponseBody
    public Message getProductItemData(@PathVariable long productid)
    {
        Message message = new Message();
        List<String> list = new ArrayList<String>();
        list.add("");
        message.putData(list);
        logger.info("get prodcut data");
        return message;
    }

    /*
    items:[{id,name,description,showData,isRequire,}..]
    * */
    @RequestMapping("/product/show/{type2id}")
    @ResponseBody
    public Message getItemDataByTypeId(@PathVariable int type2id)
    {
        Message message = new Message();
        List<String> list = new ArrayList<String>();
        list.add("{id:3,name:'文案信息',description:'用于展示',type:'group',data:[{id:4, name:'title1', description:'用于详情页展示', type:'text', showData:'', isRequire:1}]}");
        message.putData(list);
        logger.info("get show");
        return message;
    }

}
