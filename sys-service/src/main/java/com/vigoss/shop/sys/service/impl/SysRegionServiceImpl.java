package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.sys.dao.mapper.SysRegionMapper;
import com.vigoss.shop.sys.entity.SysRegion;
import com.vigoss.shop.sys.service.SysRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
@Service
public class SysRegionServiceImpl implements SysRegionService {
    @Autowired
    private SysRegionMapper sysRegionDao;

    @Override
    public SysRegion queryObject(Integer id) {
        return sysRegionDao.selectByPrimaryKey(id);
    }

    @Override
    public List<SysRegion> queryList(Map<String, Object> map) {
        return sysRegionDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysRegionDao.queryTotal(map);
    }

    @Override
    public int save(SysRegion region) {
        return sysRegionDao.insert(region);
    }

    @Override
    public int update(SysRegion region) {
        return sysRegionDao.updateByPrimaryKey(region);
    }

    @Override
    public int delete(Integer id) {
        return sysRegionDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return sysRegionDao.deleteBatch(ids);
    }
}
