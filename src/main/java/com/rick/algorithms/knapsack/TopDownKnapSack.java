package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.rick.algorithms.util.Util;

public class TopDownKnapSack extends AbstractKnapSack {
	private int[] values;
	private int[] weights;
	private boolean[] flags;
	private int maxValue;
	private int totalWeight;
	private List<Integer> list = new ArrayList<Integer>();
	private Map<Integer, List<Integer>> listCache = new HashMap<Integer, List<Integer>>();
	private Map<Integer, Integer> maxValueCache = new HashMap<Integer, Integer>();
	
	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w) {
		verifyInput(val, wt, w);
		this.values = val;
		this.weights = wt;
		this.flags = new boolean[values.length];
		this.maxValue = Integer.MIN_VALUE;
		this.totalWeight = w;
		this.listCache.clear();
		this.maxValueCache.clear();
		
		int v = knapSack(val.length - 1, w);
//		System.out.println("maxValue=" + v);
//		printList(list);
		return list;
	}

//	private List<Integer> getList()
//	{
//		this.list.clear();
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < flags.length; i++)
//		{
//			if(flags[i])
//			{
////				sb.append("{pos=").append(i).append(",val=");
////				sb.append(values[i]).append(",weight=");
////				sb.append(weights[i]).append("}");
//				list.add(i);
//				sb.append("[").append(i).append("]");
//			}
//		}
////		System.out.println("Max value:" + maxValue + "," + sb.toString());
//		System.out.println("List=" + sb.toString());
//		return this.list;
//	}
	
	private void calculate()
	{
		List<Integer> subSet = new ArrayList<Integer>();
		int sum = 0;
		int weight = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < flags.length; i++)
		{
			if(flags[i])
			{
				subSet.add(i);
				sum += values[i];
				weight += weights[i];
				sb.append("[").append(i).append("]");
			}
		}
//		System.out.println("maxValue=" + maxValue + ",sum=" + sum + ",weight=" + weight + ",List=" + sb.toString());
		if(weight <= totalWeight)
		{
			if(this.maxValue < sum)
			{
//				System.out.println(" [X]maxValue=" + maxValue + ",sum=" + sum + ",weight=" + weight + ",List=" + sb.toString());
				maxValue = sum;
				list = subSet;
//				System.out.println("sum=" + sum + ",weight=" + weight + ",List=" + sb.toString());
			}			
		}
		else
		{
			Util.log("[Skip]sum=" + maxValue + ",weight=" + weight + ",List=" + sb.toString());
		}

//		System.out.println("List=" + sb.toString());
	}
	
	
	private int knapSack(int n, int w)
	{
		if(n < 0)
		{
			return 0;
		}

		int ret = 0;
//		if(maxValueCache.containsKey(w))
//		{
//			return maxValueCache.get(w).intValue();
//		}
		
		if(weights[n] > w)
		{
			ret = knapSack(n - 1, w);
		}
		else
		{	
			flags[n] = true;
			calculate();
			int curVal = values[n] + knapSack(n - 1, w - weights[n]);
			
			flags[n] = false;
			calculate();
			int lastVal = knapSack(n - 1, w);
						
			ret = (lastVal > curVal) ? lastVal : curVal;
//			maxValueCache.put(w, ret);
		}
		
		return ret;
	}
}
