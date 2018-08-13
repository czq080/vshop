package com.vigoss.shop.sys.dto;

import com.vigoss.shop.sys.entity.SysUser;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 15:51 2018/5/23
 * @Modified By:
 */
public class SysUserAndRole implements Serializable {
    private SysUser user;
    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    public SysUserAndRole(SysUser user, List<Long> roleIdList) {
        this.user = user;
        this.roleIdList = roleIdList;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<Long> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Long> roleIdList) {
        this.roleIdList = roleIdList;
    }
}
