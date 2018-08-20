package com.ahub.user;

import java.util.Date;

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
        userDO.setAge(12);
        userDO.setGmtCreate(new Date());
        userDO.setGmtModified(new Date());
        userDO.setName("chengtianping");
        userDO.setOrganizationId(6L);
        userDO.setPassword("test");
        userDO.setPhone("13732252967");
        userDO.setSalt("fdfdf");
        userDO.setSex(1);
        userDO.setStatus(1);
        userDO.setUserType(1);
        this.userMapper.insert(userDO);
        userId = userDO.getId();
    }

    @Test
    public void testSelectById(){
        UserDO userDO = this.userMapper.selectById(userId);
        Assert.assertNotNull(userDO);
    }

    @Test
    public void testSelectByAccount(){
        UserDO userDO = this.userMapper.selectByAccount("test");
        Assert.assertNotNull(userDO);
    }
}
