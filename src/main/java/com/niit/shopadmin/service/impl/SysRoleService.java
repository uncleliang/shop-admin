package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.SysRoleDao;
import com.niit.shopadmin.model.SysRole;
import com.niit.shopadmin.service.ISysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-21 13:55
 **/
@Service
public class SysRoleService implements ISysRoleService {

    @Autowired
    SysRoleDao dao;

    @Override
    public SysRole save(SysRole sysRole) {
        return dao.save(sysRole);
    }

    @Override
    public Page<SysRole> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public SysRole findById(Integer id) {
        return dao.getOne(id);
    }

    @Override
    @Transactional
    public int updateById(SysRole sysRole) {

        return dao.updateById(sysRole.getName(),sysRole.getDesc(),sysRole.getId());
    }
}
