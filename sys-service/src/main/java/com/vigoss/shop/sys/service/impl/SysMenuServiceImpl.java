package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.sys.dao.mapper.SysMenuMapper;
import com.vigoss.shop.sys.dto.Tree;
import com.vigoss.shop.sys.entity.SysMenu;
import com.vigoss.shop.sys.service.SysMenuService;
import com.vigoss.shop.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuDao;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenu> menuList = sysMenuDao.queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<SysMenu>();
        for (SysMenu menu : menuList) {
            if (menuIdList.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    @Override
    public List<SysMenu> queryNotButtonList() {
        return sysMenuDao.queryNotButtonList();
    }

    @Override
    public List<Tree<SysMenu>> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            return buildByRecursive(getMenus(null));
        }

        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return buildByRecursive(getMenus(menuIdList));
    }

    private List<SysMenu> getMenus(List<Long> allowMenus) {
        List<SysMenu> sysMenus = sysMenuDao.queryMenuList(0L);
        if (allowMenus == null)
            return sysMenus;
        List<SysMenu> userMenuList = new ArrayList<SysMenu>();
        for (SysMenu menu : sysMenus) {
            if (allowMenus.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    private List<Tree<SysMenu>> buildByRecursive(List<SysMenu> treeNodes) {
        List<Tree<SysMenu>> trees = new ArrayList<Tree<SysMenu>>();
        for (SysMenu treeNode : treeNodes) {
            if (treeNode.getParentId() == 0L) {
                trees.add(findChildren(new Tree<SysMenu>(treeNode), treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private Tree<SysMenu> findChildren(Tree<SysMenu> treeNode, List<SysMenu> treeNodes) {
        for (SysMenu it : treeNodes) {
            if (treeNode.getTarget().getMenuId().equals(it.getParentId())) {
                if (treeNode.getList() == null) {
                    treeNode.setList(new ArrayList<Tree<SysMenu>>());
                }
                treeNode.getList().add(findChildren(new Tree<SysMenu>(it), treeNodes));
            }
        }
        return treeNode;
    }


    @Override
    public SysMenu queryObject(Long menuId) {
        return sysMenuDao.selectByPrimaryKey(menuId);
    }

    @Override
    public List<SysMenu> queryList(Map<String, Object> map) {
        return sysMenuDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysMenuDao.queryTotal(map);
    }

    @Override
    public void save(SysMenu menu) {
        sysMenuDao.insert(menu);
    }

    @Override
    public void update(SysMenu menu) {
        sysMenuDao.updateByPrimaryKey(menu);
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] menuIds) {
        sysMenuDao.deleteBatch(menuIds);
    }

    @Override
    public List<SysMenu> queryUserList(Long userId) {
        return sysMenuDao.queryUserList(userId);
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenu> getAllMenuList(List<Long> menuIdList) {
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Long> menuIdList) {
        List<SysMenu> subMenuList = new ArrayList<SysMenu>();

//		for(SysMenu entity : menuList){
//			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){//目录
//				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
//			}
//			subMenuList.add(entity);
//		}

        return subMenuList;
    }
}
