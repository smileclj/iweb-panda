package com.iweb.panda.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iweb.panda.entity.UserDo;
import com.iweb.panda.mapper.UserDoMapper;
import com.iweb.panda.mapper.UserDoMapperExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDao {

    @Resource
    private UserDoMapperExt userDoMappperExt;
    @Resource
    private UserDoMapper    userDoMapper;

    @Test
    public void testUserDoMapper() {
        // System.out.println(userDoMappperExt.selectByPrimaryKey(297901).getNickname());
        // System.out.println(userDoMapper.selectByPrimaryKey(297901).getNickname());

        UserDo user = new UserDo();
        user.setNickname("陈1");
        userDoMappperExt.insertSelective(user);

    }
}
