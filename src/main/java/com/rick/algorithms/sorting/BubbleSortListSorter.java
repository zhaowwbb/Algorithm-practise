package com.rick.algorithms.sorting;

import java.util.List;

public class BubbleSortListSorter extends AbstractListSorter {
	
	public BubbleSortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}

	@Override
	public List sort(List list) {
		check(list);
		int size = list.size();
		
		for(int pass = 1; pass < size; pass++)
		{
			for(int left = 0; left < size - pass; left++)
			{
				int right = left + 1;
				if(_comparator.compare(list.get(left), list.get(right)) > 0)
				{
					swap(list, left, right);
				}
			}
		}

		return list;
	}
}
