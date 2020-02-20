package com.niit.shopadmin.service;

import com.niit.shopadmin.model.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISysUserService {

    SysUser findSysUserByUsername(String username);

    Page<SysUser> findAll(Pageable pageable);
}
