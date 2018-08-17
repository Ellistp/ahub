package com.ahub.user.service.impl;

import javax.annotation.Resource;

import com.ahub.user.mapper.UserMapper;
import com.ahub.user.model.UserDO;
import com.ahub.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public int insert(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public int update(UserDO userDO) {
        return userMapper.update(userDO);
    }

    @Override
    public int delete(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public UserDO selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserDO selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
