package com.ahub.user;

import com.ahub.common.junit.BaseSpringJunitTest;
import com.ahub.user.mapper.UserMapper;
import com.ahub.user.model.UserDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:jdbc/common-jdbc.xml"})
public class UserTest extends BaseSpringJunitTest {

    @Autowired
    UserMapper userMapper;

    private Long userId = null;

    @Before
    public void insert(){
        UserDO userDO = new UserDO();
        userDO.setAccount("程天平");
        this.userMapper.insert(userDO);
        userId = userDO.getId();
    }

    @Test
    public void testSelectById(){
        UserDO userDO = this.userMapper.selectById(userId);
        Assert.assertNotNull(userDO);
    }
}
