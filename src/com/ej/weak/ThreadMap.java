package com.ej.weak;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class ThreadMap {

	static Map<Long, Thread> map = new WeakHashMap<Long, Thread>();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Size: " + map.size());
		method();
		Runtime.getRuntime().gc();
		Thread.sleep(TimeUnit.MINUTES.toMillis(3));
		System.out.println("Size: " + map.size());
	}

	public static void method() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Whatever");
			}
		});
		map.put(thread.getId(), thread);
		thread.start();
	}

}
