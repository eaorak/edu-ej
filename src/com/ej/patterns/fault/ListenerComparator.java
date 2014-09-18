package com.ej.patterns.fault;

import java.util.Comparator;

public class ListenerComparator implements Comparator<IFaultListener> {

	@Override
	public int compare(IFaultListener o1, IFaultListener o2) {
		return o1.priority() - o2.priority();
	}

}
