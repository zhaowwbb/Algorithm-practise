package com.rick.algorithms.sorting;

import java.util.List;

public class ShellsortListSorter extends AbstractListSorter {
	private final int[] _increments = {121, 40, 13, 4, 1};
	
	public ShellsortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}
	
	public List sort(List list)
	{
		check(list);
		for(int i = 0; i < _increments.length; i++)
		{
			int increment = _increments[i];
			hSort(list, increment);
		}
		return list;
	}
	
	private void hSort(List list, int increment)
	{
		if(list.size() < increment * 2)
		{
			return;
		}
		for(int i = 0; i < increment; i++)
		{
			subListSort(list, i, increment);
		}
	}
	
	private void subListSort(List list, int startIndex, int increment)
	{
		for(int i = startIndex + increment; i < list.size(); i+= increment)
		{
			Object value = list.get(i);
			int j;
			for(j = i; j > startIndex; j-=increment)
			{
				Object previouValue = list.get(j - increment);
				if(_comparator.compare(value, previouValue) >= 0)
				{
					break;
				}
				list.set(j, previouValue);
			}
			list.set(j, value);
		}
	}
}
