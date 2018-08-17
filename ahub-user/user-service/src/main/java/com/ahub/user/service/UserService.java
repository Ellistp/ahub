package com.ahub.user.service;

import com.ahub.user.model.UserDO;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
public interface UserService {

    /**
     * 添加记录
     * @param userDO
     * @return
     */
    int insert(UserDO userDO);

    /**
     * 更新记录
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

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
    UserDO selectById(Long id);

    /**
     * 根据账户名和密码查询用户信息
     * @param account
     * @return
     */
    UserDO selectByAccount(String account);
}
