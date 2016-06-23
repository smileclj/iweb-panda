package com.panda.iweb.test.reflect;

import org.junit.Test;

import com.panda.iweb.test.reflect.entity.Panda;

public class ReflectTest {
	@Test
	public void testClass() {
		Class<?> clazz = Panda.class;
		System.out.println("className:" + clazz.getName());
		System.out.println("canonicalName：" + clazz.getCanonicalName());
		System.out.println("simpleName:" + clazz.getSimpleName());
		System.out.println("typeName:" + clazz.getTypeName());

		System.out.println("=============package===============");
		Package p = clazz.getPackage();
		System.out.println("ImplementationTitle:" + p.getImplementationTitle());
		System.out.println(p.getImplementationVendor());
		System.out.println(p.getImplementationVersion());
		System.out.println(p.getName());
		System.out.println(p.getSpecificationTitle());
		System.out.println(p.getSpecificationVendor());
		System.out.println(p.getSpecificationVersion());
	}

	@Test
	public void testAnnotation() {
		Panda panda = new Panda();
		panda.setAge(500);
		panda.setExt("ext");
		panda.setName("小熊");
		try {
			System.out.println(Validate.validate(panda));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
