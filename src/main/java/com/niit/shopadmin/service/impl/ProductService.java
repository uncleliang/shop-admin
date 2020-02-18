package com.niit.shopadmin.service.impl;

import com.niit.shopadmin.dao.ProductDao;
import com.niit.shopadmin.model.Product;
import com.niit.shopadmin.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Product findById(Integer id) {
        return dao.getOne(id);
    }

    @Override
    @Transactional //开启事务处理
    public Product update(Product product) {

        Product pro = dao.getOne(product.getPid());
        BeanUtils.copyProperties(product,pro);
        pro.setPdate(new Date());

        return dao.save(pro);
    }

    @Override
    @Transactional
    public Product add(Product product) {
        product.setPdate(new Date());
        return dao.save(product);
    }
}
