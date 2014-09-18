package com.ej.generics;

class Dog {

	public void bark() {
		System.out.println("Bark");
	}
}

class Hound extends Dog {
	@Override
	public void bark() {
		System.out.println("Hound Bark");
	}
}

public class Methods {

	enum E {

	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(E.values());
	}

}
