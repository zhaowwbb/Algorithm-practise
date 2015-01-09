package com.rick.algorithms.bsearch;

import java.util.List;
import java.util.ArrayList;
import com.rick.algorithms.sorting.NaturalComparator;

import junit.framework.TestCase;

public class ListInserterTest extends TestCase {
	private ListInserter _listInserter;
	private List _list;
	
	protected void setUp() throws Exception
	{
		_listInserter = new ListInserter(new IterativeBinaryListSearcher(NaturalComparator.instance ));
		_list = new ArrayList();
		_list.add(1);
		_list.add(3);
		_list.add(5);
	}
	
	protected void tearDown() throws Exception
	{
		_list.clear();
	}
	
	public void testInsertBeforeFirst()
	{
		_listInserter.insert(_list, 0);
		assertEquals(_list.get(0), (Object)0);
		assertEquals(_list.get(1), (Object)1);
		assertEquals(_list.get(2), (Object)3);
		assertEquals(_list.get(3), (Object)5);
	}
	
	public void testInsertAfterFirst()
	{
		_listInserter.insert(_list, 2);
		assertEquals(_list.get(0), (Object)1);
		assertEquals(_list.get(1), (Object)2);
		assertEquals(_list.get(2), (Object)3);
		assertEquals(_list.get(3), (Object)5);
	}
	
	public void testInsertSamePlace()
	{
		_listInserter.insert(_list, 3);
		assertEquals(_list.get(0), (Object)1);
		assertEquals(_list.get(1), (Object)3);
		assertEquals(_list.get(2), (Object)3);
		assertEquals(_list.get(3), (Object)5);
	}
	
	public void testInsertAfterLast()
	{
		_listInserter.insert(_list, 9);
		assertEquals(_list.get(0), (Object)1);
		assertEquals(_list.get(1), (Object)3);
		assertEquals(_list.get(2), (Object)5);
		assertEquals(_list.get(3), (Object)9);
	}
}
