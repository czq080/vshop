package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.sys.dao.mapper.SysDeptMapper;
import com.vigoss.shop.sys.entity.SysDept;
import com.vigoss.shop.sys.service.SysDeptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysDeptServiceImpl implements SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptDao;

    @Override
    public SysDept queryObject(Long deptId) {
        return sysDeptDao.selectByPrimaryKey(deptId);
    }

    @Override
    public List<SysDept> queryList(Map<String, Object> map) {
        return sysDeptDao.queryList(map);
    }

    @Override
    public void save(SysDept sysDept) {
        sysDeptDao.insert(sysDept);
    }

    @Override
    public void update(SysDept sysDept) {
        sysDeptDao.updateByPrimaryKey(sysDept);
    }

    @Override
    public void delete(Long deptId) {
        sysDeptDao.deleteWithFlag(deptId);
    }

    @Override
    public List<Long> queryDetpIdList(Long parentId) {
        return sysDeptDao.queryDetpIdList(parentId);
    }

    @Override
    public String getSubDeptIdList(Long deptId) {
        //部门及子部门ID列表
        List<Long> deptIdList = new ArrayList<Long>();

        //获取子部门ID
        List<Long> subIdList = queryDetpIdList(deptId);
        getDeptTreeList(subIdList, deptIdList);

        //添加本部门
        deptIdList.add(deptId);

        String deptFilter = StringUtils.join(deptIdList, ",");
        return deptFilter;
    }

    /**
     * 递归
     */
    public void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        for (Long deptId : subIdList) {
            List<Long> list = queryDetpIdList(deptId);
            if (list.size() > 0) {
                getDeptTreeList(list, deptIdList);
            }

            deptIdList.add(deptId);
        }
    }

//    @Override
//    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
//        PageHelper.startPage(pageNum, Constant.pageSize);
//        sysDeptDao.queryPageByDto(userWindowDto);
//        return PageHelper.endPage();
//    }
}
