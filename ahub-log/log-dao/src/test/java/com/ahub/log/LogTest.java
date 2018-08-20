package com.ahub.log;

import com.ahub.common.junit.BaseSpringJunitTest;
import com.ahub.log.mapper.SysLogMapper;
import com.ahub.log.model.SysLogDO;
import org.junit.Assert;
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
public class LogTest extends BaseSpringJunitTest {

    @Autowired
    SysLogMapper sysLogMapper;

    @Test
    public void testSelectById(){
        SysLogDO sysLogDO = this.sysLogMapper.selectById(1L);
        Assert.assertNotNull(sysLogDO);
    }

}
