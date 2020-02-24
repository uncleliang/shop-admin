package com.niit.shopadmin.controller;

import com.niit.shopadmin.redis.RedisService;
import com.niit.shopadmin.redis.key.SysPermissionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-24 12:56
 **/
@Controller
public class TestController {

    @Autowired
    RedisService redisService;

    @RequestMapping("/set")
    @ResponseBody
    public String set(){

        redisService.set(SysPermissionKey.getByName,"","菜单管理",1000);

        return "success";
    }



    @RequestMapping("/get")
    @ResponseBody
    public String get(){

        String value = (String)redisService.get("testKey:1");
        System.out.println(value);
        return "success";
    }
}
