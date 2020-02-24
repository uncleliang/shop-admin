package com.niit.shopadmin.controller;

import com.niit.shopadmin.model.*;
import com.niit.shopadmin.redis.RedisService;
import com.niit.shopadmin.redis.key.SysPermissionKey;
import com.niit.shopadmin.service.ISysPermissionService;
import com.niit.shopadmin.service.ISysRolePermissionService;
import com.niit.shopadmin.service.ISysRoleService;
import com.niit.shopadmin.util.ConsUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: shop-admin
 * @description:
 * @author: hanliang
 * @create: 2020-02-21 10:04
 **/
@Controller
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    ISysPermissionService permissionService;

    @Autowired
    ISysRoleService roleService;

    @Autowired
    ISysRolePermissionService rolePermissionService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/goAdd")
    public String goAdd(){
        return "role/add";
    }


    @RequestMapping("/getTreeNodes")
    @ResponseBody
    public List<TreeNode> getTreeNodes(){
        List<TreeNode> data = new ArrayList<>();

        List  permissions= permissionService.findAll();

        for(Object o : permissions){
            SysPermission p = (SysPermission)o;
            TreeNode node = new TreeNode();

            node.setId(p.getId());
            node.setName(p.getName());
            node.setpId(p.getParentId());
            if(p.getParentId()==ConsUtil.TOP_NODE){
                node.setOpen(true);
            }

            data.add(node);
        }

        return data;
    }


    @RequestMapping("/add")
    @ResponseBody
    public ResultBean add(@RequestBody()PermissionParam param){

        // 1 添加角色
        SysRole sysRole = new SysRole();
        sysRole.setName(param.getName());
        sysRole.setDesc(param.getDesc());

        SysRole result = roleService.save(sysRole);

        // 2.添加权限

        List<SysRolePermission> rolePermissions = new ArrayList<>();

        for(TreeNode n : param.getPermissions()){
            SysRolePermission rp = new SysRolePermission();

            rp.setRoleId(result.getId());
            rp.setPermissionId(n.getId());

            rolePermissions.add(rp);
        }

        rolePermissionService.saveAll(rolePermissions);

        return ResultBean.SUCCESS;
    }

    @RequestMapping("/list")
    public String list(){
        return "role/list";
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    // @RequiresPermissions("role:view")
    public Map<String, Object> findAll(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize")Integer pageSize){

        // JPA实现分页
        PageRequest pageRequest = PageRequest.of(pageNumber-1,pageSize);

        Page<SysRole> pageData = roleService.findAll(pageRequest);

        // 数据的总的行数
        long total = pageData.getTotalElements();
        // 当前页的数据
        List<SysRole> list = pageData.getContent();

        Map<String, Object> map = new HashMap<>();
        // total 和 rows 是bootstrap-table固定的两参数名称
        map.put("total", total);
        map.put("rows", list);
        return map;

    }

    @RequestMapping("/goUpdate/{id}")
    public String goUpdate(@PathVariable("id") Integer id, ModelMap map){

        map.addAttribute("role",roleService.findById(id));

        return "role/update";
    }


    /**
     * 根据角色ID获取角色权限列表树形结构
     * @param roleId
     * @return
     */
    @RequestMapping("/getTreeNodesForUpdate")
    @ResponseBody
    public List<TreeNode> getTreeNodesForUpdate(@RequestParam("id") Integer roleId){
        List<TreeNode> data = new ArrayList<>();

        // 全部权限
        List<SysPermission> permissions= permissionService.findAll();

        // 角色所有的权限
        List<SysPermission> rolePermissions = roleService.findById(roleId).getPermissions();

        for(SysPermission p : permissions){
            TreeNode node = new TreeNode();

            node.setId(p.getId());
            node.setName(p.getName());
            node.setpId(p.getParentId());
            if(p.getParentId()==ConsUtil.TOP_NODE){
                node.setOpen(true);
            }
            if(rolePermissions.contains(p)){
                node.setChecked(true);
            }
            data.add(node);
        }

        return data;
    }


    /**
     * 更新角色信息以及权限列表
     * @param param
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultBean update(@RequestBody()PermissionParam param){

        // 1 添加角色
        SysRole sysRole = new SysRole();
        sysRole.setId(param.getId());
        sysRole.setName(param.getName());
        sysRole.setDesc(param.getDesc());

        int result = roleService.updateById(sysRole);

        // 2.更新权限

        List<SysRolePermission> addPermissions = new ArrayList<>();
        List<SysRolePermission> delPermissions = new ArrayList<>();

        for(TreeNode n : param.getPermissions()){
            SysRolePermission rp = new SysRolePermission();

            rp.setRoleId(param.getId());
            rp.setPermissionId(n.getId());

            if(n.getChecked()){
                addPermissions.add(rp);
            }else{
                delPermissions.add(rp);
            }

        }

        rolePermissionService.saveAll(addPermissions);

        System.out.println(delPermissions.size()+delPermissions.toArray().toString());
        rolePermissionService.deleteInBatch(delPermissions);

        return ResultBean.SUCCESS;
    }
}
