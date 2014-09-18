package com.ej.enums;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Consts {

	public static final int STOPPED = 0;
	public static final int STARTED = 1;
	public static final int INIT = 2;
	public static final int WAITING = 3;

	Map<States, String> stateMap = new HashMap<>();
	EnumMap<States, String> map = new EnumMap<>(States.class);

	enum States {
		INIT(0), STOPPED(1), STARTED(2), WAITING(3);

		private final int state;

		private States(int state) {
			this.state = state;
		}

		public int value() {
			return state;
		}
	}

	public static void main(String[] args) {
		for (States s : States.values()) {
			System.out.println(s.ordinal() + " : " + s.name());
		}
		System.out.println(States.INIT.value());
	}

	/**
	 * States should be used from Consts.
	 * 
	 * @param state
	 * @see Consts
	 */
	public static void setState(int state) {

	}

	public static void setState(States state) {

	}

}
