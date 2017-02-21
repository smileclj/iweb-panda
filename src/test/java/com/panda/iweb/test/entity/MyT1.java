package com.panda.iweb.test.entity;

/**
 * Created by chenlijiang on 2017/1/5.
 */
public class MyT1 extends Base{
    private String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) {
        MyT1 myT1 = new MyT1();
        myT1.setId("1");

        System.out.println(myT1.getId());
    }
}
