package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.Categorysecond;
import com.niit.shopadmin.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:31
 **/
public interface SysUserDao extends JpaRepository<SysUser,Integer> {

   SysUser findSysUserByUsername(String username);
}
