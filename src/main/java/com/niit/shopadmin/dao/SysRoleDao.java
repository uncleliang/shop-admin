package com.niit.shopadmin.dao;

import com.niit.shopadmin.model.SysRole;
import com.niit.shopadmin.model.SysUser;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-19 10:31
 **/
public interface SysRoleDao extends JpaRepository<SysRole,Integer> {


    @Modifying
    @Query(value = "update sys_role set `name`=:n,`desc`=:d where id=:id",nativeQuery = true)
    int updateById(@Param("n") String name,
                   @Param("d") String desc,
                   @Param("id")Integer id);
}
