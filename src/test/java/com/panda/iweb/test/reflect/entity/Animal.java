package com.panda.iweb.test.reflect.entity;

import com.panda.iweb.test.reflect.annotation.Max;
import com.panda.iweb.test.reflect.annotation.NotNull;

public abstract class Animal {
	@NotNull
	private String name;
	@Max(100)
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	abstract void eat();

	void sleep() {
		System.out.println("动物睡觉了");
	}
}
