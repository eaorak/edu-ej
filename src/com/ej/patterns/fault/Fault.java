package com.ej.patterns.fault;

public class Fault {

	private final String message;
	private final long time;

	public Fault(String message, long time) {
		this.message = message;
		this.time = time;
	}

	public String message() {
		return message;
	}

	public long time() {
		return time;
	}

	@Override
	public String toString() {
		return "Fault [message=" + message + ", time=" + time + "]";
	}

}
