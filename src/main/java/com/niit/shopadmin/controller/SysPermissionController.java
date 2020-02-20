package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-20 13:50
 **/
@Controller
@RequestMapping("/permission")
public class SysPermissionController {


    @Autowired
    ISysPermissionService permissionService;

    @RequestMapping("/list")
    public String showPermission(){
        return "permission/list";
    }

    @RequestMapping("/test")
    public String test(){
        return "permission/test";
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
   // @RequiresPermissions("permission:view")
    public  Map<String, Object>  findAll(){

        // JPA实现分页
       // PageRequest pageRequest = PageRequest.of(1-1,10);

        List<SysPermission> pageData = permissionService.findAll();

        // 数据的总的行数
       //long total = pageData.getTotalElements();
        // 当前页的数据
       // List<SysPermission> list = pageData.getContent();

        Map<String, Object> map = new HashMap<>();
        // total 和 rows 是bootstrap-table固定的两参数名称
        map.put("total", 11);
       map.put("rows", pageData);
        return map;

    }
}
