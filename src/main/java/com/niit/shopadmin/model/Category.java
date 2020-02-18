package com.niit.shopadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-18 09:31
 **/
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Integer cid;
    private String cname;
}
