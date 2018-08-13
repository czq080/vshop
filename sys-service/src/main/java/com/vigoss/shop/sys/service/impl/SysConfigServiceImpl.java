package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.sys.dao.mapper.SysConfigMapper;
import com.vigoss.shop.sys.entity.SysConfig;
import com.vigoss.shop.sys.service.SysConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysConfigServiceImpl implements SysConfigService {
    @Autowired
    private SysConfigMapper sysConfigDao;

    @Override
    public void save(SysConfig config) {
        sysConfigDao.insert(config);
    }

    @Override
    public void update(SysConfig config) {
        sysConfigDao.updateByPrimaryKey(config);
    }

    @Override
    public void updateValueByKey(String key, String value) {
        sysConfigDao.updateValueByKey(key, value);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        sysConfigDao.deleteBatch(ids);
    }

    @Override
    public List<SysConfig> queryList(Map<String, Object> map) {
        return sysConfigDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysConfigDao.queryTotal(map);
    }

    @Override
    public SysConfig queryObject(Long id) {
        return sysConfigDao.selectByPrimaryKey(id);
    }

    @Override
    public String getValue(String key, String defaultValue) {
        String value = sysConfigDao.queryByKey(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return value;
    }
}
