package com.niit.shopadmin.redis.pubandsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-25 14:24
 **/
@Controller
public class PublisherDemo {
    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping("/sendMessage")
    @ResponseBody
    public String testSend() throws InterruptedException {
        for(int i=0;i<5;i++){
            redisTemplate.convertAndSend("Channel:1","来自遥远的星球的一条消息");
            Thread.sleep(1000);
        }

        return "success";
    }
}
