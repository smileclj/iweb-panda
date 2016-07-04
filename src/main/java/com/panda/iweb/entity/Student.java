package com.panda.iweb.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	private static final long serialVersionUID = -6335997337005876537L;

	private Integer id;

	private String name;

	private Integer sex;

	private Date createTime;

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
		this.name = name == null ? null : name.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}