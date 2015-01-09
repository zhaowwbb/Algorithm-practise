package com.rick.algorithms.sorting;

public class ShellsortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {
		return new ShellsortListSorter(comparator);
	}

}
