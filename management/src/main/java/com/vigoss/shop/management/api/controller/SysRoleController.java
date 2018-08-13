package com.vigoss.shop.management.api.controller;

import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.common.validator.ValidatorUtils;
import com.vigoss.shop.sys.dto.SysRoleAndMenuAndDept;
import com.vigoss.shop.sys.entity.SysRole;
import com.vigoss.shop.sys.service.SysRoleDeptService;
import com.vigoss.shop.sys.service.SysRoleMenuService;
import com.vigoss.shop.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/role")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    /**
     * 角色列表
     */
    @RequestMapping(value = "/list")
    @RequiresPermissions("sys:role:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //如果不是超级管理员，则只查询自己创建的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", getUserId());
        }
        //查询列表数据
        Query query = new Query(params);
        List<SysRole> list = sysRoleService.queryList(query);
        int total = sysRoleService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
        return setSuccessResponsep(pageUtil);
    }

    /**
     * 角色列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public ResponseEntity select() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只查询自己所拥有的角色列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("createUserId", getUserId());
        }
        List<SysRole> list = sysRoleService.queryList(map);

        return setSuccessResponsep(list);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public ResponseEntity info(@PathVariable("roleId") Long roleId) {
        SysRole role = sysRoleService.queryObject(roleId);
        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
        //查询角色对应的部门
        List<Long> deptIdList = sysRoleDeptService.queryDeptIdList(roleId);
        return setSuccessResponsep(new SysRoleAndMenuAndDept(role, menuIdList, deptIdList));
    }

    /**
     * 保存角色
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public ResponseEntity save(@RequestParam SysRole role, @RequestParam List<Long> menuIdList, @RequestParam List<Long> deptIdList) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());
        sysRoleService.save(new SysRoleAndMenuAndDept(role, menuIdList, deptIdList));
        return setSuccessResponsep();
    }

    /**
     * 修改角色
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResponseEntity update(@RequestParam SysRole role, @RequestParam List<Long> menuIdList, @RequestParam List<Long> deptIdList) {
        ValidatorUtils.validateEntity(role);
        role.setCreateUserId(getUserId());
        sysRoleService.update(new SysRoleAndMenuAndDept(role, menuIdList, deptIdList));
        return setSuccessResponsep();
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public ResponseEntity delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);
        return setSuccessResponsep();
    }
}
