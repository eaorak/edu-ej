package com.ej.weak;

import java.util.ArrayList;
import java.util.List;

public class Gens {

	static class A {
	}

	static class B extends A {
	}

	static class C extends B {
	}

	static class D extends B {
	}

	public static void main(String[] args) {
		List<? extends B> la;
		// la = new ArrayList<A>();
		la = new ArrayList<B>();
		la = new ArrayList<C>();
		la = new ArrayList<D>();
		someMethod(la);

		List<? super B> lb;
		lb = new ArrayList<A>(); // fine
		lb = new ArrayList<B>(); // fine
		// lb = new ArrayList<C>(); // will not compile
		otherMethod(lb);

	}

	public static void someMethod(List<? extends B> lb) {
		B b = lb.get(0); // is fine
		// lb.add(new B());
		// will not compile as we do not know the type of the
		// list, only that it is bounded above by B
	}

	public static void otherMethod(List<? super B> lb) {
		// B b = lb.get(0); // will not compile as we do not know whether the
		// list
		// is of type B, it may be a List<A> and only
		// contain instances of A
		lb.add(new B()); // is fine, as we know that it will be a super type of
							// A
	}

}
