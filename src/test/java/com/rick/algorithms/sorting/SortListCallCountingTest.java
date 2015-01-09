package com.rick.algorithms.sorting;

import com.rick.algorithms.bsearch.IterativeBinaryListSearcher;
import com.rick.algorithms.bsearch.ListSearcher;
import com.rick.algorithms.sorting.NaturalComparator;
import com.rick.algorithms.sorting.Comparator;
import com.rick.algorithms.sorting.CallCountingComparator;
import com.rick.algorithms.sorting.QuicksortListSorter;
import com.rick.algorithms.sorting.ShellsortListSorter;
import com.rick.algorithms.sorting.BubbleSortListSorter;
import com.rick.algorithms.sorting.MergesortListSorter;
import com.rick.algorithms.sorting.HeapsortListSorter;
import com.rick.algorithms.sorting.ListSorter;
import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import com.rick.algorithms.util.Util;

public class SortListCallCountingTest extends TestCase {

	private ListSearcher _listSearcher;
	private List _list;
	private static final int TEST_SIZE = 1024; 
	
	public SortListCallCountingTest()
	{
		
	}
	
	protected void setUp() throws Exception
	{
		Comparator comparator = new CallCountingComparator(NaturalComparator.instance);
		_listSearcher = new IterativeBinaryListSearcher(comparator);
		_list = new ArrayList();
		Map map = new HashMap();
		for(int i = 0; i < TEST_SIZE; i++)
		{
			map.put(i, i);
		}
		for(Iterator it = map.keySet().iterator();it.hasNext();)
		{
			_list.add(it.next());
		}
		
	}
	
	protected void tearDown() throws Exception
	{
		
	}
	
	private void beforeSort(ListSorter listSorter, List list)
	{
		Util.log("-----------------------------------------");
		Util.log( listSorter.getClass().getName() + ": Sort " + list.size() + " items");		
	}

	private void afterSort(ListSorter listSorter, CallCountingComparator comparator)
	{
		Util.log( listSorter.getClass().getName() + ": Total comparation " + comparator.getCallCount());		
	}
	
	public void testQuickSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new QuicksortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}
	
	public void testSHELLSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new ShellsortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}

	public void testHeapSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new HeapsortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}
	
	public void testBubbleSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new BubbleSortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}

	public void testInsertionSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new InsertionSortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}
	
	public void testSelectionSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new SelectionSortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}
	
	public void testMergeSortCallCount()
	{
		CallCountingComparator comparator = new CallCountingComparator(NaturalComparator.instance);
		ListSorter listSorter = new MergesortListSorter(comparator);
		beforeSort(listSorter, _list);
		listSorter.sort(_list);
		afterSort(listSorter, comparator);
	}
}
