package com.panda.iweb.test.entity;

/**
 * Created by huixiangdou on 2016/9/12.
 */
public class CC{
    public static void main(String[] args) {
        AA aa = new AA();

        BB bb = new BB();

        CC cc = new CC();

        System.out.println(aa instanceof BB);
        System.out.println(aa instanceof CC);
    }
}
