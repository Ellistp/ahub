package com.ahub.user.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ahub.common.utils.PageInfo;
import com.ahub.user.model.RoleDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface RoleService {

    /**
     * 添加记录
     * @param roleDO
     * @return
     */
    int insert(RoleDO roleDO);

    /**
     * 更新记录
     * @param roleDO
     * @return
     */
    int update(RoleDO roleDO);

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
    RoleDO selectById(Long id);

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    Map<String, Set<String>> selectResourceMapByUserId(Long userId);

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id, String resourceIds);
}
