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
import java.util.Random;

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

    // 1. synchronized 加在方法上，效率低，容易造成线程阻塞
    // 2. synchronized 加在代码块上
    @Override
    public  List  findAll() {// 热点数据/高频数据  放在redis里面加快系统相应速度，降低数据库的压力
        List permissions = new ArrayList();
        Random r = new Random();
        // 从redis中查询权限
        permissions = redisService.lGet(SysPermissionKey.getPermissions.getKeyPrefix()+":002",0,-1);

        System.out.println("redis中查询数据，结果不知道是不是为空");

        if(permissions == null || permissions.size() == 0){
            synchronized (this){
                permissions = redisService.lGet(SysPermissionKey.getPermissions.getKeyPrefix()+":002",0,-1);
                // 如果redis中缓存为空，则去数据库查询
                if (permissions == null || permissions.size() == 0) {
                    System.out.println("redis中没有数据，去数据库中查询数据....");
                    permissions = dao.findAll();
                    redisService.lSet(SysPermissionKey.getPermissions.getKeyPrefix()+":002", permissions, ConsUtil.TIME_ONE_MINUTES+r.nextInt(6));
                }
            }
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
