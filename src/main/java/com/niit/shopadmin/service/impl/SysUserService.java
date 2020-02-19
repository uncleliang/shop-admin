package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.SysUserDao;
import com.niit.shopadmin.model.SysUser;
import com.niit.shopadmin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:33
 **/
@Service
public class SysUserService implements ISysUserService {

    @Autowired
    SysUserDao dao;
    @Override
    public SysUser findSysUserByUsername(String username) {
        return dao.findSysUserByUsername(username);
    }
}
