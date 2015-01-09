package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.ArrayList;

import com.rick.algorithms.util.Util;

public class DPSubSetSum implements SubSetSum {

	public DPSubSetSum() {

	}
	
	private void sort(int[] array)
	{
		List<Integer> list = mergeSort(array, 0, array.length - 1);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			sb.append("[").append(list.get(i)).append("]");
			array[i] = list.get(i);
		}
		Util.log("SubSetSum Sort:" + sb.toString());
	}
	
	private List<Integer> mergeSort(int[] array, int start, int end)
	{
		List<Integer> list = new ArrayList<Integer>();
		if(start == end)
		{
			list.add(array[start]);
		}
		else
		{
			int mid = start + (end - start)/2;
			List<Integer> left = mergeSort(array, start, mid);
			List<Integer> right = mergeSort(array, mid + 1, end);
			list = merge(left, right);
		}		
		
		return list;
	}
	
	private List<Integer> merge(List<Integer> left, List<Integer> right)
	{
		int lPos = 0;
		int rPos = 0;
		List<Integer> list = new ArrayList<Integer>();
		while(lPos < left.size() || rPos < right.size())
		{
			if(lPos == left.size())
			{
				list.add(right.get(rPos++));
			}
			else if(rPos == right.size())
			{
				list.add(left.get(lPos++));
			}
			else
			{
				if(left.get(lPos) < right.get(rPos))
				{
					list.add(left.get(lPos++));
				}
				else
				{
					list.add(right.get(rPos++));
				}
			}
		}
		return list;
	}
	
	public List<List<Integer>> getSubSet(int[] array, int sum) {
		if(null == array || 0 == array.length)return null;
		sort(array);
		List<List<Integer>> list = null;
		if(array[0] >= 0)
		{
			int i = array.length - 1;
			while(i >= 0)
			{
				if(array[i] > sum)
				{
					i--;
				}
				else
				{
					break;
				}
			}
			
			int[] newArray = new int[i+1];
						
			for(int j = 0;j < newArray.length; j++)
			{
				newArray[j] = array[j];
			}
			boolean[][] matrix = getMatrix(newArray, sum);
			list = getList(newArray, matrix, sum);
			
//			boolean[][] matrix = getMatrix(array, sum);
//			list = getList(array, matrix, sum);
		}
		else
		{
			int[] newArray = new int[array.length];
			for(int i = 0; i < array.length; i++)
			{
				newArray[i] = array[i] - array[0];
			}
			int newSum = sum - array[0];
			boolean[][] matrix = getMatrix(newArray, newSum);
			list = getList(newArray, matrix, newSum);
		}
		
		return list;
	}
	
	public boolean[][] getMatrix(int[] array, int sum)
	{
		boolean[][] matrix = new boolean[sum + 1][array.length + 1];
		
		for(int i = 0; i <= array.length; i++)
			matrix[0][i] = true;
		for(int i = 1; i <= sum; i++)
			matrix[i][0] = false;
		for(int i = 1; i <= sum; i++)
		{
			for(int j = 1; j <= array.length; j++)
			{
				matrix[i][j] = matrix[i][j-1];
				if(i >= array[j - 1])
				{
					matrix[i][j] = matrix[i][j] || matrix[i - array[j - 1]][j-1];
				}
//				matrix[i][j] = Math.max(matrix[i][j-1], matrix[i][j-1])
			}
		}
		printMatrix(array, matrix, sum);
		return matrix;
	}
	
	private void printMatrix(int[] array, boolean[][] matrix, int sum)
	{
		Util.log("Output SubsetSum array");
		StringBuffer sbb = new StringBuffer();
		 
		sbb.append("row").append("\t").append("[]").append("\t");
       for (int k = 0; k < array.length; k++)
       {
    	   sbb.append(array[k]).append("\t");
       }
       Util.log(sbb.toString());
	     
	     for (int i = 0; i <= sum; i++)
	     {
	    	 StringBuffer sb = new StringBuffer();
	    	 sb.append(i).append("\t");
		       for (int j = 0; j <= array.length; j++)
		       {
		    	   sb.append(matrix[i][j]).append("\t");
		       }
		       Util.log(sb.toString());

	     } 		
	}
	
	public List<List<Integer>> getList(int[] array, boolean[][] matrix, int sum)
	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] flags = new boolean[array.length + 1];
		find(array, matrix, flags, array.length, sum, result);

		return result;
	}
	
	public void find(int[] array, boolean[][] matrix, boolean[] flags, int n, int w, List<List<Integer>> result)
	{
		if(w < 0)return;
		if(w == 0)
		{
			//add to list
			List<Integer> set = new ArrayList<Integer>();
			for(int i = 1; i < flags.length; i++)
			{
				if(flags[i])
				{
					set.add(i - 1);
				}
				
			}
			if(set.size() > 0)
			{
				result.add(set);
			}			
		}
		else
		{
			if(matrix[w][n])
			{
				flags[n] = true;
				find(array, matrix, flags, n - 1, w - array[n-1], result);
				flags[n] = false;
				find(array, matrix, flags, n - 1, w, result);				
			}

		}
	}

}
