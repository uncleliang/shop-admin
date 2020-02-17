package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-17 10:10
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @RequestMapping("/list")
    public String list(){
        return "product/list";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Product> findAll(){
        return productService.findAll();
    }
}
