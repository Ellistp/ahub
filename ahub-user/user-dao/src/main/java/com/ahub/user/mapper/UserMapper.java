package com.ahub.user.mapper;

import com.ahub.user.model.UserDO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface UserMapper extends BaseMapper<UserDO>{

    /**
     * 更新记录
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 根据账户名和密码查询用户信息
     * @param account
     * @return
     */
    UserDO selectByAccount(String account);

}
