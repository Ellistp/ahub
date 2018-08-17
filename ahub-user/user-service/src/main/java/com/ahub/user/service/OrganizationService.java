package com.ahub.user.service;

import com.ahub.user.model.ResourceDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface OrganizationService {

    /**
     * 添加记录
     * @param resourceDO
     * @return
     */
    int insert(ResourceDO resourceDO);

    /**
     * 更新记录
     * @param resourceDO
     * @return
     */
    int update(ResourceDO resourceDO);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(Long id);
}
