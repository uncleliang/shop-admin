package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {

}
