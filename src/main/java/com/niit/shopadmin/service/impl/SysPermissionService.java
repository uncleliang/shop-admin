package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.SysPermissionDao;
import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-20 14:53
 **/
@Service
public class SysPermissionService implements ISysPermissionService {

    @Autowired
    SysPermissionDao dao;


    @Override
    public Page<SysPermission> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public List<SysPermission> findAll() {
        return dao.findAll();
    }
}
