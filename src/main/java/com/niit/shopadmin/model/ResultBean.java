package com.niit.shopadmin.model;

import com.niit.shopadmin.util.ConsUtil;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-18 13:59
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> {

    private Integer Code=ConsUtil.RES_CODE_SUCCES;

    private String message;

    private T data;

    public static ResultBean SUCCESS= new ResultBean(0); // 0表示没有错误

    public ResultBean(Integer code, String message) {
        Code = code;
        this.message = message;
    }

    public ResultBean(Integer code) {
        Code = code;
    }
}
