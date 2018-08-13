package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.sys.dao.mapper.SysMacroMapper;
import com.vigoss.shop.sys.entity.SysMacro;
import com.vigoss.shop.sys.service.SysMacroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:51 2018/5/26
 * @Modified By:
 */
@Service
public class SysMacroServiceImpl implements SysMacroService {
    @Autowired
    private SysMacroMapper sysMacroDao;

    @Override
    public SysMacro queryObject(Long macroId) {
        return sysMacroDao.selectByPrimaryKey(macroId);
    }

    @Override
    public List<SysMacro> queryList(Map<String, Object> map) {
        return sysMacroDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysMacroDao.queryTotal(map);
    }

    @Override
    public int save(SysMacro sysMacro) {
        sysMacro.setGmtCreate(new Date());
        return sysMacroDao.insert(sysMacro);
    }

    @Override
    public int update(SysMacro sysMacro) {
        sysMacro.setGmtModified(new Date());
        return sysMacroDao.insert(sysMacro);
    }

    @Override
    public int delete(Long macroId) {
        return sysMacroDao.deleteByPrimaryKey(macroId);
    }

    @Override
    public int deleteBatch(Long[] macroIds) {
        return sysMacroDao.deleteBatch(macroIds);
    }

    @Override
    public List<SysMacro> queryMacrosByValue(String value) {
        return sysMacroDao.queryMacrosByValue(value);
    }
}
