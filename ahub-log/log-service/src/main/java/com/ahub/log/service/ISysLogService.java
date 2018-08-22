package com.ahub.log.service;

import com.ahub.common.utils.PageInfo;
import com.ahub.log.model.SysLogDO;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface ISysLogService extends IService<SysLogDO>{

    /**
     * 更新记录
     * @param logDO
     * @return
     */
    int update(SysLogDO logDO);

    void selectDataGrid(PageInfo pageInfo);
}
