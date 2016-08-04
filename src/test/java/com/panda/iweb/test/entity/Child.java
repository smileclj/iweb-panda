package com.panda.iweb.test.entity;

public class Child extends Parent implements Cloneable {
	private String c1;

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return getC1() + "_" + getP1();
	}

}
