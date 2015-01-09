package com.rick.algorithms.bsearch;

import java.util.List;

import com.rick.algorithms.sorting.Comparator;

public class IterativeBinaryListSearcher implements ListSearcher {
	private final Comparator _comparator;
	
	public IterativeBinaryListSearcher(Comparator comparator) {
		this._comparator = comparator;
	}

	public int search(List list, Object o) {
		assert list != null : "list can't be null";
		if(list.isEmpty())return -1;
		return bSearch(list, o, 0, list.size() - 1);
	}
	
	private int bSearch(List list, Object o, int startIndex, int endIndex)
	{
		int left = startIndex;
		int right = endIndex;
		while(left <= right)
		{
			int index = left + (right - left)/2;
			int cmp = _comparator.compare(list.get(index), o);
			if(cmp < 0)
			{
				left = index + 1;
			}else if(cmp > 0)
			{
				right = index - 1;
			}
			else
			{
				return index;
			}
		}
//		if(startIndex > endIndex)
//		{
//			return 
//		}
		return -(left + 1);
	}

}
