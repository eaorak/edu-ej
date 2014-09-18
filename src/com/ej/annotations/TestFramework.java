package com.ej.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class TestFramework {

	enum Anns {
		BEFORE(Before.class), //
		AFTER(After.class), //
		BEFORE_CLASS(BeforeClass.class), //
		AFTER_CLASS(AfterClass.class);

		private final Class<? extends Annotation> ann;

		private Anns(Class<? extends Annotation> ann) {
			this.ann = ann;
		}

		public Class<? extends Annotation> annotation() {
			return ann;
		}
	}

	private final List<Method> tests = new ArrayList<Method>();
	private final EnumMap<Anns, Method> inits = new EnumMap<>(Anns.class);

	public void test(Class<?> testClass) throws Exception {
		findAnnotations(testClass);
		execute(testClass);
	}

	private void findAnnotations(Class<?> testClass) {
		Method[] methods = testClass.getDeclaredMethods();
		for (Method m : methods) {
			Test test = m.getAnnotation(Test.class);
			if (test != null) {
				tests.add(m);
			} else {
				for (Anns ann : Anns.values()) {
					if (m.isAnnotationPresent(ann.annotation())) {
						inits.put(ann, m);
					}
				}
			}
		}
	}

	public void execute(Class<?> testClass) throws Exception {
		Object instance = testClass.newInstance();
		boolean success = executeMethod(inits.get(BeforeClass.class), instance);
		if (!success) {
			System.out.println("Before class failed !");
		}
		for (Method m : tests) {
			success = success && executeMethod(inits.get(Before.class), instance);
			success = success && executeMethod(m, instance, m.getAnnotation(Test.class));
			success = success && executeMethod(inits.get(After.class), instance);
		}
		success &= executeMethod(inits.get(AfterClass.class), instance);
		System.out.println(success);
	}

	public boolean executeMethod(Method m, Object o) {
		if (m == null || o == null) {
			return true;
		}
		try {
			m.invoke(o, (Object[]) null);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean executeMethod(Method m, Object o, Test test) {
		boolean success = false;
		try {
			m.invoke(o, (Object[]) null);
			success = true;
		} catch (Exception e) {
			if (Arrays.asList(test.exceptions()).contains(e.getCause().getClass())) {
				success = true;
			}
		}
		return success;
	}

	public static void main(String[] args) throws Exception {
		TestFramework fw = new TestFramework();
		fw.test(TestMe.class);
	}
}
