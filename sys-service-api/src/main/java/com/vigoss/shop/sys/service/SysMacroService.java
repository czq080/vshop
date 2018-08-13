package com.vigoss.shop.sys.service;

import com.vigoss.shop.sys.entity.SysMacro;

import java.util.List;
import java.util.Map;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
public interface SysMacroService {

    /**
     * 根据主键查询实体
     *
     * @param macroId 主键
     * @return 实体
     */
    SysMacro queryObject(Long macroId);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<SysMacro> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param sysMacro 实体
     * @return 保存条数
     */
    int save(SysMacro sysMacro);

    /**
     * 根据主键更新实体
     *
     * @param sysMacro 实体
     * @return 更新条数
     */
    int update(SysMacro sysMacro);

    /**
     * 根据主键删除
     *
     * @param macroId
     * @return 删除条数
     */
    int delete(Long macroId);

    /**
     * 根据主键批量删除
     *
     * @param macroIds
     * @return 删除条数
     */
    int deleteBatch(Long[] macroIds);

    List<SysMacro> queryMacrosByValue(String value);
}
