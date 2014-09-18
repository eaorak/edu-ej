package com.ej.patterns.fault;

public class FaultMailer implements IFaultListener {

	private final int priority;

	public FaultMailer(FaultMessageGenerator fmg, int priority) {
		this.priority = priority;
		fmg.addListener(this);
	}

	@Override
	public void faulted(Fault fault) {
		System.out.println("Mailing ... " + fault);
	}

	@Override
	public int priority() {
		return priority;
	}

}
