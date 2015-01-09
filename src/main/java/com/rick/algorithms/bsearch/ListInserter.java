package com.rick.algorithms.bsearch;

import java.util.List;

public class ListInserter {
	private final  ListSearcher _listSearcher;
	
	public ListInserter(ListSearcher searcher) {
		this._listSearcher = searcher;
	}

	public int insert(List list, Object o)
	{
		int index = _listSearcher.search(list, o);
		if(index < 0)
		{
			index = -(index + 1);
		}
		list.add(index, o);
		return index;
	}
}
