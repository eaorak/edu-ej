package com.ej.stats;

public class Cache<T extends Animal> {

	private T obj;

	public Cache() {

	}

	public Cache(T obj) {
		this.obj = obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public static void main(String[] args) {
		new Cache<Animal>();
		new Cache<Dog>();
	}

}
