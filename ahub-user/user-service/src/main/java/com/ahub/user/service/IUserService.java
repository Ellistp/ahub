package com.ahub.user.service;

import com.ahub.user.model.UserDO;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface IUserService extends IService<UserDO>{

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
