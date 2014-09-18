package com.ej.patterns.fault;

public class FaultLogger implements IFaultListener {

	private final int priority;

	public FaultLogger(FaultMessageGenerator fmg, int priority) {
		this.priority = priority;
		fmg.addListener(this);
	}

	@Override
	public void faulted(Fault fault) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Logging ... " + fault);
	}

	@Override
	public int priority() {
		return priority;
	}

}
