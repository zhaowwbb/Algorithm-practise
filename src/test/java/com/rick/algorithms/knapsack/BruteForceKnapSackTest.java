package com.rick.algorithms.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForceKnapSackTest extends AbstractKnapSackTest {
	private BruteForceKnapSack _instance = new BruteForceKnapSack();
	protected WeightKnapSack createInstance() {
		return new BruteForceKnapSack();
	}

//	public void testGetAllSubList()
//	{
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);	
//		List<List<Integer>> result = _instance.getAllSubList(list);
//		assertTrue(result.size() == 8);
//		list.add(4);
//		result = _instance.getAllSubList(list);
//		assertTrue(result.size() == 16);
//	}
	
//	public void testGetOptimalSubsetThree()
//	{
//		int val[] = {150,35,200,200,200,
//				60,60,60,60,45,
//				45,45,60,60,60,
//				40,40,40,30,10,
//				10,10,70,30,15,
//				15,10,10,40,70,
//				75,80,20,12,12,
//				50,10,10};
//		int wt[] =  {9  ,13,153,153,153,
//				50,50,15,15,68,
//				68,68,27,27,27,
//				39,39,39,23,52,
//				52,52,11,32,24,
//				24,48,48,73,42,
//				43,22,7 ,18,18,
//				4,30,30};
//		int w = 400;
//		
//		long startTime = System.currentTimeMillis();
//		List<Integer> list = _instance.getOptimalSubset(val, wt, w);
//		long usedTime = System.currentTimeMillis() - startTime;
//		System.out.println("BruteForceKnapSack case 3 spend:" + usedTime);
//		
//		printList(list);			
//		Collections.sort(list);
//		assertTrue(list.size() == 14);
//		List<Integer> targetList = new ArrayList<Integer>();
//		targetList.add(0);
//		targetList.add(1);
//		targetList.add(2);
//		targetList.add(7);
//		targetList.add(8);
//		targetList.add(12);
//		targetList.add(13);
//		targetList.add(14);
//		targetList.add(18);		
//		targetList.add(22);
//		
//		targetList.add(30);
//		targetList.add(31);
//		targetList.add(32);
//		targetList.add(35);
//		for(int i = 0; i < list.size(); i++)
//		{
//			assertTrue(val[list.get(i)] == val[targetList.get(i)]);
//		}
//	}	
}
