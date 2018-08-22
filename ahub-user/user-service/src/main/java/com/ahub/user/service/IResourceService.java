package com.ahub.user.service;

import java.util.List;

import com.ahub.common.model.ShiroUser;
import com.ahub.common.model.Tree;
import com.ahub.user.model.ResourceDO;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface IResourceService extends IService<ResourceDO>{

    /**
     * 更新记录
     * @param resourceDO
     * @return
     */
    int update(ResourceDO resourceDO);

    List<ResourceDO> selectAll();

    List<Tree> selectAllMenu();

    List<Tree> selectAllTree();

    List<Tree> selectTree(ShiroUser shiroUser);
}
