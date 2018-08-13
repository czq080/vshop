package com.vigoss.shop.management.api.controller;

import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.common.validator.ValidatorUtils;
import com.vigoss.shop.common.validator.group.AddGroup;
import com.vigoss.shop.common.validator.group.UpdateGroup;
import com.vigoss.shop.management.api.shiro.ShiroUtils;
import com.vigoss.shop.sys.dto.SysUserAndRole;
import com.vigoss.shop.sys.entity.SysUser;
import com.vigoss.shop.sys.service.SysUserRoleService;
import com.vigoss.shop.sys.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/user")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() != Constant.SUPER_ADMIN) {
            params.put("createUserId", "sas");
        }
        Query query = new Query(params);
        List<SysUser> userList = sysUserService.queryList(query);
        int total = sysUserService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
        return setSuccessResponsep(pageUtil);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info")
    public ResponseEntity info() {
        return setSuccessResponsep(getUser());
    }

    /**
     * 修改登录用户密码
     */
    @RequestMapping("/password")
    public ResponseEntity password(@RequestParam String password, @RequestParam String newPassword) {

        //sha256加密
        password = new Sha256Hash(password).toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword).toHex();

        //更新密码
        sysUserService.updatePassword(getUserId(), password, newPassword);
        //退出
        ShiroUtils.logout();
        return setSuccessResponsep(getUser());
    }

    /**
     * 用户信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("sys:user:info")
    public ResponseEntity info(@PathVariable("userId") Long userId) {
        SysUser user = sysUserService.queryObject(userId);
        //获取用户所属的角色列表
        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
        SysUserAndRole sysUserAndRole = new SysUserAndRole(user, roleIdList);
        sysUserAndRole.setUser(user);
        sysUserAndRole.setRoleIdList(roleIdList);
        return setSuccessResponsep(sysUserAndRole);
    }

    /**
     * 保存用户
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public ResponseEntity save(@RequestParam SysUser user, @RequestParam List<Long> roleIdList) {
        ValidatorUtils.validateEntity(user, AddGroup.class);
        SysUserAndRole sysUserAndRole = new SysUserAndRole(user, roleIdList);
        user.setCreateUserId(getUserId());
        sysUserService.save(sysUserAndRole);
        return setSuccessResponsep();
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:user:update")
    public ResponseEntity update(@RequestParam SysUser user, @RequestParam List<Long> roleIdList) {
        ValidatorUtils.validateEntity(user, UpdateGroup.class);
        SysUserAndRole sysUserAndRole = new SysUserAndRole(user, roleIdList);
        user.setCreateUserId(getUserId());
        sysUserService.update(sysUserAndRole);
        return setSuccessResponsep();
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public ResponseEntity delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return setFailResponse("系统管理员不能删除");
        }

        if (ArrayUtils.contains(userIds, getUserId())) {
            return setFailResponse("当前用户不能删除");
        }
        sysUserService.deleteBatch(userIds);
        return setSuccessResponsep();
    }
}
