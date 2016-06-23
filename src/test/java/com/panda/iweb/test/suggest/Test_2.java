package com.panda.iweb.test.suggest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//java调用脚本语言(javascript)
public class Test_2 {
	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException, URISyntaxException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		Bindings bindings = engine.createBindings();
		bindings.put("c", 1);
		engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
		File file = new File(Test_2.class.getResource("/com/iweb/panda/suggest/demo.js").toURI());
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		engine.eval(new FileReader(file));
		if (engine instanceof Invocable) {
			Invocable in = (Invocable) engine;
			Double sum = (Double) in.invokeFunction("plus", 1, 1);
			System.out.println("运算结果是:" + sum);
		}
	}
}
