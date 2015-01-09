package com.rick.algorithms.sorting;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import com.rick.algorithms.util.Util;

public abstract class AbstractListSorterTestCase extends TestCase {

	private List unsortedList = null;
	private List sortedList = null;
	private List unsortedASCList = null;
	private List unsortedDSCList = null;
	
	private final int[] unsortedArray = {6,5,3,1,8,7,2,4};
	private final int[] sortedArray   = {1,2,3,4,5,6,7,8};
	private final int[] ascArray      = {1,2,3,4,5,6,7,8};
	private final int[] dscArray      = {8,7,6,5,4,3,2,1};
	
	public AbstractListSorterTestCase() {

	}
	
	private List createList(int[] array)
	{
		List list = new ArrayList();
		for(int i = 0; i < array.length; i++)list.add(array[i]);
		return list;
	}
	
	protected void setUp() throws Exception
	{
		unsortedList = createList(unsortedArray);
		sortedList = createList(sortedArray);
		unsortedASCList = createList(ascArray);
		unsortedDSCList = createList(dscArray);
	}
	
	protected void tearDown() throws Exception
	{
		sortedList = null;
		unsortedList = null;
		unsortedASCList = null;
		unsortedDSCList = null;
	}

	protected abstract ListSorter createListSorter(Comparator comparator);	
	
	public void testListSorterCanSortSampleList()
	{
		Util.log("-----------------------------------------");
		ListSorter sorter = createListSorter(NaturalComparator.instance);
		Util.log(sorter.getClass().getName());
		Util.log("For Unsorted List:");
		Util.printList(unsortedList, "Before");		
		List list = sorter.sort(unsortedList);
		Util.printList(list, "After ");
		assertEquals(sortedList, list);
		
		Util.log("For sorted List:");
		Util.printList(unsortedASCList, "Before");			
		list = sorter.sort(unsortedASCList);
		Util.printList(list, "After ");		
		assertEquals(sortedList, list);
		
		Util.log("For decending sorted List:");
		Util.printList(unsortedDSCList, "Before");	
		list = sorter.sort(unsortedDSCList);
		Util.printList(list, "After ");				
		assertEquals(sortedList, list);
		Util.log(sorter, "testListSorterCanSortSampleList() success"); 
	}
}
