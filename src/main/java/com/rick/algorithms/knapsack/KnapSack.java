package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.ArrayList;
import com.rick.algorithms.util.Util;

public class KnapSack {

	public KnapSack() {

	}
	
	public List<List<Integer>> getSubSet(int[] array, int sum)
	{
		if(null == array)return null;
		boolean[] flags = new boolean[array.length];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < array.length; i++)
		{
			flags[i] = true;
			getSubSet(list, flags, array, i+1, sum - array[i]);
			flags[i] = false;
		}
		isSubsetSum(array, array.length, sum);
		return list;
	}
	
	private List<Integer> getList(boolean[] flags, int[] array)
	{
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < flags.length; i++)
		{
			if(flags[i])
			{
				sb.append("[").append(array[i]).append("]");
				list.add(i);
			}		
		}
		Util.log("Found:" + sb.toString());
		return list;
	}
	
	private void getSubSet(List<List<Integer>> list, boolean[] flags, int[] array, int n, int sum)
	{		
		if(sum == 0)
		{
			list.add(getList(flags, array));
		}
		if(n >= array.length)return;
		for(int i = n; i < array.length; i++)
		{
			flags[i] = true;
			getSubSet(list, flags, array, i+1, sum - array[i]);
			flags[i] = false;				
		}
	}

	private void verifyInput(int[] val, int[] wt, int w)
	{
		assert val != null : "value array can't be null";
		assert wt != null : "weight array can't be null";
		assert val.length == wt.length : "value array and weight array must be same length";
	}
	
	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w)
	{
		verifyInput(val, wt, w);
		return getOptimalSubsetDynamicProgramming(val, wt, w);
	}
	
	public List<Integer> getOptimalSubsetBruteForce(int[] val, int[] wt, int w)
	{
		verifyInput(val, wt, w);
		int maxValue = Integer.MIN_VALUE;
		List<Integer> subSet = new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < wt.length; i++)
		{
			list.add(wt[i]);
		}
		List<List<Integer>> result = getAllSubList(list);
		for(int i = 0; i < result.size(); i++)
		{
			int value = 0;
			int weight = 0;
			List<Integer> subList = result.get(i);
			for(int j = 0; j < subList.size(); j++)
			{
				value += val[subList.get(j)];
				weight += wt[subList.get(j)];
				if(weight > w)break;
			}
			if(weight < w && value > maxValue)
			{
				subSet = subList;
				maxValue = value;
			}
		}
		return subSet;
	}
	
//	int getMaxWeight(int[] wt)
//	{
//		int max = 0;
//		for(int i = 0; i < wt.length; i++)
//		{
//			if(wt[i] <= 0){
//				throw new IllegalArgumentException("Element in Weight array must > 0");
//			}
//			if(wt[i] > max)
//			{
//				max = wt[i];
//			}
//		}
//		return max;
//	}
	
	public List<Integer> getOptimalSubsetDynamicProgramming(int[] val, int[] wt, int w)
	{
		verifyInput(val, wt, w);
//		int maxWeight = getMaxWeight(wt);
		int[][] matrix = getSolutionMatrix(val, wt, w);
		List<Integer> list = getOptimalSubset(matrix, wt);
		return list;
	}
	
//	private void printMatrix(int[][] matrix)
//	{
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < matrix.length; i++)
//		{
//			for(int j = 0; j < matrix[0].length; j++)
//			{
//				sb.append(matrix[i][j]).append("\t");
//			}
//			sb.append("\n");
//		}
//		System.out.println("Matrix:");
//		System.out.println(sb.toString());		
//	}
	
	int[][] getSolutionMatrix(int[] val, int[] wt, int maxWeight)
	{
		int[][] V = new int[val.length + 1][maxWeight + 1];
		for(int i = 0; i <= maxWeight; i++)
		{
			V[0][i] = 0;
		}
		for(int i = 0; i <= val.length; i++)
		{
			V[i][0] = 0;
		}
		
		for(int row = 1; row <= val.length; row++)
		{
			for(int column = 1; column <= maxWeight; column++)
			{
				if(wt[row - 1] <= column)
				{
					V[row][column] = Math.max(V[row - 1][column], 
							val[row - 1] + V[row - 1][column - wt[row - 1]]);
				}
				else
				{
					V[row][column] = V[row - 1][column];
				}
			}
		}
		Util.printMatrix(V);
		return V;
	}
	
	List<Integer> getOptimalSubset(int[][] matrix, int[] wt)
	{
		if(null == matrix || matrix.length == 0)return null;
		int row = matrix.length - 1;
		int column = matrix[0].length - 1;
		List<Integer> list = new ArrayList<Integer>();
		int current = matrix[row][column];
		int previous = current;

		while(row >0 && column > 0)
		{
			
			previous = matrix[row - 1][column];
			if(current != previous)
			{
				list.add(row - 1);
				row--;
				column-= wt[row];
				current = matrix[row][column];
			}
			else
			{
				row--;	
			}
		}
		
		return list;
	}
	
	private void getAllSubList(List<List<Integer>> result, List<Integer> list, boolean[] flags, int n)
	{
		if(n < 0)
		{
			List<Integer> subList = new ArrayList<Integer>();
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < flags.length;i++)
			{
				if(flags[i])
				{
					sb.append("[").append(i).append("]");
					subList.add(i);
				}
			}
			result.add(subList);
			Util.log("Found subList:" + sb.toString());
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
	
	public boolean isSubsetSum(int set[], int n, int sum)
	{
	    // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
	    //  with sum equal to i
		boolean[][] subset = new boolean[sum+1][n+1];
	 
	    // If sum is 0, then answer is true
	    for (int i = 0; i <= n; i++)
	      subset[0][i] = true;
	 
	    // If sum is not 0 and set is empty, then answer is false
	    for (int i = 1; i <= sum; i++)
	      subset[i][0] = false;
	 
	     // Fill the subset table in botton up manner
	     for (int i = 1; i <= sum; i++)
	     {
	       for (int j = 1; j <= n; j++)
	       {
	         subset[i][j] = subset[i][j-1];
	         if (i >= set[j-1])
	           subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
	       }
	     }
	 
	    /* // uncomment this code to print table*/
	     Util.log("Output SubsetSum array");
	     StringBuffer sbb = new StringBuffer();
	     sbb.append("row").append("\t").append("[]").append("\t");
	       for (int k = 0; k < n; k++)
	       {
	    	   sbb.append(set[k]).append("\t");
	       }
	       Util.log(sbb.toString());
	     
	     for (int i = 0; i <= sum; i++)
	     {
	    	 StringBuffer sb = new StringBuffer();
	    	 sb.append(i).append("\t");
	       for (int j = 0; j <= n; j++)
	       {
	    	   sb.append(subset[i][j]).append("\t");
	       }
	       Util.log(sb.toString());

	     } 
	 
	     return subset[sum][n];
	}
}
