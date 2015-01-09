package com.rick.algorithms.sorting;

import java.util.List;

public abstract class AbstractListSorter implements ListSorter {
	
	protected Comparator _comparator;
	
	protected void check(List list)
	{
		assert list != null : "list can't be null";
	}

	protected void swap(List list, int left, int right)
	{
		if(left == right)return;
		Object o = list.get(left);
		list.set(left, list.get(right));
		list.set(right, o);
	}	
}
