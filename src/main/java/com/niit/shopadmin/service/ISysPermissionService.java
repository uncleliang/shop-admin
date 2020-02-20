package com.niit.shopadmin.service;

import com.niit.shopadmin.model.SysPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-20 14:52
 **/
public interface ISysPermissionService {

    Page<SysPermission> findAll(Pageable pageable);

    List<SysPermission> findAll();
}
