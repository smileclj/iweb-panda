package com.panda.iweb.test.rpc;

import com.alibaba.fastjson.JSON;
import com.panda.iweb.test.rpc.dto.HelloSayDto;
import com.panda.iweb.test.rpc.interfaces.HelloInterface;
import com.panda.iweb.test.rpc.interfaces.impl.HelloInterfaceImpl;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class RpcFrameworkFileVersion {
    private static final String PATH1 = "/Users/chenlijiang/tmp/RpcS1";

    private static String getParamTypeNames(Class<?>[] parameterTypes) {
        StringBuilder sb = new StringBuilder();
        for (Class<?> clazz : parameterTypes) {
            sb.append(clazz.getName()).append(",");
        }
        return sb.toString();
    }

    /**
     * 暴露服务
     *
     * @throws Exception
     */
    public static void export(Object service) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(PATH1));
        try {
            String methodName = input.readUTF();
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
            Object[] arguments = (Object[]) input.readObject();
            System.out.println("方法名:" + methodName);
            System.out.println("参数类型:" + getParamTypeNames(parameterTypes));
            System.out.println("参数值:" + JSON.toJSONString(arguments));
            Method method = service.getClass().getMethod(methodName, parameterTypes);
            Object result = method.invoke(service, arguments);
            System.out.println(result);
        } finally {
            input.close();
        }
    }

    /**
     * 引用服务
     *
     * @param <T>            接口泛型
     * @param interfaceClass 接口类型
     * @return 远程服务
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass) throws Exception {
        if (interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if (!interfaceClass.isInterface())
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
                File file = new File(PATH1);
//                file.deleteOnExit();
                file.createNewFile();
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(PATH1));
                try {
                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(arguments);
                    output.flush();
                    return "success";
                } finally {
                    output.close();
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
//            HelloInterface helloInterface = RpcFrameworkFileVersion.refer(HelloInterface.class);
//            HelloSayDto helloSayDto = new HelloSayDto();
//            helloSayDto.setId(1);
//            helloSayDto.setName("小明");
//            helloSayDto.setMsg("消息");
//            helloSayDto.setAddress("地址");
//            helloInterface.say(helloSayDto);
//            System.out.println("输出");
//            System.in.read();
            RpcFrameworkFileVersion.export(new HelloInterfaceImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
