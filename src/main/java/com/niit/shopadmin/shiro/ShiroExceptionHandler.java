package com.niit.shopadmin.shiro;

import org.apache.shiro.authz.UnauthorizedException;
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

    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView exceptionHander(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sys/error");
        mv.addObject("message","权限不足");

        return mv;
    }
}
