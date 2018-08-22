package com.ahub.user.service;

import java.util.List;

import com.ahub.common.model.Tree;
import com.ahub.user.model.OrganizationDO;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface IOrganizationService extends IService<OrganizationDO>{

    /**
     * 更新记录
     * @param organizationDO
     * @return
     */
    int update(OrganizationDO organizationDO);

    List<Tree> selectTree();

    List<OrganizationDO> selectTreeGrid();
}
