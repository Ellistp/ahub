package com.ahub.user.mapper;

import java.util.List;
import java.util.Map;

import com.ahub.user.model.RoleDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface RoleMapper extends BaseMapper<RoleDO>{

    /**
     * 更新记录
     * @param roleDO
     * @return
     */
    int update(RoleDO roleDO);

    List<Map<Long, String>> selectResourceListByRoleId(@Param("id") Long id);

    List<Long> selectResourceIdListByRoleId(@Param("id") Long id);

    List<RoleDO> selectRoleList(Pagination page, @Param("sort") String sort, @Param("order") String order);
}
