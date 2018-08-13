package com.vigoss.shop.sys.dto;

import com.vigoss.shop.sys.entity.SysRole;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 16:19 2018/5/23
 * @Modified By:
 */
public class SysRoleAndMenuAndDept implements Serializable {
    private SysRole sysRole;
    private List<Long> menuIdList;
    private List<Long> deptIdList;

    public SysRoleAndMenuAndDept(SysRole sysRole, List<Long> menuIdList, List<Long> deptIdList) {
        this.sysRole = sysRole;
        this.menuIdList = menuIdList;
        this.deptIdList = deptIdList;
    }

    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public List<Long> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<Long> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<Long> getDeptIdList() {
        return deptIdList;
    }

    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }
}
