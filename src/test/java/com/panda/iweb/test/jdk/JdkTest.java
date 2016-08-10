package com.panda.iweb.test.jdk;

import com.panda.iweb.test.jdk.base.JdkEntity;
import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by huixiangdou on 2016/8/5.
 */
public class JdkTest {
    /**
     * Objects
     *
     * @since 1.7
     */
    @Test
    public void objects() {
        String s1 = new String("1");
        String s2 = new String("1");
        //compare
        System.out.println(Objects.compare(s1, s2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }));
        //hashcode
        System.out.println(Objects.hash(s1));
        System.out.println(Objects.hashCode(s1));

        JdkEntity entity = new JdkEntity("1", 1);
        System.out.println(Objects.toString(entity));
    }
}
