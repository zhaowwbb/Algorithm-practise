package com.rick.algorithms.sorting;

public class BubbleSortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {		
		return new BubbleSortListSorter(comparator);
	}

}
