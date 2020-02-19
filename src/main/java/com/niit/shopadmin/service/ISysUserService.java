package com.niit.shopadmin.service;

import com.niit.shopadmin.model.SysUser;

public interface ISysUserService {

    SysUser findSysUserByUsername(String username);
}
