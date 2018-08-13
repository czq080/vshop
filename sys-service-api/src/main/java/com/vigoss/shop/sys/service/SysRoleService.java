package com.vigoss.shop.sys.service;

import com.vigoss.shop.sys.dto.SysRoleAndMenuAndDept;
import com.vigoss.shop.sys.entity.SysRole;

import java.util.List;
import java.util.Map;


/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
public interface SysRoleService {

    SysRole queryObject(Long roleId);

    List<SysRole> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(SysRoleAndMenuAndDept sysRoleAndMenuAndDept);

    void update(SysRoleAndMenuAndDept sysRoleAndMenuAndDept);

    void deleteBatch(Long[] roleIds);

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

//    /**
//     * 分页查询角色审批选择范围
//     * @return
//     */
//    Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNmu);
}
