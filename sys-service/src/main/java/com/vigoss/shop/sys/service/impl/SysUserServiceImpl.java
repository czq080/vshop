package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.common.exception.sys.SysErrorUserPasswdException;
import com.vigoss.shop.common.exception.sys.SysUserBeyondPowerException;
import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.sys.dao.mapper.SysUserMapper;
import com.vigoss.shop.sys.dto.SysUserAndRole;
import com.vigoss.shop.sys.entity.SysUser;
import com.vigoss.shop.sys.service.SysRoleService;
import com.vigoss.shop.sys.service.SysUserRoleService;
import com.vigoss.shop.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 * @author 李鹏军
 * @email 951449465@qq.com
 * @date 2016年12月18日 上午9:46:09
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserDao;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public List<String> queryAllPerms(Long userId) {
        return sysUserDao.queryAllPerms(userId);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return sysUserDao.queryAllMenuId(userId);
    }

    @Override
    public SysUser queryByUserName(String username) {
        return sysUserDao.queryByUserName(username);
    }

    @Override
    public SysUser queryObject(Long userId) {
        return sysUserDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> queryList(Map<String, Object> map) {
        return sysUserDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysUserDao.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(SysUserAndRole sysUserAndRole) {
        SysUser user = sysUserAndRole.getUser();
        user.setCreateTime(new Date());
        //sha256加密
        user.setPassword("123456");
        sysUserDao.insert(user);
        //检查角色是否越权
        checkRole(sysUserAndRole);
        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), sysUserAndRole.getRoleIdList());
    }

    @Override
    @Transactional
    public void update(SysUserAndRole sysUserAndRole) {
        SysUser user = sysUserAndRole.getUser();
        if (StringUtils.isBlank(user.getPassword())) {
            user.setPassword("123456");
        } else {
            user.setPassword("123456");
        }
        sysUserDao.updateByPrimaryKey(user);

        //检查角色是否越权
        checkRole(sysUserAndRole);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), sysUserAndRole.getRoleIdList());
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] userId) {
        sysUserDao.deleteBatch(userId);
    }

    @Override
    public int updatePassword(Long userId, String password, String newPassword) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("password", password);
        map.put("newPassword", newPassword);
        int count = sysUserDao.updatePassword(map);
        if (count == 0) {
            throw new SysErrorUserPasswdException();
        }
        return count;
    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUserAndRole sysUserAndRole) {
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        SysUser user = sysUserAndRole.getUser();
        if (user.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户创建的角色列表
        List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());

        //判断是否越权
        if (!roleIdList.containsAll(sysUserAndRole.getRoleIdList())) {
            throw new SysUserBeyondPowerException();
        }
    }


//    @Override
//    public Page<UserWindowDto> findPage(UserWindowDto userWindowDto, int pageNum) {
//        PageHelper.startPage(pageNum, Constant.pageSize);
//        sysUserDao.queryListByBean(userWindowDto);
//        return PageHelper.endPage();
//    }
}
