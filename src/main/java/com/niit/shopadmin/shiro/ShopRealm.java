package com.niit.shopadmin.shiro;

import com.niit.shopadmin.model.SysPermission;
import com.niit.shopadmin.model.SysUser;
import com.niit.shopadmin.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:06
 **/
public class ShopRealm extends AuthorizingRealm {

    @Autowired
    ISysUserService sysUserService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 当前登陆用户的用户名
        String username = (String) principalCollection.getPrimaryPrincipal();

        // 查询当前用户的全部权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = sysUserService.findSysUserByUsername(username);

        // 角色
        simpleAuthorizationInfo.addRole(user.getSysRole().getName());

        // 添加权限列表
        for(SysPermission sp : user.getSysRole().getPermissions()){
            simpleAuthorizationInfo.addStringPermission(sp.getPermission());
        }

        return simpleAuthorizationInfo;
    }

    /**
     *
     * 登陆
     *
     * @param authenticationToken 登陆的token对象记录着 用户名和密码
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 取出登陆输入的用户名
        String username =(String)authenticationToken.getPrincipal();

        // 执行数据库查询 检查用户是否存在
        SysUser sysUser = sysUserService.findSysUserByUsername(username);

        if(sysUser!=null){
            return new SimpleAuthenticationInfo(username,sysUser.getPassword(),getName()); // Subject 登陆的时候用Subject来判断登陆结果
        }
        return null;
    }
}
