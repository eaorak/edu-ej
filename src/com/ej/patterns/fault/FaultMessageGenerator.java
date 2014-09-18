package com.ej.patterns.fault;

import java.util.Set;
import java.util.TreeSet;

public class FaultMessageGenerator {

	private final Set<IFaultListener> listeners = new TreeSet<IFaultListener>(new ListenerComparator());

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
		new FaultMailer(fmg, 1);
		new FaultLogger(fmg, 0);
		new FaultLogger(fmg, 1);
		//
		Fault fault = new Fault("OMG ! System failure.", System.currentTimeMillis());
		fmg.faulted(fault);
	}

}
