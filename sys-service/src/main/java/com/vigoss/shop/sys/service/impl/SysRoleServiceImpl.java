package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.common.exception.sys.SysUserBeyondPowerException;
import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.sys.dao.mapper.SysRoleMapper;
import com.vigoss.shop.sys.dto.SysRoleAndMenuAndDept;
import com.vigoss.shop.sys.entity.SysRole;
import com.vigoss.shop.sys.service.SysRoleDeptService;
import com.vigoss.shop.sys.service.SysRoleMenuService;
import com.vigoss.shop.sys.service.SysRoleService;
import com.vigoss.shop.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleDao;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    @Override
    public SysRole queryObject(Long roleId) {
        return sysRoleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public List<SysRole> queryList(Map<String, Object> map) {
        return sysRoleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysRoleDao.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(SysRoleAndMenuAndDept sysRoleAndMenuAndDept) {
        SysRole role = sysRoleAndMenuAndDept.getSysRole();
        role.setCreateTime(new Date());
        sysRoleDao.insert(role);
        //检查权限是否越权
        checkPrems(sysRoleAndMenuAndDept);
        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), sysRoleAndMenuAndDept.getMenuIdList());
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), sysRoleAndMenuAndDept.getDeptIdList());
    }

    @Override
    @Transactional
    public void update(SysRoleAndMenuAndDept sysRoleAndMenuAndDept) {
        SysRole role = sysRoleAndMenuAndDept.getSysRole();
        sysRoleDao.updateByPrimaryKey(role);
        //检查权限是否越权
        checkPrems(sysRoleAndMenuAndDept);
        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), sysRoleAndMenuAndDept.getMenuIdList());
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), sysRoleAndMenuAndDept.getDeptIdList());
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] roleIds) {
        sysRoleDao.deleteBatch(roleIds);
    }

    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return sysRoleDao.queryRoleIdList(createUserId);
    }

    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRoleAndMenuAndDept sysRoleAndMenuAndDept) {
        SysRole role = sysRoleAndMenuAndDept.getSysRole();
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if (!menuIdList.containsAll(sysRoleAndMenuAndDept.getMenuIdList())) {
            throw new SysUserBeyondPowerException();
        }
    }

//    @Override
//    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
//        PageHelper.startPage(pageNum, Constant.pageSize);
//        sysRoleDao.queryPageByDto(userWindowDto);
//        return PageHelper.endPage();
//    }
}
