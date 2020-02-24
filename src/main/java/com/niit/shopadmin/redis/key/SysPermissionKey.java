package com.niit.shopadmin.redis.key;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-24 14:06
 **/
public class SysPermissionKey extends BasePrefix {

    public SysPermissionKey(long expire, String prefix) {
        super(expire, prefix);
    }

    public SysPermissionKey(String prefix) {
        super(prefix);
    }

    public static SysPermissionKey getByName = new SysPermissionKey("name");

    public static SysPermissionKey getById = new SysPermissionKey("id");

    public static SysPermissionKey getMenus = new SysPermissionKey("menus");

    public static SysPermissionKey getPermissions = new SysPermissionKey("permissions");
}
