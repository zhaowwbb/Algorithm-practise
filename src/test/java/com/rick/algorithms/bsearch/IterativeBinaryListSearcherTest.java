package com.rick.algorithms.bsearch;

import com.rick.algorithms.sorting.Comparator;

public class IterativeBinaryListSearcherTest extends
		AbstractListSearcherTestCase {

	protected ListSearcher createListSearch(Comparator comparator) {
		return new IterativeBinaryListSearcher(comparator);
	}

}
