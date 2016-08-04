package com.panda.iweb.test.suggest;

import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Test_6 {
	// public static <T extends Student> T say(T s) {
	// Student ss = new Student();
	// ss.setName(s.getName());
	// return ss;
	// }
	//
	// public static void main(String[] args) {
	// System.out.println(Test_6.say("123"));
	// }
	
	public static void main(String[] args) {
		System.out.println(new HashCodeBuilder().append("123").toHashCode());
	}
}
