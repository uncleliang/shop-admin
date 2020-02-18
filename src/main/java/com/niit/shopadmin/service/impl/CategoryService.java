package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.CategoryDao;
import com.niit.shopadmin.dao.ProductDao;
import com.niit.shopadmin.model.Category;
import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.service.ICategoryService;
import com.niit.shopadmin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-17 10:09
 **/
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryDao dao;

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }
}
