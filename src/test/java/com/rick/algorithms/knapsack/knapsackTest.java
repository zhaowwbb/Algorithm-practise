package com.rick.algorithms.knapsack;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.rick.algorithms.util.Util;

public class knapsackTest extends TestCase {

	private KnapSack _instance;
	
	public void setUp() throws Exception
	{
		_instance = new KnapSack();
	}
	
	public void testGetSubSet1()
	{
		int[] array = {2,5,3,4,1,6,9,7,8};
		int sum = 7;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		assertTrue(list.size() == 5);
		List<String> target = new ArrayList<String>();		
		target.add("124");
		target.add("16");
		target.add("25");
		target.add("34");
		target.add("7");
		List<String> src = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
		{
			List<Integer> set = list.get(i);
			List<Integer> values = new ArrayList<Integer>();
			for(int j = 0; j < set.size(); j++)
			{
				values.add(array[set.get(j)]);
			}
			Collections.sort(values);
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < values.size(); j++)
			{
				sb.append(values.get(j));
			}
			src.add(sb.toString());
		}
		Collections.sort(src);
		for(int i = 0; i < src.size(); i++)
		{
			assertTrue(src.get(i).equals(target.get(i)));
		}
		Util.log(_instance, "testGetSubSet1() success"); 
	}

	public void testGetSubSet2()
	{
		int[] array = {11,8,7,5, 6};
		int sum = 20;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		assertTrue(list.size() == 1);
		List<Integer> subSet = list.get(0);
		for(int i = 0; i < subSet.size(); i++)
		{
			subSet.set(i, array[subSet.get(i)]);
		}
		Collections.sort(subSet);
		assertTrue(subSet.get(0).equals(5));
		assertTrue(subSet.get(1).equals(7));
		assertTrue(subSet.get(2).equals(8));
		Util.log(_instance, "testGetSubSet2() success"); 
	}
	
	public void testGetSubSet3()
	{
		int[] array = {-7, -3, -2, 5, 8};
		int sum = 0;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		assertTrue(list.size() == 1);
		List<Integer> subSet = list.get(0);
		for(int i = 0; i < subSet.size(); i++)
		{
			subSet.set(i, array[subSet.get(i)]);
		}
		Collections.sort(subSet);
		assertTrue(subSet.get(0).equals(-3));
		assertTrue(subSet.get(1).equals(-2));
		assertTrue(subSet.get(2).equals(5));
		
		Util.log(_instance, "testGetSubSet3() success"); 
	}
	
	public void testSubsetSum()
	{
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = set.length;
		if (_instance.isSubsetSum(set, n, sum) == true)
			Util.log("Found a subset with given sum");
		  else
			  Util.log("No subset with given sum");
		Util.log(_instance, "testSubsetSum() success"); 
	}
}
