package com.ej.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Running");
	}

	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		//
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
		pool.execute(runnable);
	}

}
