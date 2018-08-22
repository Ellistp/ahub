package com.ahub.user.service.impl;

import javax.annotation.Resource;

import com.ahub.user.mapper.UserMapper;
import com.ahub.user.model.UserDO;
import com.ahub.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/17
 */
@Service("iUserService")
public class IUserServiceImpl extends ServiceImpl<UserMapper,UserDO>  implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int update(UserDO userDO) {
        return userMapper.update(userDO);
    }

    @Override
    public UserDO selectByAccount(String account) {
        return userMapper.selectByAccount(account);
    }
}
