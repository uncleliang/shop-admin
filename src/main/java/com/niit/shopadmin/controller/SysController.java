package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.ResultBean;
import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.redis.RedisService;
import com.niit.shopadmin.redis.key.SysPermissionKey;
import com.niit.shopadmin.service.ISysPermissionService;
import com.niit.shopadmin.service.ISysUserService;
import com.niit.shopadmin.util.ConsUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 13:49
 **/
@Controller
public class SysController {

    @Autowired
    ISysPermissionService permissionService;

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/")
    public String homePage() {
        return "sys/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public ResultBean login(String username, String password,HttpSession session){

        Subject subject = SecurityUtils.getSubject();

        // Session session1 = subject.getSession(true);

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            // subject 调用realm 的doGetAuthenticationInfo方法完成用户名和密码的check
            subject.login(token);
        }catch(UnknownAccountException e){
            return  new ResultBean(ConsUtil.RES_CODE_ERROR,ConsUtil.E_USER_NOT_EXISTS);

        }catch(IncorrectCredentialsException e){
            return  new ResultBean(ConsUtil.RES_CODE_ERROR,ConsUtil.E_PASSWORD_ERROR);
        }

        // 所有菜单列表
        List menus = permissionService.findSysPermissionByType(ConsUtil.PERM_TYPE_MENUE);
        session.setAttribute("MENUS",menus);

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
