package com.ej.patterns.fault;

public class FaultMailer implements IFaultListener {

	public FaultMailer(FaultMessageGenerator fmg) {
		fmg.addListener(this);
	}

	@Override
	public void faulted(Fault fault) {
		System.out.println("Mailing ... " + fault);
	}

}
