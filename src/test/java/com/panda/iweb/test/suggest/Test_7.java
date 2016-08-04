package com.panda.iweb.test.suggest;

import java.util.ArrayList;
import java.util.List;

public class Test_7 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>() {
			private static final long serialVersionUID = 2940526910923616023L;

			{
				add("1");
				add("2");
				add("3");
			}
		};
		List<String> sub = list.subList(0, 1);
		sub.add("4");
	}
}
