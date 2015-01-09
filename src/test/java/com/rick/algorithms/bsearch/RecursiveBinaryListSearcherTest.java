package com.rick.algorithms.bsearch;

import com.rick.algorithms.sorting.Comparator;

public class RecursiveBinaryListSearcherTest extends
		AbstractListSearcherTestCase {

	protected ListSearcher createListSearch(Comparator comparator) {
		return new RecursiveBinaryListSearcher(comparator);
	}

}
