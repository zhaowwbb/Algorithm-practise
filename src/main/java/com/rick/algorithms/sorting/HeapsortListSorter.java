package com.rick.algorithms.sorting;

import java.util.List;

public class HeapsortListSorter extends AbstractListSorter {
	
	public HeapsortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}
	
	private int getParentIndex(int i)
	{
		return (i - 1) >> 1;
	}
	
	private int getLeftChild(int i)
	{
		return (i << 1) + 1;
	}
	
	private int getRightChild(int i)
	{
		return (i << 1) + 2;
	}
	
	private void headAdj(List list, int size, int start)
	{
		int l = (start * 2) + 1;
		int r = (start * 2) + 2;
		int m = start;
		if(l < size && _comparator.compare(list.get(l), list.get(m)) > 0)
		{
			m = l;
		}
		if(r < size && _comparator.compare(list.get(r), list.get(m)) > 0)
		{
			m = r;
		}
		if(m != start)
		{
			swap(list, m, start);
			headAdj(list, size, m);
		}
	}
	
	public List sort(List list) {
		check(list);
		int parent = (list.size() - 1)/2;
		for(int i = parent; i >= 0; i--)
		{
			headAdj(list, list.size(), i);
		}
		for(int i = list.size() - 1; i > 0; i--)
		{
			swap(list, i, 0);
			headAdj(list, i, 0);
		}
		return list;
	}
}
