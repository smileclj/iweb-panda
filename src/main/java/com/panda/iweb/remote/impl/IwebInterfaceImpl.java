package com.panda.iweb.remote.impl;

import com.panda.iweb.remote.IwebInterface;

public class IwebInterfaceImpl implements IwebInterface {

	@Override
	public String sayHello(String name) {
		return "Hello" + name;
	}

}
