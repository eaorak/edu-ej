package com.ej.patterns.fault;

public class FaultLogger implements IFaultListener {

	public FaultLogger(FaultMessageGenerator fmg) {
		fmg.addListener(this);
	}

	@Override
	public void faulted(Fault fault) {
		System.out.println("Logging ... " + fault);
	}

}
