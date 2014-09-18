package com.ej.singleton;

public class Singleton {

	private static Singleton INSTANCE;
	private static String x;

	private Singleton() {
		// 20 sn
	}

	public void method1() {

	}

	public void method2() {

	}

	private static class SingletonHolder {
		private static final Singleton INSTANCE2 = new Singleton();
	}

	public static Singleton getInstance2() {
		return SingletonHolder.INSTANCE2;
	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

}
