package com.ahub.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ahub.common.model.Tree;
import com.ahub.user.mapper.OrganizationMapper;
import com.ahub.user.model.OrganizationDO;
import com.ahub.user.service.IOrganizationService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/20
 */
@Service("iOrganizationService")
public class IOrganizationServiceImpl extends ServiceImpl<OrganizationMapper,OrganizationDO> implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public int update(OrganizationDO organizationDO) {
        return organizationMapper.update(organizationDO);
    }

    @Override
    public List<Tree> selectTree() {
        List<OrganizationDO> organizationList = selectTreeGrid();

        List<Tree> trees = new ArrayList<Tree>();
        if (organizationList != null) {
            for (OrganizationDO organization : organizationList) {
                Tree tree = new Tree();
                tree.setId(organization.getId());
                tree.setText(organization.getName());
                tree.setIconCls(organization.getIcon());
                tree.setPid(organization.getParentId());
                trees.add(tree);
            }
        }
        return trees;
    }

    @Override
    public List<OrganizationDO> selectTreeGrid() {
        EntityWrapper<OrganizationDO> wrapper = new EntityWrapper<OrganizationDO>();
        wrapper.orderBy("seq");
        return organizationMapper.selectList(wrapper);
    }
}
