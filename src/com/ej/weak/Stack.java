package com.ej.weak;

import java.lang.reflect.Array;

public class Stack<E> {

	private final E[] elements;
	private int index;
	private final E e = (E) new Object();

	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) Array.newInstance(e.getClass(), 20);
	}

	public void push(E element) {
		elements[index++] = element;
	}

	public E pop() {
		return elements[--index];
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("x");
		System.out.println(stack.pop());
	}

}
