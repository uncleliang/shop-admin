package com.niit.shopadmin.service;

import com.niit.shopadmin.model.Category;
import com.niit.shopadmin.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
}
