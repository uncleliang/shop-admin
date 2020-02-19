package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:31
 **/
public interface SysPermissionDao extends JpaRepository<SysPermission,Integer> {

}
