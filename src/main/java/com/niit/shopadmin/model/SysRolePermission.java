package com.niit.shopadmin.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 09:25
 **/
@Entity
@Table(name = "sys_role_permission", schema = "shop", catalog = "")
public class SysRolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "permission_id")
    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRolePermission that = (SysRolePermission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(roleId, that.roleId) &&
                Objects.equals(permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleId, permissionId);
    }

}
