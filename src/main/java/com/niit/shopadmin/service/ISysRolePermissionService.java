package com.niit.shopadmin.service;

import com.niit.shopadmin.model.SysRolePermission;

import java.util.List;

public interface ISysRolePermissionService {

    List<SysRolePermission> saveAll(List<SysRolePermission> permissions);

    void deleteInBatch(List<SysRolePermission> permissions);

}
