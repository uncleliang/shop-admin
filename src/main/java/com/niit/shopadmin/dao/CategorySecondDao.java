package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.Categorysecond;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository : 只要方法定义符合特定的语法就可以不用写方法实现和SQL语句
 */
public interface CategorySecondDao extends JpaRepository<Categorysecond,Integer> {
}
