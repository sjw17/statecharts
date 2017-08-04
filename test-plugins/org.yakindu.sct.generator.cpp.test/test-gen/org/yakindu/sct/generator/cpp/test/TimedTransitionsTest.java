/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/TimedTransitionsTest/TimedTransitionsTest.cc",
	program = "gtests/TimedTransitionsTest/TimedTransitions",
	model = "testmodels/SCTUnit/TimedTransitions.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_runner_timed.h",
		"libraryTarget/sc_runner_timed.cpp"
	},
	additionalFilesToCompile = {
		"TimedTransitions.cpp",
		"sc_runner_timed.cpp"
	}
)
@RunWith(GTestRunner.class)
public class TimedTransitionsTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
