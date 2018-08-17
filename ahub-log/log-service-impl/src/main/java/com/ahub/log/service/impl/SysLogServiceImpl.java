package com.ahub.log.service.impl;

import java.util.List;

import com.ahub.common.utils.PageInfo;
import com.ahub.log.mapper.SysLogMapper;
import com.ahub.log.model.SysLogDO;
import com.ahub.log.service.SysLogService;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Service
public class SysLogServiceImpl implements SysLogService{

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public int insert(SysLogDO logDO) {
        return sysLogMapper.insert(logDO);
    }

    @Override
    public int update(SysLogDO logDO) {
        return sysLogMapper.update(logDO);
    }

    @Override
    public int delete(Long id) {
        return sysLogMapper.deleteById(id);
    }

    @Override
    public SysLogDO selectById(Long id) {
        return sysLogMapper.selectById(id);
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<SysLogDO> page = new Page<SysLogDO>(pageInfo.getNowpage(), pageInfo.getSize());
        List<SysLogDO> list = sysLogMapper.selectSysLogList(page);
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }
}
