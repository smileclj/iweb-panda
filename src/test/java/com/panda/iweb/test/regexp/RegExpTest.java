package com.panda.iweb.test.regexp;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class RegExpTest {
    @Test
    public void test_1(){
        String input = "-";
        System.out.println(Pattern.compile("^[a-zA-Z0-9_-]$").matcher(input).matches());
    }
}
