package com.vigoss.shop.management.api.controller;


import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.common.validator.ValidatorUtils;
import com.vigoss.shop.sys.entity.SysConfig;
import com.vigoss.shop.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
@RestController
@RequestMapping("${api.prefix}/config")
public class SysConfigController extends BaseController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 所有配置列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<SysConfig> configList = sysConfigService.queryList(query);
        int total = sysConfigService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(configList, total, query.getLimit(), query.getPage());

        return setSuccessResponsep(pageUtil);
    }


    /**
     * 配置信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public ResponseEntity info(@PathVariable("id") Long id) {
        SysConfig config = sysConfigService.queryObject(id);

        return setSuccessResponsep(config);
    }

    /**
     * 保存配置
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public ResponseEntity save(@RequestBody SysConfig config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.save(config);

        return setSuccessResponsep();
    }

    /**
     * 修改配置
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public ResponseEntity update(@RequestBody SysConfig config) {
        ValidatorUtils.validateEntity(config);

        sysConfigService.update(config);

        return setSuccessResponsep();
    }

    /**
     * 删除配置
     */
        @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public ResponseEntity delete(@RequestBody Long[] ids) {
        sysConfigService.deleteBatch(ids);

        return setSuccessResponsep();
    }

}
