package com.ej.patterns.fault;

import java.util.ArrayList;
import java.util.List;

public class FaultMessageGenerator {

	private final List<IFaultListener> listeners = new ArrayList<IFaultListener>();

	public void faulted(Fault fault) {
		for (IFaultListener listener : listeners) {
			listener.faulted(fault);
		}
	}

	public void addListener(IFaultListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IFaultListener listener) {
		listeners.remove(listener);
	}

	public static void main(String[] args) {
		FaultMessageGenerator fmg = new FaultMessageGenerator();
		new FaultMailer(fmg);
		new FaultLogger(fmg);
		//
		Fault fault = new Fault("OMG ! System failure.", System.currentTimeMillis());
		fmg.faulted(fault);
	}

}
