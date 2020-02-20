package com.niit.shopadmin.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 15:39
 **/
@ControllerAdvice
public class ShiroExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(Exception ex){ // ex被捕获到的异常
        ModelAndView mv = new ModelAndView();

        if(ex instanceof UnauthorizedException){
            mv.addObject("message","权限不足");
        }else{
            mv.addObject("message","未知异常，请联系管理员!"+ex.getMessage());

        }


        mv.setViewName("sys/error");


        return mv;
    }
}
