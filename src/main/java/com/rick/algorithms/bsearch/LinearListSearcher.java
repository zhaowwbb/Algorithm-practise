package com.rick.algorithms.bsearch;

import java.util.List;

import com.rick.algorithms.sorting.Comparator;

public class LinearListSearcher implements ListSearcher {
	private final Comparator _comparator;
	public LinearListSearcher(Comparator comparator) {
		this._comparator = comparator;
	}

	@Override
	public int search(List list, Object o) {
		assert list != null : "list can't be null";
		int i;
		for(i = 0; i < list.size(); i++)
		{
			if(_comparator.compare(list.get(i), o) == 0)
			{
				return i;
			}
			else
			{
				if(_comparator.compare(list.get(i), o) > 0)
				{
					break;
				}
			}
		}
		return -(i + 1);
	}

}
