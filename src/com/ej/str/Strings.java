package com.ej.str;

class Inner1 {

}

public class Strings {

	class Inner2 {

	}

	static class Inner3 {

	}

	public static void main(String[] args) {
		IListener iListener = new IListener() {
			@Override
			public void trigger() {
				System.out.println("");
			}
		};
	}

}
