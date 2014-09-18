package com.ej.ex;

public class Exceptions {

	static class MyResource implements AutoCloseable {

		@Override
		public void close() throws Exception {
			System.out.println("Closing");
		}

	}

	public static void main(String[] args) {
		try (MyResource r = new MyResource();) {
			System.out.println("try");
		} catch (Exception e) {
			System.out.println("catch");
		}
	}

}
