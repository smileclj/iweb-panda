package com.panda.iweb.test.rpc.interfaces.impl;

import com.panda.iweb.test.rpc.dto.HelloSayDto;
import com.panda.iweb.test.rpc.interfaces.HelloInterface;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class HelloInterfaceImpl implements HelloInterface {
    @Override
    public String say(HelloSayDto dto) {
        return "{id:" + dto.getId() + ",name:" + dto.getName() + "}";
    }
}
