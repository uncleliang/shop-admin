package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository : 只要方法定义符合特定的语法就可以不用写方法实现和SQL语句
 */
public interface ProductDao extends JpaRepository<Product,Integer> {

    List<Product> findAllByPnameAndAndCsid(String pname, Integer csid);
}
