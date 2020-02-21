package com.niit.shopadmin.model;

import java.io.Serializable;
import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-21 13:35
 **/
public class PermissionParam implements Serializable {

    private Integer id;
    private String name;
    private String desc;

    private List<TreeNode> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public List<TreeNode> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<TreeNode> permissions) {
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
