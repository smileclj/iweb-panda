package com.panda.iweb.test.rpc;

import com.panda.iweb.test.rpc.RpcFramework;
import com.panda.iweb.test.rpc.interfaces.HelloInterface;
import com.panda.iweb.test.rpc.interfaces.impl.HelloInterfaceImpl;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloInterface helloInterface = new HelloInterfaceImpl();
        RpcFramework.export(helloInterface,7777);
    }
}
