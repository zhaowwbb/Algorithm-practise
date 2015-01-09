package com.rick.algorithms.sorting;

public class HeapsortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {		
		return new HeapsortListSorter(comparator);
	}

}
