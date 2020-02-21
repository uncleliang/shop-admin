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
@Table(name = "sys_permission", schema = "shop", catalog = "")
public class SysPermission {
    private Integer id;
    private String name;
    private String path;
    private String desc;
    private String permission;
    private Integer type;
    private Integer parentId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "[name]")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "[desc]")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Basic
    @Column(name = "permission")
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "parent_id")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPermission that = (SysPermission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(path, that.path) &&
                Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, path, desc);
    }
}
