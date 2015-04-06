package com.epam.khodyka.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.epam.khodyka.GuitarImpl;
import com.epam.khodyka.GuitarInterface;

public class ProxyManager {

	public GuitarInterface getUnmodifiableProxy() {
		return (GuitarInterface) Proxy.newProxyInstance(
				GuitarImpl.class.getClassLoader(),
				new Class<?>[] { GuitarInterface.class },
				new UnmodifiableHandler());
	}

	public GuitarInterface getMapProxy() {
		return (GuitarInterface) Proxy.newProxyInstance(
				GuitarInterface.class.getClassLoader(),
				new Class<?>[] { GuitarInterface.class }, new MapHandler());
	}

	private class UnmodifiableHandler implements InvocationHandler {

		private Object impl;

		public UnmodifiableHandler() {
			this.impl = new GuitarImpl();
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if (method.getName().startsWith("set")) {
				throw new UnsupportedOperationException();
			}
			return method.invoke(impl, args);
		}

	}

	private class MapHandler implements InvocationHandler {

		private Map<String, Object> map;

		public MapHandler() {
			this.map = new HashMap<String, Object>();
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if (method.getName().startsWith("set")) {
				map.put(getMethodName(method.getName()), args[0]);
				return null;
			}
			if (method.getName().startsWith("get")) {
				return map.get(getMethodName(method.getName()));
			}
			return null;
		}
	}

	private String getMethodName(String fullMethodName) {
		return fullMethodName.substring(3);
	}
}
