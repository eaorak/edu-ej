package com.ej.clone;

public class Inner implements Cloneable {

	private final int a;
	private final String x;

	public Inner(int i, String string) {
		a = i;
		x = string;
	}

	@Override
	public Inner clone() throws CloneNotSupportedException {
		return (Inner) super.clone();
	}

	@Override
	public String toString() {
		return "Inner [" + hashCode() + " a=" + a + ", x=" + x + "]";
	}
}
