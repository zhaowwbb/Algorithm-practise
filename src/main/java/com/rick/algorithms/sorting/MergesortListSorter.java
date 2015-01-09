package com.rick.algorithms.sorting;

import java.util.List;
import java.util.ArrayList;

public class MergesortListSorter extends AbstractListSorter {
	
	public MergesortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}

	public List sort(List list) {
		check(list);
		return mergeSort(list, 0, list.size() - 1);
	}
	
	private List mergeSort(List list, int start, int end)
	{
		if(start == end)
		{
			List result = new ArrayList();
			result.add(list.get(start));
			return result;
		}
		int mid = start + (end - start)/2;
		List left = mergeSort(list, start, mid);
		List right = mergeSort(list, mid + 1, end);
		return merge(left, right);
	}
	
	private List merge(List left, List right)
	{
		int lPos = 0;
		int rPos = 0;
		List list = new ArrayList();
		while(lPos < left.size() || rPos < right.size())
		{
			if(lPos == left.size())
			{
				list.add(right.get(rPos++));
			}
			else if(rPos == right.size())
			{
				list.add(left.get(lPos++));
			}
			else
			{
				if(_comparator.compare(left.get(lPos), right.get(rPos)) > 0)
				{
					list.add(right.get(rPos++));
				}
				else
				{
					list.add(left.get(lPos++));
				}
			}
		}
		return list;
	}
}
