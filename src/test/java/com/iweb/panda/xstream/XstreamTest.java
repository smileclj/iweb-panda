package com.iweb.panda.xstream;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;

public class XstreamTest {

    private static final Logger logger = LoggerFactory.getLogger(XstreamTest.class);

    @Test
    public void javaToXmlStr() {
        Student s = new Student();
        s.setId(1);
        s.setName("小明");
        Address address = new Address();
        address.setNo(1);
        address.setProvince("浙江省");
        address.setCity("杭州市");
        address.setDetail("古荡街道");
        s.setAddress(address);
        XStream xstream = new XStream();
        xstream.alias("student", Student.class); // 去掉student前的包名
        logger.info("java对象转xml字符串:{}", xstream.toXML(s));
    }
}
