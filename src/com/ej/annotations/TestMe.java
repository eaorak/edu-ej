package com.ej.annotations;

import java.lang.reflect.Constructor;

@UnitTest
public class TestMe {

	@BeforeClass
	public void preClass() {
		System.out.println("Pre class");
	}

	@AfterClass
	public void postClass() {
		System.out.println("Post class");
	}

	@Before
	public void preExec() {
		System.out.println("Pre exec");
	}

	@After
	public void postExec() {
		System.out.println("Post exec");
	}

	@Test(exceptions = { RuntimeException.class })
	public void test1() {
		System.out.println("Test 1 has completed.");
		throw new RuntimeException();
	}

	@Test
	public void test2() {
		System.out.println("Test 2 has completed.");
	}

	public void nonTest() {
		System.out.println("No test.");
	}

	public static void main(String[] args) throws Exception {
		Constructor<TestMe> constructor = TestMe.class.getConstructor(int.class);
		TestMe instance = constructor.newInstance(10);
		System.out.println(instance);
	}

}
