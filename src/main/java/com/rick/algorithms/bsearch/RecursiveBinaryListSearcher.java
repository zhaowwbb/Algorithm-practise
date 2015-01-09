package com.rick.algorithms.bsearch;

import java.util.List;

import com.rick.algorithms.sorting.Comparator;

public class RecursiveBinaryListSearcher implements ListSearcher {
	private final Comparator _comparator;
	
	public RecursiveBinaryListSearcher(Comparator comparator) {
		this._comparator = comparator;
	}

	public int search(List list, Object o) {
		assert list != null : "list can't be null";
		if(list.isEmpty())return -1;		
		return bSearch(list, o);
	}

	private int bSearch(List list, Object o)
	{
		return bSearch(list, o, 0, list.size() - 1);
	}
	
//	private int bSearch(List list, Object o, int start, int end)
//	{
//		if(start > end)
//		{
//			return -(start + 1);
//		}
//		else
//		{
//			int index = start + ((end - start) >> 1);
//			int cmp = _comparator.compare(list.get(index), o);
//			
//			if(cmp > 0)
//			{
//				index = bSearch(list, o, start, index - 1);
//			}
//			else if(cmp < 0)
//			{
//				index = bSearch(list, o, index + 1, end);
//			}
//			return index;
//		}
//	}
	
//	private int bSearch(List list, Object o, int startIndex, int endIndex)
//	{
//		if(startIndex > endIndex)
//		{
//			return -(startIndex + 1);
//		}
//		else
//		{
//			int index = startIndex + (endIndex - startIndex)/2;
//			int cmp = _comparator.compare(list.get(index), o);
//			if(cmp < 0)
//			{
//				return bSearch(list, o, index + 1, endIndex);
//			}else if(cmp == 0)
//			{
//				return index;
//			}
//			else
//			{
//				return bSearch(list, o, startIndex, index - 1);
//			}
//		}
//	}
	
	//============================================================
	//practice 2
	
	private int bSearch(List list, Object o, int startIndex, int endIndex)
	{
		if(startIndex > endIndex)
		{
			return -(startIndex + 1);
		}
		
		int index = startIndex + (startIndex - startIndex)/2;
		int cmp = _comparator.compare(list.get(index), o);
		if(cmp > 0)
		{
			return bSearch(list, o, startIndex, index - 1);
		}else if(cmp < 0)
		{
			return bSearch(list, o, index + 1, endIndex);
		}
		else
		{
			return index;
		}
	}
}
