package com.ahub.user.mapper;

import java.util.List;

import com.ahub.user.model.UserRoleDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface UserRoleMapper extends BaseMapper<UserRoleDO>{

    List<Long> listRoleIds(Long userId);
}
