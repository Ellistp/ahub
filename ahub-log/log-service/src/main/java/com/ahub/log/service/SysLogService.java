package com.ahub.log.service;

import com.ahub.common.utils.PageInfo;
import com.ahub.log.model.SysLogDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface SysLogService {

    /**
     * 添加记录
     * @param logDO
     * @return
     */
    int insert(SysLogDO logDO);

    /**
     * 更新记录
     * @param logDO
     * @return
     */
    int update(SysLogDO logDO);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询记录
     * @param id
     * @return
     */
    SysLogDO selectById(Long id);

    void selectDataGrid(PageInfo pageInfo);
}
