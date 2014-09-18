package com.ej.generics;

public class Stack<T extends Number> {

	private final T[] elements;
	private int size;

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		elements = (T[]) new Object[size];
	}

	public void push(T e) {
		elements[size++] = e;
	}

	public T pop() {
		T t = elements[--size];
		elements[size + 1] = null;
		return t;
	}

	public static void main(String[] args) {
		new Stack<Integer>(10); // OK
		new Stack<Long>(10); // OK
		// new Stack<String>(10); // NOT OK
	}

}
