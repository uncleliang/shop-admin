package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.model.ResultBean;
import com.niit.shopadmin.redis.RedisService;
import com.niit.shopadmin.redis.key.ProductKey;
import com.niit.shopadmin.redis.key.SysPermissionKey;
import com.niit.shopadmin.service.ICategorySecondService;
import com.niit.shopadmin.service.ICategoryService;
import com.niit.shopadmin.service.IProductService;
import com.niit.shopadmin.service.ISysPermissionService;
import com.niit.shopadmin.service.impl.ImageService;
import com.niit.shopadmin.util.ConsUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.context.webflux.SpringWebFluxContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    RedisService redisService;

    @Autowired
    ThymeleafViewResolver thymeleafViewResolver;

    /**
     *  打开商品列表界面
     * @return
     */
    @RequestMapping("/list2")
    @RequiresPermissions("product:view")
    public String list2(){

        return "product/list";
    }


    /**
     *  打开商品列表界面
     * @return
     */
    @RequestMapping(value = "/list",produces="text/html")
    @RequiresPermissions("product:view")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response,ModelMap map){
        // TODO 页面缓存
        String html;
        html = (String)redisService.get(ProductKey.getListHTML.getKeyPrefix());

        if(html!=null&&!html.equals("")){
            return html;
        }

        // 手动解析界面
        WebContext context = new WebContext(request,response,request.getServletContext(),request.getLocale(),map);

        html = thymeleafViewResolver.getTemplateEngine().process("product/list",context);
        redisService.set(ProductKey.getListHTML.getKeyPrefix(),html,60*2);
        return html;
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    @RequiresPermissions("product:view")
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
    @RequiresPermissions("product:delete")
    public String deleteById(@PathVariable("id") Integer id){

        productService.deleteById(id);

        return "product/list";
    }

    @RequestMapping("/goUpdate/{id}")
    @RequiresPermissions("product:update")
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
    @RequiresPermissions("product:update")
    public ResultBean imageUpload(@RequestParam("file")MultipartFile file){

        return imageService.upload(file);
    }

    @PostMapping("/update")
    public String update(Product product){

        productService.update(product);

        return "redirect:/product/list";
    }

    @GetMapping("/goAdd")
    @RequiresPermissions("product:add")
    public String add(ModelMap map){
        // 查询全部的一级分类
        map.put("categories",categoryService.findAll());
        // 查询全部的二级分类
        map.put("categorySeconds",categorySecondService.findAll());

        return "product/add";
    }
    @PostMapping("/add")
    @RequiresPermissions("product:add")
    public String add(Product product){

        productService.add(product);

        return "redirect:/product/list";
    }
}
