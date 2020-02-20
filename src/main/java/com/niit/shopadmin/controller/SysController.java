package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.ResultBean;
import com.niit.shopadmin.util.ConsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 13:49
 **/
@Controller
public class SysController {

    @RequestMapping(value = "/")
    public String homePage() {
        return "sys/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(String username, String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            // subject 调用realm 的doGetAuthenticationInfo方法完成用户名和密码的check
            subject.login(token);
        }catch(UnknownAccountException e){
            return  new ResultBean(ConsUtil.RES_CODE_ERROR,ConsUtil.E_USER_NOT_EXISTS);

        }catch(IncorrectCredentialsException e){
            return  new ResultBean(ConsUtil.RES_CODE_ERROR,ConsUtil.E_PASSWORD_ERROR);
        }


        return ResultBean.SUCCESS;
    }

    @RequestMapping("/index")
    public String index(){

        return "product/list";
    }

//    @RequestMapping("/error")
//    public String error(){
//        return "sys/error";
//    }
}
