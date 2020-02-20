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
@Table(name = "sys_user", schema = "shop", catalog = "")
public class SysUser {
    private Integer id;
    private String username;
    private String password;
    private String trueName;
    private String phone;
    private Integer roleId;
    private Integer state;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "true_name")
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
//    @Basic
//    @Column(name = "role_id")
//    public Integer getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Integer roleId) {
//        this.roleId = roleId;
//    }
//


    private SysRole sysRole;//角色

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(username, sysUser.username) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(trueName, sysUser.trueName) &&
                Objects.equals(phone, sysUser.phone) &&
                Objects.equals(roleId, sysUser.roleId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, trueName, phone, roleId);
    }


}
