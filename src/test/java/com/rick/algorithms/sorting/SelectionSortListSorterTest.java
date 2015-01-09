package com.rick.algorithms.sorting;

public class SelectionSortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {
		return new SelectionSortListSorter(comparator);
	}

}
