package com.panda.iweb.test.suggest;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import com.panda.iweb.test.entity.Copy;
import com.panda.iweb.test.entity.Student;

@SuppressWarnings("all")
public class Test_5 {

	// 浅拷贝
	@Test
	public void shallowCopy() {
		Copy copy = new Copy();
		copy.setId(1);
		Student s = new Student();
		s.setId(1);
		s.setName("小明");
		copy.setStudent(s);
		Copy newCopy = (Copy) copy.clone();

		System.out.println(copy == newCopy);
		System.out.println(copy.getStudent() == newCopy.getStudent());
	}

	// 深拷贝
	@Test
	public void deepCopy() {
		Copy copy = new Copy();
		copy.setId(1);
		Student s = new Student();
		s.setId(1);
		s.setName("小明");
		copy.setStudent(s);
		Copy newCopy = SerializationUtils.clone(copy);
		System.out.println(copy == newCopy);
		System.out.println(copy.getStudent() == newCopy.getStudent());
	}
}
