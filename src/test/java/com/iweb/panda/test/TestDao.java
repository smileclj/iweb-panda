package com.iweb.panda.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iweb.panda.entity.UserDo;
import com.iweb.panda.mapper.UserDoMapperExt;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDao {

    @Resource
    private UserDoMapperExt userDoMappperExt;

    @Test
    public void testUserDoMapper() {
        UserDo user = new UserDo();
        user.setNickname("陈1");
        userDoMappperExt.insertSelective(user);

    }
}
