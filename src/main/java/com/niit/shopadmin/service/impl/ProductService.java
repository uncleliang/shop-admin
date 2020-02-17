package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.ProductDao;
import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-17 10:09
 **/
@Service
public class ProductService implements IProductService {

    @Autowired
    ProductDao dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }
}
