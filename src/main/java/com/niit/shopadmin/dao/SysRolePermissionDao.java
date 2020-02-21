package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.model.SysRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:31
 **/
public interface SysRolePermissionDao extends JpaRepository<SysRolePermission,Integer> {


    List<SysRolePermission> deleteByRoleIdAndPermissionId(Integer roleId,Integer permissionId);
}
