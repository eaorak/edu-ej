package com.ej.patterns.fault;

public class FaultSender implements Runnable {

	private final Fault message;
	private final IFaultListener listener;

	public FaultSender(IFaultListener listener, Fault message) {
		this.listener = listener;
		this.message = message;
	}

	@Override
	public void run() {
		listener.faulted(message);
	}

}
