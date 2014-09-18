package com.ej.clone;

import java.util.Arrays;

public class Clone implements Cloneable {

	private int x = 10;
	private final String y = "Y";
	private String[] arr = new String[] { "a", "b", "c" };
	private Inner inner = new Inner(100, "X");

	public Clone() {
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Clone clone = new Clone();
		System.out.println(clone);
		Clone clone2 = (Clone) clone.clone();
		clone2.x = 200;
		System.out.println(clone2);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Clone clone = (Clone) super.clone();
		clone.arr = Arrays.copyOf(arr, arr.length);
		clone.inner = inner.clone();
		return clone;
	}

	@Override
	public String toString() {
		return "Clone [" + hashCode() + "  x=" + x + " Arr:" + arr + "]";
	}
}
