package com.ahub.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ahub.common.model.Tree;
import com.ahub.common.utils.PageInfo;
import com.ahub.user.mapper.RoleMapper;
import com.ahub.user.mapper.RoleResourceMapper;
import com.ahub.user.mapper.UserRoleMapper;
import com.ahub.user.model.RoleDO;
import com.ahub.user.model.RoleResourceDO;
import com.ahub.user.service.RoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleResourceMapper roleResourceMapper;

    @Override
    public int insert(RoleDO roleDO) {
        return roleMapper.insert(roleDO);
    }

    @Override
    public int update(RoleDO roleDO) {
        return roleMapper.update(roleDO);
    }

    @Override
    public int delete(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public RoleDO selectById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<RoleDO> page = new Page<RoleDO>(pageInfo.getNowpage(), pageInfo.getSize());
        List<RoleDO> list = roleMapper.selectRoleList(page, pageInfo.getSort(), pageInfo.getOrder());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String, Set<String>> resourceMap = new HashMap<String, Set<String>>();
        List<Long> roleIdList = userRoleMapper.listRoleIds(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIdList) {
            List<Map<Long, String>> resourceList = roleMapper.selectResourceListByRoleId(roleId);
            if (resourceList != null) {
                for (Map<Long, String> map : resourceList) {
                    if (StringUtils.isNotBlank(map.get("url"))) {
                        urlSet.add(map.get("url"));
                    }
                }
            }
            RoleDO role = roleMapper.selectById(roleId);
            if (role != null) {
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls", urlSet);
        resourceMap.put("roles", roles);
        return resourceMap;
    }

    @Override
    public List<Long> selectResourceIdListByRoleId(Long id) {
        return roleMapper.selectResourceIdListByRoleId(id);
    }

    @Override
    public void updateRoleResource(Long id, String resourceIds) {
        // 先删除后添加,有点爆力
        RoleResourceDO roleResource = new RoleResourceDO();
        roleResource.setRoleId(id);
        roleResourceMapper.delete(new EntityWrapper<RoleResourceDO>(roleResource));

        String[] resourceIdArray = resourceIds.split(",");
        for (String resourceId : resourceIdArray) {
            roleResource = new RoleResourceDO();
            roleResource.setRoleId(id);
            roleResource.setResourceId(Long.parseLong(resourceId));
            roleResourceMapper.insert(roleResource);
        }
    }

    @Override
    public Object selectTree() {
        List<Tree> trees = new ArrayList<Tree>();
        List<RoleDO> roles = this.selectAll();
        for (RoleDO role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getId());
            tree.setText(role.getName());

            trees.add(tree);
        }
        return trees;
    }

    public List<RoleDO> selectAll() {
        EntityWrapper<RoleDO> wrapper = new EntityWrapper<RoleDO>();
        wrapper.orderBy("seq");
        return roleMapper.selectList(wrapper);
    }
}
