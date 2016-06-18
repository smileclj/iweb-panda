package com.iweb.panda.entity;

public class RefClass {

    private int    id;
    private String name;

    public RefClass(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
