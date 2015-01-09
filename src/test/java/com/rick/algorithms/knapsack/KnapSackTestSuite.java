package com.rick.algorithms.knapsack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	knapsackTest.class,
	BruteForceSubSetSumTest.class,
	DPSubSetSumTest.class,
	BruteForceKnapSackTest.class,
	TopDownKnapSackTest.class,
	DPBottomUpKnapSackTest.class
})

public class KnapSackTestSuite {

	public KnapSackTestSuite() {

	}

}
