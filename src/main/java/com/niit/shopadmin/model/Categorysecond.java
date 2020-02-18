package com.niit.shopadmin.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-18 09:27
 **/
@Data
@Entity
public class Categorysecond {

    @Id
    @GeneratedValue
    private Integer csid;
    private String csname;
    private Integer cid;
}
