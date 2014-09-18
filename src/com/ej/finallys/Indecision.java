package com.ej.finallys;

public class Indecision {

	public static boolean decide() {
		try {
			return false;
		} finally {
			return true;
		}
	}

	private final Object o = new Object();

	public void method1() {
		synchronized (o) {

		}
	}

	public synchronized void method2() {

	}

	public static void main(String[] args) {
		System.out.println(decide());
	}

}
