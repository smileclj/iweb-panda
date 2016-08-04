package com.panda.iweb.test.entity;

import java.io.Serializable;

public class Copy implements Cloneable, Serializable {
	private static final long serialVersionUID = -3735487827433760481L;
	private int id;
	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
