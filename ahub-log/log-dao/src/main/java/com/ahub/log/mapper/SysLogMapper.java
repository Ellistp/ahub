package com.ahub.log.mapper;

import java.util.List;

import com.ahub.log.model.SysLogDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface SysLogMapper extends BaseMapper<SysLogDO>{

    /**
     * 更新记录
     * @param logDO
     * @return
     */
   int update(SysLogDO logDO);

    List<SysLogDO> selectSysLogList(Pagination page);
}
