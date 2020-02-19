package com.niit.shopadmin.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 09:25
 **/
@Entity
@Table(name = "sys_role", schema = "shop", catalog = "")
public class SysRole {
    private Integer id;
    private String name;
    private String desc;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @OneToMany
    @JoinTable(name="sys_role_permission",joinColumns={@JoinColumn(name="role_id")}
            ,inverseJoinColumns={@JoinColumn(name="permission_id")})
    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    List<SysPermission> permissions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole sysRole = (SysRole) o;
        return Objects.equals(id, sysRole.id) &&
                Objects.equals(name, sysRole.name) &&
                Objects.equals(desc, sysRole.desc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, desc);
    }


}
