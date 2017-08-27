package com.rick.algorithms.sorting;

import java.util.List;

public class QuicksortListSorter extends AbstractListSorter {
	
	public QuicksortListSorter(Comparator comparator) {
        assert comparator != null : "comparator cannot be null";
        _comparator = comparator;
	}

	public List sort(List list) {
		check(list);		
		quickSort(list, 0, list.size() - 1);
		return list;
	}
		
	private int partition(List list, Object value, int start, int end)
	{
		int l = start;
		int r = end;
		while(l < r)
		{
			if(_comparator.compare(list.get(l), value) < 0)
			{
				l++;
				continue;
			}
			if(_comparator.compare(list.get(r), value) >= 0)
			{
				r--;
				continue;
			}
			swap(list, l, r);
			l++;
		}
		return l;
	}
	
	private void quickSort(List list, int start, int end)
	{
		if(start < 0 || start >= list.size())return;
		if(end < 0 || end >= list.size() || start >= end)return;
		Object value = list.get(end);
		int partition = partition(list, value, start, end);
		if(_comparator.compare(list.get(partition), value) < 0)
		{
			partition++;
		}
		swap(list, partition, end);
		
		quickSort(list, start, partition - 1);
		quickSort(list, partition + 1, end);
	}
}
