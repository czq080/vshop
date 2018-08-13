package com.vigoss.shop.management.api.controller;


import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.sys.entity.SysRegion;
import com.vigoss.shop.sys.service.SysRegionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Controller
 *
 * @author zscat
 * @email 951449465@qq.com
 * @date 2017-11-04 11:19:31
 */
@RestController
@RequestMapping("${api.prefix}/region")
public class SysRegionController extends BaseController {
    @Autowired
    private SysRegionService sysRegionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:region:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysRegion> regionList = sysRegionService.queryList(query);
        int total = sysRegionService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(regionList, total, query.getLimit(), query.getPage());

        return setSuccessResponsep(pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:region:info")
    public ResponseEntity info(@PathVariable("id") Integer id) {
        SysRegion region = sysRegionService.queryObject(id);

        return setSuccessResponsep(region);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:region:save")
    public ResponseEntity save(@RequestBody SysRegion region) {
        sysRegionService.save(region);

        return setSuccessResponsep();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:region:update")
    public ResponseEntity update(@RequestBody SysRegion region) {
        sysRegionService.update(region);

        return setSuccessResponsep();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:region:delete")
    public ResponseEntity delete(@RequestBody Integer[] ids) {
        sysRegionService.deleteBatch(ids);

        return setSuccessResponsep();
    }

    /**
     * 查询所有国家
     *
     * @return
     */
    @RequestMapping("/getAllCountry")
    public ResponseEntity getAllCountry() {
        Predicate<SysRegion> allCountry = x -> x.getType() == 0;
        List<SysRegion> sysRegions = sysRegionService.queryList(new HashMap<>()).stream().filter(allCountry).collect(Collectors.toList());
        return setSuccessResponsep(sysRegions);
    }

    /**
     * 查询所有省份
     *
     * @return
     */
    @RequestMapping("/getAllProvice")
    public ResponseEntity getAllProvice(@RequestParam(required = false) Integer areaId) {
        Predicate<SysRegion> allProvince = x -> null != x.getParentId() && x.getType() == 1 && x.getParentId().equals(areaId);
        List<SysRegion> sysRegions = sysRegionService.queryList(new HashMap<>()).stream().filter(allProvince).collect(Collectors.toList());
        return setSuccessResponsep(sysRegions);
    }

    /**
     * 查询所有城市
     *
     * @return
     */
    @RequestMapping("/getAllCity")
    public ResponseEntity getAllCity(@RequestParam(required = false) Integer areaId) {
        Predicate<SysRegion> allCity = x -> null != x.getParentId() && x.getType() == 2 && x.getParentId().equals(areaId);
        List<SysRegion> sysRegions = sysRegionService.queryList(new HashMap<>()).stream().filter(allCity).collect(Collectors.toList());
        return setSuccessResponsep(sysRegions);
    }


    /**
     * 查询所有区县
     *
     * @return
     */
    @RequestMapping("/getChildrenDistrict")
    public ResponseEntity getChildrenDistrict(@RequestParam(required = false) Integer areaId) {
        Predicate<SysRegion> allChildrenDistrict = x -> null != x.getParentId() && x.getType() == 3 && x.getParentId().equals(areaId);
        List<SysRegion> sysRegions = sysRegionService.queryList(new HashMap<>()).stream().filter(allChildrenDistrict).collect(Collectors.toList());
        return setSuccessResponsep(sysRegions);
    }

//    /**
//     * 查看信息(全部加载页面渲染太慢！)
//     */
//    @RequestMapping("/getAreaTree")
//    public ResponseEntity getAreaTree() {
//        List<SysRegion> list = sysRegionService.queryList(new HashMap<>());
//        List<Tree<SysRegion>> trees = new ArrayList<Tree<SysRegion>>();
//        for (SysRegion sysRegion : list) {
//            Tree<SysRegion> tree = new Tree<SysRegion>(sysRegion);
//            tree.setValue(sysRegion.getId() + "");
//            tree.setLabel(sysRegion.getName());
//        }
//        List<SysRegionEntity> node = TreeUtils.factorTree(list);
//
//        return R.ok().put("node", node);
//    }

    @RequestMapping("/getAreaByType")
    public ResponseEntity getAreaByType(@RequestParam(required = false) Integer type) {

        List<SysRegion> list = new ArrayList<>();
        if (type.equals(0)) {

        } else if (type.equals(1)) {//省份
            Predicate<SysRegion> allCountry = x -> x.getType() == 0;
            list = sysRegionService.queryList(new HashMap<>()).stream().filter(allCountry).collect(Collectors.toList());
        } else if (type.equals(2)) {
            Predicate<SysRegion> allCountry = x -> x.getType() == 1;
            list = sysRegionService.queryList(new HashMap<>()).stream().filter(allCountry).collect(Collectors.toList());
        } else if (type.equals(3)) {
            Predicate<SysRegion> allCountry = x -> x.getType() == 2;
            list = sysRegionService.queryList(new HashMap<>()).stream().filter(allCountry).collect(Collectors.toList());
        }
        return setSuccessResponsep(list);
    }
}
