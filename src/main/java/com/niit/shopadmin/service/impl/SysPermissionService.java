package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.SysPermissionDao;
import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.redis.RedisService;
import com.niit.shopadmin.redis.key.SysPermissionKey;
import com.niit.shopadmin.service.ISysPermissionService;
import com.niit.shopadmin.util.ConsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    RedisService redisService;


    @Override
    public Page<SysPermission> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public List findAll() {
        List permissions = new ArrayList();
        // 从redis中查询权限
        permissions = redisService.lGet(SysPermissionKey.getPermissions.getKeyPrefix(),0,-1);

        if(permissions==null||permissions.size()==0){
            permissions= dao.findAll();
            redisService.lSet(SysPermissionKey.getPermissions.getKeyPrefix(),permissions,ConsUtil.TIME_TWO_HOUR);
        }
        return permissions;
    }

    @Override
    public List<SysPermission> findSysPermissionByParentId(Integer parentId) {
        return dao.findSysPermissionByParentId(parentId);
    }

    @Override
    public SysPermission save(SysPermission entity) {
        return dao.save(entity);
    }

    @Override
    public List<SysPermission> findSysPermissionByType(Integer type) {
        return dao.findSysPermissionByType(type);
    }
}
