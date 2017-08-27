package com.rick.algorithms.sorting;

import java.util.List;

public class SelectionSortListSorter extends AbstractListSorter {
	
	
	public SelectionSortListSorter(Comparator comparator) {
		this._comparator = comparator;
	}

	public List sort(List list) {
		check(list);

        int size = list.size();
		
		for(int slot = 0; slot < size; slot++)
		{
			int smallest = slot;
			for(int check = slot + 1; check < size; check++)
			{
				if(_comparator.compare(list.get(smallest), list.get(check)) > 0)
				{
					smallest = check;
				}
			}
			swap(list, smallest, slot);
		}
		return list;
	}
	
}
