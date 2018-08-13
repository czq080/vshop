package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.sys.dao.mapper.SysUserRoleMapper;
import com.vigoss.shop.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleDao;

    @Override
    @Transactional
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if (roleIdList.size() == 0) {
            return;
        }
        //先删除用户与角色关系
        sysUserRoleDao.deleteByPrimaryKey(userId);
        //保存用户与角色关系
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        sysUserRoleDao.save(map);
    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return sysUserRoleDao.queryRoleIdList(userId);
    }

    @Override
    @Transactional
    public void delete(Long userId) {
        sysUserRoleDao.delete(userId);
    }
}
