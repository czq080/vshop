package com.vigoss.shop.sys.service;

import com.vigoss.shop.sys.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 * @author liepngjun
 * @email 951449465@qq.com
 * @date 2017-09-17 23:58:47
 */
public interface SysDeptService {

    SysDept queryObject(Long deptId);

    List<SysDept> queryList(Map<String, Object> map);

    void save(SysDept sysDept);

    void update(SysDept sysDept);

    void delete(Long deptId);

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

    /**
     * 获取子部门ID(包含本部门ID)，用于数据过滤
     */
    String getSubDeptIdList(Long deptId);

    /**
     * 分页查询组织审批选择范围
     * @return
     */
//    Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum);
}
