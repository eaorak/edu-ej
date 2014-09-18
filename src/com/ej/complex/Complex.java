package com.ej.complex;

import java.util.Map;
import java.util.WeakHashMap;

public class Complex {

	private final double real;
	private final double im;

	private final Map<String, Complex> map = new WeakHashMap<String, Complex>();

	public Complex create(double real, double im) {
		String key = real + ":" + im;
		Complex comp = map.get(key);
		if (comp == null) {
			comp = new Complex(real, im);
			map.put(key, comp);
		}
		return comp;
	}

	private Complex(double real, double im) {
		this.real = real;
		this.im = im;
	}

	public Complex add(Complex c) {
		return create(real + c.real, im + c.im);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Complex) {
			Complex c = (Complex) obj;
			return real == c.real && im == c.im;
		}
		return false;
	}

}
