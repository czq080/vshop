package com.vigoss.shop.management.api.controller;


import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.sys.entity.SysDept;
import com.vigoss.shop.sys.service.SysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 部门管理
 *
 * @author liepngjun
 * @email 951449465@qq.com
 * @date 2017-09-17 23:58:47
 */
@RestController
@RequestMapping("${api.prefix}/dept")
public class SysDeptController extends BaseController {
    @Autowired
    private SysDeptService sysDeptService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:dept:list")
    public ResponseEntity list() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只能查询本部门及子部门数据
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
        }
        List<SysDept> deptList = sysDeptService.queryList(map);
        return setSuccessResponsep(deptList);
    }

    /**
     * 选择部门(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:dept:select")
    public ResponseEntity select() {
        Map<String, Object> map = new HashMap<>();
        //如果不是超级管理员，则只能查询本部门及子部门数据
        if (getUserId() != Constant.SUPER_ADMIN) {
            map.put("deptFilter", sysDeptService.getSubDeptIdList(getDeptId()));
        }
        List<SysDept> deptList = sysDeptService.queryList(map);

        //添加一级部门
        if (getUserId() == Constant.SUPER_ADMIN) {
            SysDept root = new SysDept();
            root.setDeptId(0L);
            root.setName("一级部门");
            root.setParentId(-1L);
//            root.setOpen(true);
            deptList.add(root);
        }

        return setSuccessResponsep(deptList);
    }

    /**
     * 上级部门Id(管理员则为0)
     */
    @RequestMapping("/info")
    @RequiresPermissions("sys:dept:list")
    public ResponseEntity info() {
        long deptId = 0;
        if (getUserId() != Constant.SUPER_ADMIN) {
            SysDept dept = sysDeptService.queryObject(getDeptId());
            deptId = dept.getParentId();
        }

        return setSuccessResponsep(deptId);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    @RequiresPermissions("sys:dept:info")
    public ResponseEntity info(@PathVariable("deptId") Long deptId) {
        SysDept dept = sysDeptService.queryObject(deptId);

        return setSuccessResponsep(dept);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:dept:save")
    public ResponseEntity save(@RequestBody SysDept dept) {
        sysDeptService.save(dept);

        return setSuccessResponsep(dept);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:dept:update")
    public ResponseEntity update(@RequestBody SysDept dept) {
        sysDeptService.update(dept);

        return setSuccessResponsep();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:dept:delete")
    public ResponseEntity delete(long deptId) {
        //判断是否有子部门
        List<Long> deptList = sysDeptService.queryDetpIdList(deptId);
        if (deptList.size() > 0) {
            return setFailResponse("请先删除子部门");
        }
        sysDeptService.delete(deptId);
        return setSuccessResponsep();
    }

}
