package com.rick.algorithms.bsearch;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rick.algorithms.sorting.SortListCallCountingTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RecursiveBinaryListSearcherTest.class,
	IterativeBinaryListSearcherTest.class,
	ListInserterTest.class,
	LinearListSearcherTest.class
})


public class BSearchTestSuite {

	public BSearchTestSuite() {
	}

}
