package com.niit.shopadmin.service;

import com.niit.shopadmin.model.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ISysRoleService {

    SysRole save(SysRole sysRole);

    Page<SysRole> findAll(Pageable pageable);

    SysRole findById(Integer id);

    // SysRole updateById();

    int updateById(SysRole sysRole);
}
