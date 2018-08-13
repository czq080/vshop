package com.vigoss.shop.sys.service;

import com.vigoss.shop.sys.dto.SysUserAndRole;
import com.vigoss.shop.sys.entity.SysUser;

import java.util.List;
import java.util.Map;


/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
public interface SysUserService {

    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    SysUser queryByUserName(String username);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    SysUser queryObject(Long userId);

    /**
     * 查询用户列表
     */
    List<SysUser> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存用户
     */
    void save(SysUserAndRole sysUserAndRole);

    /**
     * 修改用户
     */
    void update(SysUserAndRole sysUserAndRole);

    /**
     * 删除用户
     */
    void deleteBatch(Long[] userIds);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param password    原密码
     * @param newPassword 新密码
     */
    int updatePassword(Long userId, String password, String newPassword);

//    /**
//     * 根据条件分页查询
//     * @param userEntity
//     * @param pageNum
//     * @return
//     */
//    Page<UserWindowDto> findPage(UserWindowDto userEntity, int pageNum);
}
