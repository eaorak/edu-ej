package com.ej.ser;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyObject implements Serializable {

	private final int x;
	private final int y;
	private transient int sum;

	public MyObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.sum = x + y;
	}

	private void writeObject(ObjectOutputStream oos) throws Exception {

	}

	private void readObject(ObjectInputStream ois) throws Exception {
		ois.readObject();
		//
		this.sum = x + y;
	}

}
