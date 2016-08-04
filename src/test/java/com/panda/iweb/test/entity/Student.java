package com.panda.iweb.test.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 661245749982045028L;
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
