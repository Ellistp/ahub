package com.ahub.user.service;

import java.util.List;

import com.ahub.common.model.ShiroUser;
import com.ahub.common.model.Tree;
import com.ahub.user.model.ResourceDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface ResourceService {

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

    /**
     * 查询记录
     * @param id
     * @return
     */
    ResourceDO selectById(Long id);

    List<ResourceDO> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);
}
