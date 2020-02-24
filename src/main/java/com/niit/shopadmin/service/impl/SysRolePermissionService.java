package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.SysRolePermissionDao;
import com.niit.shopadmin.model.SysRolePermission;
import com.niit.shopadmin.service.ISysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-21 14:04
 **/
@Service
public class SysRolePermissionService implements ISysRolePermissionService {

    @Autowired
    SysRolePermissionDao dao;

    @Override
    @Transactional
    public List<SysRolePermission> saveAll(List<SysRolePermission> permissions) {
        List<SysRolePermission> list = dao.saveAll(permissions);
        return list;
    }

    @Override
    @Transactional
    public void deleteInBatch(List<SysRolePermission> permissions) {
        permissions.forEach(
           e -> dao.deleteByRoleIdAndPermissionId(e.getRoleId(),e.getPermissionId())
        );

        for(SysRolePermission e : permissions){
            dao.deleteByRoleIdAndPermissionId(e.getRoleId(),e.getPermissionId());
        }
    }
}
