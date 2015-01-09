package com.rick.algorithms.sorting;

public class MergesortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {		
		return new MergesortListSorter(comparator);
	}

}
