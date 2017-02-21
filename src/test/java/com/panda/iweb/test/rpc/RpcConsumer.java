package com.panda.iweb.test.rpc;

import com.panda.iweb.test.rpc.dto.HelloSayDto;
import com.panda.iweb.test.rpc.interfaces.HelloInterface;

import java.util.Scanner;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloInterface helloInterface = RpcFramework.refer(HelloInterface.class,"127.0.0.1",7777);
        HelloSayDto helloSayDto = new HelloSayDto();
        helloSayDto.setId(1);
        helloSayDto.setName("小明");
        helloSayDto.setMsg("消息");

        Scanner sc = new Scanner(System.in);
        while(true){
            sc.next();
            System.out.println(helloInterface.say(helloSayDto));
        }
    }
}
