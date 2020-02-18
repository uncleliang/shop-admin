package com.niit.shopadmin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-17 10:00
 **/
@Data
@Entity  // 当前类是JPA的实体类，跟数据库中的表进行映射
public class Product {

    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer pid;

    private String pname;
    private Double market_price;
    private Double shop_price;
    private String image;
    private String pdesc;
    private Integer is_hot;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pdate;
    private Integer csid;

}
