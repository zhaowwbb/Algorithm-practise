package com.rick.algorithms.bsearch;

import com.rick.algorithms.sorting.Comparator;

public class LinearListSearcherTest extends AbstractListSearcherTestCase {


	@Override
	protected ListSearcher createListSearch(Comparator comparator) {

		return new LinearListSearcher(comparator);
	}

}
