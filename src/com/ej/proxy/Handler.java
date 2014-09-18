package com.ej.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Handler implements InvocationHandler {

	private final List<?> list;

	public Handler(List<?> list) {
		this.list = list;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("add")) {
			System.out.println("# add called.");
		}
		System.out.println(">> Method: " + method + " Args: " + Arrays.toString(args));
		Object result = method.invoke(list, args);
		System.out.println("   Result: " + result);
		return result;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> proxy = (List<String>) java.lang.reflect.Proxy.newProxyInstance(Handler.class.getClassLoader(), //
				new Class[] { List.class }, new Handler(list));
		proxy.add("Hebe");
		proxy.get(0);
		proxy.size();

	}
}
