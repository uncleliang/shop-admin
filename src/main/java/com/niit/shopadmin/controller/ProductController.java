package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.model.ResultBean;
import com.niit.shopadmin.service.ICategorySecondService;
import com.niit.shopadmin.service.ICategoryService;
import com.niit.shopadmin.service.IProductService;
import com.niit.shopadmin.service.impl.ImageService;
import com.niit.shopadmin.util.ConsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ICategorySecondService categorySecondService;

    @Autowired
    ImageService imageService;

    /**
     *  打开商品列表界面
     * @return
     */
    @RequestMapping("/list")
    public String list(){
        return "product/list";
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String, Object> findAll(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize")Integer pageSize){

        // JPA实现分页
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);

        Page<Product> pageData = productService.findAll(pageRequest);

        // 数据的总的行数
        long total = pageData.getTotalElements();
        // 当前页的数据
        List<Product> list = pageData.getContent();

        Map<String, Object> map = new HashMap<>();
        // total 和 rows 是bootstrap-table固定的两参数名称
        map.put("total", total);
        map.put("rows", list);
        return map;

    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){

        productService.deleteById(id);

        return "product/list";
    }

    @RequestMapping("/goUpdate/{id}")
    public String goUpdate(@PathVariable("id") Integer id,ModelMap map){
        // 查询全部的一级分类
        map.put("categories",categoryService.findAll());
        // 查询全部的二级分类
        map.put("categorySeconds",categorySecondService.findAll());
        Product p =  productService.findById(id);
        map.put("product",p);

        return "product/update";
    }


    @PostMapping("/imageUpload")
    @ResponseBody
    public ResultBean imageUpload(@RequestParam("file")MultipartFile file){

        return imageService.upload(file);
    }

    @PostMapping("/update")
    public String update(Product product){

        productService.update(product);

        return "redirect:/product/list";
    }

    @GetMapping("/goAdd")
    public String add(ModelMap map){
        // 查询全部的一级分类
        map.put("categories",categoryService.findAll());
        // 查询全部的二级分类
        map.put("categorySeconds",categorySecondService.findAll());

        return "product/add";
    }
    @PostMapping("/add")
    public String add(Product product){

        productService.add(product);

        return "redirect:/product/list";
    }
}
