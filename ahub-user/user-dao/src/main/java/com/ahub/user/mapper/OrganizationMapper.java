package com.ahub.user.mapper;

import com.ahub.user.model.OrganizationDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface OrganizationMapper extends BaseMapper<OrganizationDO>{

    /**
     * 更新记录
     * @param organizationDO
     * @return
     */
    int update(OrganizationDO organizationDO);
}
