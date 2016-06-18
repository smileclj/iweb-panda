package com.panda.iweb.service.impl;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.panda.iweb.entity.Student;
import com.panda.iweb.mapper.StudentMapperExt;

@Component
public class MyTask extends Thread {
	private CountDownLatch latch;
	@Resource
	private StudentMapperExt studentMapperExt;

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			Student student = new Student();
			student.setName("小美" + i);
			student.setSex(1);
			student.setCreateTime(new Date());
			studentMapperExt.insertSelective(student);
		}
		latch.countDown();
	}

	public void setLetch(CountDownLatch latch) {
		this.latch = latch;
	}
}
