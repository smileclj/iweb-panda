package com.panda.iweb.test.reflect.entity;

public class Panda extends Animal {
	private String ext;

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	void eat() {
		System.out.println("熊猫吃饭了");
	}

}
