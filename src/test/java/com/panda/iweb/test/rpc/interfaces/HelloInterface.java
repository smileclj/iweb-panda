package com.panda.iweb.test.rpc.interfaces;

import com.panda.iweb.test.rpc.dto.HelloSayDto;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public interface HelloInterface {
    String say(HelloSayDto dto);
}
