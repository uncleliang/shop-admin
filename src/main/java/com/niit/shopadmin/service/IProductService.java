package com.niit.shopadmin.service;

import com.niit.shopadmin.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    void deleteById(Integer id);

    Product findById(Integer id);

    Product update(Product product);

    Product add(Product product);
}
