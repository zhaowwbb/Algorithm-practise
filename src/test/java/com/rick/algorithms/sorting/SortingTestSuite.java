package com.rick.algorithms.sorting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BubbleSortListSorterTest.class,
	InsertionSortListSorterTest.class,
	ShellsortListSorterTest.class,
	QuicksortListSorterTest.class,
	MergesortListSorterTest.class,
	HeapsortListSorterTest.class,
	SortListCallCountingTest.class,
	SelectionSortListSorterTest.class
})

public class SortingTestSuite {

	public SortingTestSuite() {
	}

}
