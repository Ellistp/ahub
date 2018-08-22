package com.ahub.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ahub.common.utils.PageInfo;
import com.ahub.user.model.RoleDO;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface IRoleService extends IService<RoleDO>{

    /**
     * 更新记录
     * @param roleDO
     * @return
     */
    int update(RoleDO roleDO);

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);
}
