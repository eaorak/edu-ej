package com.ej.patterns.fault;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaultMessageGenerator {

	private final Set<IFaultListener> listeners = new TreeSet<IFaultListener>(new ListenerComparator());
	private final ExecutorService pool = Executors.newFixedThreadPool(5);

	public FaultMessageGenerator() {
	}

	public void faulted(Fault fault) {
		for (IFaultListener listener : listeners) {
			FaultSender sender = new FaultSender(listener, fault);
			pool.execute(sender);
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
