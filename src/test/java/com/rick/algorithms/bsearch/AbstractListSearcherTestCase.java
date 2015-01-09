package com.rick.algorithms.bsearch;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import com.rick.algorithms.sorting.Comparator;
import com.rick.algorithms.sorting.NaturalComparator;
import com.rick.algorithms.util.Util;

public abstract class AbstractListSearcherTestCase extends TestCase {

	private ListSearcher _listSearcher;
	private List _list;
	
	protected void setUp() throws Exception
	{
		_listSearcher = createListSearch(NaturalComparator.instance);
		_list = new ArrayList();
		_list.add(1);
		_list.add(3);
		_list.add(5);
		_list.add(7);
	}
	
	protected void tearDown() throws Exception
	{
		_listSearcher = null;
		_list.clear();
	}

	protected abstract ListSearcher createListSearch(Comparator comparator);
	
	public void testSearchForExistingValues()
	{
		int pos = _listSearcher.search(_list, 3);
		assertEquals(pos,1);
		Util.log(_listSearcher, "testSearchForExistingValues() success"); 
	}
	
	public void testSearchForNoExistingGreatThanLastItem()
	{
		int pos = _listSearcher.search(_list, 9);
		assertEquals(pos, -5);
		Util.log(_listSearcher, "testSearchForNoExistingGreatThanLastItem() success"); 
	}
	
	public void testSearchForNoExistingLessThanFirstItem()
	{
		int pos = _listSearcher.search(_list, 0);
		assertEquals(pos, -1);
		Util.log(_listSearcher, "testSearchForNoExistingLessThanFirstItem() success"); 
	}
	
	public void testSearchForNoExistingInMiddle()
	{
		int pos = _listSearcher.search(_list, 4);
		assertEquals(pos, -3);
		Util.log(_listSearcher, "testSearchForNoExistingInMiddle() success"); 
	}
}
