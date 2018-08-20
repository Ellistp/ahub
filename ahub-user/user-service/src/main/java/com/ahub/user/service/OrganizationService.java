package com.ahub.user.service;

import java.util.List;

import com.ahub.common.model.Tree;
import com.ahub.user.model.OrganizationDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface OrganizationService {

    /**
     * 添加记录
     * @param organizationDO
     * @return
     */
    int insert(OrganizationDO organizationDO);

    /**
     * 更新记录
     * @param organizationDO
     * @return
     */
    int update(OrganizationDO organizationDO);

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
    OrganizationDO selectById(Long id);

    List<Tree> selectTree();

    List<OrganizationDO> selectTreeGrid();
}
