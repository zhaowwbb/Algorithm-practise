package com.rick.algorithms.knapsack;

import java.util.ArrayList;
import java.util.List;

public class BruteForceKnapSack extends AbstractKnapSack {

	private List<Integer> findResult = new ArrayList<Integer>();
	private int[] values;
	private int[] weights;
	private int W;
	private int maxValue;
	
	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w) {
		verifyInput(val, wt, w);
		findResult = new ArrayList<Integer>();
		values = val;
		weights = wt;
		W = w;
		maxValue = Integer.MIN_VALUE;
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < wt.length; i++)
		{
			list.add(wt[i]);
		}
		List<List<Integer>> result = getAllSubList(list);

		return findResult;
	}
	
	private void checkMaxSubList(boolean[] flags)
	{
		int value = 0;
		int weight = 0;
		boolean isOK = true;
		for(int i = 0; i < flags.length && isOK;i++)
		{
			if(flags[i])
			{
				value += values[i];
				weight += weights[i];
				if(weight > W)
				{
					isOK = false;
				}
			}
		}
		if(isOK && value > maxValue)
		{
			List<Integer> l = new ArrayList<Integer>();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < flags.length && isOK;i++)
			{
				if(flags[i])
				{
					l.add(i);
					sb.append("[").append(i).append("]");
				}
			}
			maxValue = value;
//			System.out.println("BruteForceKnapSack max value=" + maxValue + ",list=" + sb.toString());
			findResult = l;
		}
	}
	
	private void getAllSubList(List<List<Integer>> result, List<Integer> list, boolean[] flags, int n)
	{
		if(n < 0)
		{
			checkMaxSubList(flags);
//			List<Integer> subList = new ArrayList<Integer>();
//			StringBuilder sb = new StringBuilder();
//			for(int i = 0; i < flags.length;i++)
//			{
//				if(flags[i])
//				{
//					sb.append("[").append(i).append("]");
//					subList.add(i);
//				}
//			}
//			result.add(subList);
//			if(result.size() % 10000 == 0)
//			{
//				System.out.println("BruteForceKnapSack AllSubList size = " + result.size());
//			}
//			System.out.println("Found subList:" + sb.toString());
		}
		else
		{
			flags[n] = true;
			getAllSubList(result, list, flags, n - 1);
			flags[n] = false;
			getAllSubList(result, list, flags, n - 1);
		}
	}
	
	public List<List<Integer>> getAllSubList(List<Integer> list)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(null == list || 0 == list.size())return result;
		boolean[] flags = new boolean[list.size()];
		getAllSubList(result, list, flags, flags.length - 1);
		return result;
	}	
	
}
