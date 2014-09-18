package com.ej.compare;

public class PhoneNumber implements Comparable<PhoneNumber> {

	private int area;
	private int prefix;
	private int line;

	@Override
	public int compareTo(PhoneNumber o) {
		return 0;
	}

}
