package com.rick.algorithms.sorting;

public class BubbleSortListSorterTest extends AbstractListSorterTestCase {

	protected ListSorter createListSorter(Comparator comparator) {		
		return new BubbleSortListSorter(comparator);
	}
	
	private void printLog(int[] array){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < array.length; i++){
			sb.append("[").append(array[i]).append("]");			
		}
		System.out.println("array=" + sb.toString());
	}
	
	public void testBubbleSort(){
		int[] unsorted = {32, 39,21, 45, 23, 3};
		printLog(unsorted);
		BubbleSortListSorter sorter = new BubbleSortListSorter();
		sorter.bubbleSort(unsorted);
		printLog(unsorted);
		assertTrue(unsorted[0] == 3);
		assertTrue(unsorted[1] == 21);
		assertTrue(unsorted[2] == 23);
		assertTrue(unsorted[3] == 32);
		assertTrue(unsorted[4] == 39);
		assertTrue(unsorted[5] == 45);
	}

}
