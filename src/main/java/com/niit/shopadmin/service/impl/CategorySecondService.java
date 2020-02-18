package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.CategorySecondDao;
import com.niit.shopadmin.model.Categorysecond;
import com.niit.shopadmin.service.ICategorySecondService;
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
public class CategorySecondService implements ICategorySecondService {

    @Autowired
    CategorySecondDao dao;

    @Override
    public List<Categorysecond> findAll() {
        return dao.findAll();
    }
}
