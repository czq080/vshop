package com.vigoss.shop.management.api.controller;


import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.sys.entity.SysMacro;
import com.vigoss.shop.sys.service.SysMacroService;
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
@RequestMapping("${api.prefix}/macro")
public class SysMacroController extends BaseController {
    @Autowired
    private SysMacroService sysMacroService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:macro:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysMacro> sysMacroList = sysMacroService.queryList(query);
        int total = sysMacroService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(sysMacroList, total, query.getLimit(), query.getPage());

        return setSuccessResponsep(pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{macroId}")
    @RequiresPermissions("sys:macro:info")
    public ResponseEntity info(@PathVariable("macroId") Long macroId) {
        SysMacro sysMacro = sysMacroService.queryObject(macroId);

        return setSuccessResponsep(sysMacro);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:macro:save")
    public ResponseEntity save(@RequestBody SysMacro sysMacro) {
        sysMacroService.save(sysMacro);

        return setSuccessResponsep();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:macro:update")
    public ResponseEntity update(@RequestBody SysMacro sysMacro) {
        sysMacroService.update(sysMacro);

        return setSuccessResponsep();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:macro:delete")
    public ResponseEntity delete(@RequestBody Long[] macroIds) {
        sysMacroService.deleteBatch(macroIds);

        return setSuccessResponsep();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    public ResponseEntity queryAll(@RequestParam Map<String, Object> params) {

        List<SysMacro> list = sysMacroService.queryList(params);

        return setSuccessResponsep(list);
    }

    /**
     * 查询数据字典
     *
     * @param value
     * @return
     */
    @RequestMapping("/queryMacrosByValue")
    public ResponseEntity queryMacrosByValue(@RequestParam String value) {

        List<SysMacro> list = sysMacroService.queryMacrosByValue(value);

        return setSuccessResponsep(list);
    }
}
