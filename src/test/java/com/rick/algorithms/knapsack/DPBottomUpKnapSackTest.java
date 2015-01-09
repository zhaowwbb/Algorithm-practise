package com.rick.algorithms.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.rick.algorithms.util.Util;

public class DPBottomUpKnapSackTest extends AbstractKnapSackTest {
	private DPBottomUpKnapSack _instance = new DPBottomUpKnapSack();

	private int val[] = {10, 40, 30, 50};
	private int wt[] = {5, 4, 6, 3};
	private int maxWeight = 10;	
	private int[][] targetMatrix = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 10, 10, 10, 10, 10, 10},
			{0, 0, 0, 0, 40, 40, 40, 40, 40, 50, 50},
			{0, 0, 0, 0, 40, 40, 40, 40, 40, 50, 70},
			{0, 0, 0, 50, 50, 50, 50, 90, 90, 90, 90}
	};
	
	
	protected WeightKnapSack createInstance() {
		return new DPBottomUpKnapSack();
	}

	public void testGetSolutionMatrix()
	{		
		int[][] matrix = _instance.getSolutionMatrix(val, wt, maxWeight);
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				assertEquals(matrix[i][j], targetMatrix[i][j]);
			}
		}
		Util.log(_instance, "testGetSolutionMatrix() success"); 
	}
	
	public void testGetOptimalSubsetThree()
	{
		int val[] = {150,35,200,200,200,
				60,60,60,60,45,
				45,45,60,60,60,
				40,40,40,30,10,
				10,10,70,30,15,
				15,10,10,40,70,
				75,80,20,12,12,
				50,10,10};
		int wt[] =  {9  ,13,153,153,153,
				50,50,15,15,68,
				68,68,27,27,27,
				39,39,39,23,52,
				52,52,11,32,24,
				24,48,48,73,42,
				43,22,7 ,18,18,
				4,30,30};
		int w = 400;
		
		List<Integer> list = _instance.getOptimalSubset(val, wt, w);
		
		Util.printList(list, "OptimalSubset");			
		Collections.sort(list);
		assertTrue(list.size() == 14);
		List<Integer> targetList = new ArrayList<Integer>();
		targetList.add(0);
		targetList.add(1);
		targetList.add(2);
		targetList.add(7);
		targetList.add(8);
		targetList.add(12);
		targetList.add(13);
		targetList.add(14);
		targetList.add(18);		
		targetList.add(22);
		
		targetList.add(30);
		targetList.add(31);
		targetList.add(32);
		targetList.add(35);
		for(int i = 0; i < list.size(); i++)
		{
			assertTrue(val[list.get(i)] == val[targetList.get(i)]);
		}
		Util.log(_instance, "testGetOptimalSubsetThree() success"); 
	}	
	
//	public void testKnapSack1()
//	{
//		System.out.println("testKnapSack1()");
//		int[] v = {1,1,1,1,1,1,1,1,1};
//		int[] w = {2,5,3,4,1,6,9,7,8};
//		int sum = 7;
//		int[][] matrix = _instance.getSolutionMatrix(v, w, sum);
//	}
}
