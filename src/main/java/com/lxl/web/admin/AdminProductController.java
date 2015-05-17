package com.lxl.web.admin;

import com.lxl.beans.vo.Product;
import com.lxl.beans.vo.SearchParam;
import com.lxl.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Created by xiaolu on 15/5/8.
 */
@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    Logger logger = Logger.getLogger(AdminProductController.class);

    @Resource
    ProductService productService;

    @RequestMapping("/index.html")
    public ModelAndView productList(SearchParam param)
    {
        ModelAndView view = new ModelAndView();
        view.addObject("products", this.productService.search(param));
        return view;
    }

    @RequestMapping(value = "/create.html",method = RequestMethod.GET)
    public ModelAndView createProductIndex()
    {
        return new ModelAndView();
    }

    @RequestMapping(value = "/create.html", method = RequestMethod.POST)
    public ModelAndView createProduct(Product product)
    {
        ModelAndView view;
        Long productid;
        if((productid = this.productService.createProduct(product)) != 0) {
            view = new ModelAndView("redirect:/admin/product/edit.html?productId="+productid);
        } else {
            view = new ModelAndView();
        }
        return view;
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.GET)
    public ModelAndView editProductIndex(Long productId)
    {
        ModelAndView view = new ModelAndView();
        view.addObject("product",this.productService.getProductById(productId));
        return view;
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.POST)
    public ModelAndView editProduct(Product product)
    {
        int productId = product.getId() == null ? 0 : product.getId().intValue();
        logger.info("try save product: id="+productId);
        this.productService.setProductExtFromWeb(product);
        return new ModelAndView("redirect:/admin/product/edit.html?productId="+productId);
    }
}
