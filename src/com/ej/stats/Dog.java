package com.ej.stats;

public class Dog extends Animal {

	public static Animal create() {
		return new Dog();
	}

	public Dog() {
	}

	public Dog(int age, String name) {
	}

	public static void main(String[] args) {
		Dog.create();
		new Dog();
		new Dog(10, "Bob");
	}

}
