package com.ahub.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ahub.common.model.ShiroUser;
import com.ahub.common.model.Tree;
import com.ahub.user.mapper.ResourceMapper;
import com.ahub.user.mapper.RoleMapper;
import com.ahub.user.mapper.UserRoleMapper;
import com.ahub.user.model.ResourceDO;
import com.ahub.user.service.ResourceService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{

    // 菜单
    private static final int RESOURCE_MENU = 0;

    @Autowired
    ResourceMapper resourceMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int insert(ResourceDO resourceDO) {
        return resourceMapper.insert(resourceDO);
    }

    @Override
    public int update(ResourceDO resourceDO) {
        return resourceMapper.update(resourceDO);
    }

    @Override
    public int delete(Long id) {
        return resourceMapper.deleteById(id);
    }

    @Override
    public ResourceDO selectById(Long id) {
        return resourceMapper.selectById(id);
    }

    @Override
    public List<ResourceDO> selectAll() {
        EntityWrapper<ResourceDO> wrapper = new EntityWrapper<ResourceDO>();
        wrapper.orderBy("seq");
        return resourceMapper.selectList(wrapper);
    }

    public List<ResourceDO> selectByType(Integer type) {
        EntityWrapper<ResourceDO> wrapper = new EntityWrapper<ResourceDO>();
        ResourceDO resource = new ResourceDO();
        wrapper.setEntity(resource);
        wrapper.addFilter("resource_type = {0}", type);
        wrapper.orderBy("seq");
        return resourceMapper.selectList(wrapper);
    }

    @Override
    public List<Tree> selectAllMenu() {
        List<Tree> trees = new ArrayList<Tree>();
        // 查询所有菜单
        List<ResourceDO> resources = this.selectByType(RESOURCE_MENU);
        if (resources == null) {
            return trees;
        }
        for (ResourceDO resource : resources) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getParentId());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            trees.add(tree);
        }
        return trees;
    }

    @Override
    public List<Tree> selectAllTree() {
        // 获取所有的资源 tree形式，展示
        List<Tree> trees = new ArrayList<Tree>();
        List<ResourceDO> resources = this.selectAll();
        if (resources == null) {
            return trees;
        }
        for (ResourceDO resource : resources) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getParentId());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            trees.add(tree);
        }
        return trees;
    }

    @Override
    public List<Tree> selectTree(ShiroUser shiroUser) {
        List<Tree> trees = new ArrayList<Tree>();
        // shiro中缓存的用户角色
        Set<String> roles = shiroUser.getRoles();
        if (roles == null) {
            return trees;
        }
        // 如果有超级管理员权限
        if (roles.contains("admin")) {
            List<ResourceDO> resourceList = this.selectByType(RESOURCE_MENU);
            if (resourceList == null) {
                return trees;
            }
            for (ResourceDO resource : resourceList) {
                Tree tree = new Tree();
                tree.setId(resource.getId());
                tree.setPid(resource.getParentId());
                tree.setText(resource.getName());
                tree.setIconCls(resource.getIcon());
                tree.setAttributes(resource.getUrl());
                tree.setOpenMode(resource.getOpenMode());
                trees.add(tree);
            }
            return trees;
        }
        // 普通用户
        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(shiroUser.getId());
        if (roleIdList == null) {
            return trees;
        }
        List<ResourceDO> resourceLists = resourceMapper.selectResourceListByRoleIdList(roleIdList);
        if (resourceLists == null) {
            return trees;
        }
        for (ResourceDO resource : resourceLists) {
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getParentId());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setOpenMode(resource.getOpenMode());
            trees.add(tree);
        }
        return trees;
    }
}
