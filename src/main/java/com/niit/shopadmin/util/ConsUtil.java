package com.niit.shopadmin.util;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-18 14:04
 **/
public class ConsUtil {

    public static final int TOP_NODE=0;
    public static final int RES_CODE_SUCCES=0;
    public static final int RES_CODE_ERROR=-1;
    public static final String E_FORMAT_ERROR="只允许上传png,jpg,jpeg,gif格式的文件";
    public static final String E_UPLOAD_ERROR="上传失败";


    public static final String E_USER_NOT_EXISTS="用户不存在";
    public static final String E_PASSWORD_ERROR="密码错误";
    public static final String E_NO_PERMISSION="权限不足";

    public static final int  PERM_TYPE_MENUE=1;
    public static final int  PERM_TYPE_PERMISSION=2;

    public static final long TIME_ONE_MINUTES = 60*5;

    public static final long TIME_ONE_HOUR = 60*60;
    public static final long TIME_TWO_HOUR = 60*60*2;
    public static final long TIME_HALF_DAY = 60*60*12;
    public static final long TIME_DAY = 60*60*24;
    public static final long TIME_WEEK = 60*60*24*7;
    public static final long TIME_MONTH = 60*60*24*30;
}
