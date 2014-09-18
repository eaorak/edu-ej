package com.ej.patterns.fault;

public class FaultLogger implements IFaultListener {

	private final int priority;

	public FaultLogger(FaultMessageGenerator fmg, int priority) {
		this.priority = priority;
		fmg.addListener(this);
	}

	@Override
	public void faulted(Fault fault) {
		System.out.println("Logging ... " + fault);
	}

	@Override
	public int priority() {
		return priority;
	}

}
