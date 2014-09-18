package com.ej.hashcode;

public class Todo {

	String s;

	public Todo(String s) {
		this.s = s;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Todo)) {
			return false;
		}
		return ((Todo) obj).s.equals(s);
	}

	public static void main(String[] args) {
		Todo todo1 = new Todo("Monday");
		Todo todo2 = new Todo("Monday");
		System.out.println(todo1);
		System.out.println(todo2);
	}

}
