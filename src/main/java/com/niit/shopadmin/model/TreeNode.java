package com.niit.shopadmin.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-21 10:17
 **/
public class TreeNode implements Serializable {

    private Integer id;
    private Integer pId;

    private String name;
    private Boolean open=false;
    private Boolean checked=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
