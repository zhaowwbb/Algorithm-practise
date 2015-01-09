package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.Collections;
import junit.framework.TestCase;
import com.rick.algorithms.util.Util;

public abstract class AbstractKnapSackTest extends TestCase {
	private WeightKnapSack instance;

	public void setUp() throws Exception{
		instance = createInstance();
	}
	
	protected abstract WeightKnapSack createInstance();
	
	public void testGetOptimalSubsetOne()
	{
		int val[] = {10, 40, 30, 50};
		int wt[] = {5, 4, 6, 3};
		int w = 10;	
		
		List<Integer> list = instance.getOptimalSubset(val, wt, w);
		Util.printList(list, "OptimalSubset");		
		assertTrue(list.size() == 2);	
		Collections.sort(list);
		assertTrue(list.get(0).equals(1));
		assertTrue(list.get(1).equals(3));
		Util.log(instance, "testGetOptimalSubsetOne() success"); 
	}
	
	public void testGetOptimalSubsetTwo()
	{
		int val[] = {7,4,8,6,2,5};
		int wt[] = {2,3,5,4,2,3};
		int w = 9;
		
		List<Integer> list = instance.getOptimalSubset(val, wt, w);
		
		Util.printList(list, "OptimalSubset");			
		Collections.sort(list);
		assertTrue(list.size() == 3);	
		assertTrue(list.get(0).equals(0));
		assertTrue(list.get(1).equals(3));
		assertTrue(list.get(2).equals(5));
		Util.log(instance, "testGetOptimalSubsetTwo() success"); 
	}
}
