package com.rick.algorithms.sorting;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class InsertionSortListSorter extends AbstractListSorter {

	public InsertionSortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}

	public List sort(List list)
	{
		check(list);
		int size = list.size();
		List result = new LinkedList();
		
		for(Iterator it = list.iterator(); it.hasNext(); )
		{
			Object temp = it.next();
			int slot = result.size();
			while(slot > 0)
			{
				if(_comparator.compare(temp, result.get(slot - 1)) >= 0)
				{
					break;
				}
				slot--;
			}
			result.add(slot, temp);
		}
		return result;
	}

}
