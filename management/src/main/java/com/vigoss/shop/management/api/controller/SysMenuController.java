package com.vigoss.shop.management.api.controller;

import com.vigoss.shop.common.exception.common.InputParamException;
import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.sys.dto.Tree;
import com.vigoss.shop.sys.entity.SysMenu;
import com.vigoss.shop.sys.service.SysMenuService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/menu")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysMenu> menuList = sysMenuService.queryList(query);
        int total = sysMenuService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(menuList, total, query.getLimit(), query.getPage());
        return setSuccessResponsep(pageUtil);
    }

    /**
     * 所有菜单列表
     */
    @RequestMapping("/queryAll")
    public ResponseEntity queryAll(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<SysMenu> menuList = sysMenuService.queryList(params);

        return setSuccessResponsep(menuList);
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public ResponseEntity select() {
        //查询列表数据
        List<SysMenu> menuList = sysMenuService.queryNotButtonList();

        //添加顶级菜单
        SysMenu root = new SysMenu();
        root.setMenuId(0L);
        root.setName("一级菜单");
        root.setParentId(-1L);
//        root.setOpen(true);
        menuList.add(root);

        return setSuccessResponsep(menuList);
    }

    /**
     * 角色授权菜单
     */
    @RequestMapping("/perms")
    @RequiresPermissions("sys:menu:perms")
    public ResponseEntity perms() {
        //查询列表数据
        List<SysMenu> menuList;

        //只有超级管理员，才能查看所有管理员列表
        if (getUserId() == Constant.SUPER_ADMIN) {
            menuList = sysMenuService.queryList(new HashMap<String, Object>());
        } else {
            menuList = sysMenuService.queryUserList(getUserId());
        }

        return setSuccessResponsep(menuList);
    }

    /**
     * 菜单信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public ResponseEntity info(@PathVariable("menuId") Long menuId) {
        SysMenu menu = sysMenuService.queryObject(menuId);
        return setSuccessResponsep(menu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:menu:save")
    public ResponseEntity save(@RequestBody SysMenu menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.save(menu);

        return setSuccessResponsep();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:menu:update")
    public ResponseEntity update(@RequestBody SysMenu menu) {
        //数据校验
        verifyForm(menu);

        sysMenuService.update(menu);

        return setSuccessResponsep();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public ResponseEntity delete(@RequestBody Long[] menuIds) {
        for (Long menuId : menuIds) {
            if (menuId.longValue() <= 30) {
                return setFailResponse("系统菜单，不能删除");
            }
        }
        sysMenuService.deleteBatch(menuIds);

        return setSuccessResponsep();
    }

    /**
     * 用户菜单列表
     */
    @RequestMapping("/user")
    public ResponseEntity user() {
        List<Tree<SysMenu>> menuList = sysMenuService.getUserMenuList(getUserId());

        return setSuccessResponsep(menuList);
    }

    /**
     * 验证参数是否正确
     */
    private void verifyForm(SysMenu menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new InputParamException("菜单名称不能为空");
        }

        if (menu.getParentId() == null) {
            throw new InputParamException("上级菜单不能为空");
        }

        //菜单
        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new InputParamException("菜单URL不能为空");
            }
        }

        //上级菜单类型
        int parentType = Constant.MenuType.CATALOG.getValue();
        if (menu.getParentId() != 0) {
            SysMenu parentMenu = sysMenuService.queryObject(menu.getParentId());
            parentType = parentMenu.getType();
        }

        //目录、菜单
        if (menu.getType() == Constant.MenuType.CATALOG.getValue() ||
                menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (parentType != Constant.MenuType.CATALOG.getValue()) {
                throw new InputParamException("上级菜单只能为目录类型");
            }
            return;
        }

        //按钮
        if (menu.getType() == Constant.MenuType.BUTTON.getValue()) {
            if (parentType != Constant.MenuType.MENU.getValue()) {
                throw new InputParamException("上级菜单只能为菜单类型");
            }
            return;
        }
    }
}
