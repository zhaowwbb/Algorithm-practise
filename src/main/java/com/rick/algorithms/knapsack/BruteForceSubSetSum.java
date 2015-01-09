package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.ArrayList;

import com.rick.algorithms.util.Util;

public class BruteForceSubSetSum implements SubSetSum {
	private int  count = 0;
	
	public BruteForceSubSetSum() {

	}

	public List<List<Integer>> getSubSet(int[] array, int sum) {
		if(null == array || 0 == array.length)return null;
		count = 0;
		boolean[] flags = new boolean[array.length];
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		subSet(array, array.length - 1, sum, flags, result);
		Util.log("BruteForceSubSetSum count:" + count);
		return result;
	}

	public void subSet(int[] array, int n, int sum, boolean[] flags, List<List<Integer>> result)
	{
		if(n < 0)
		{
			count++;
			int total = 0;
			int i = 0;
			for(; i < flags.length; i++)
			{
				if(flags[i])
				{
					total+=array[i];
					if(total > sum)break;
				}
			}
			if(i == flags.length && total == sum)
			{
				List<Integer> set = new ArrayList<Integer>();
				i = 0;
				for(; i < flags.length; i++)
				{
					if(flags[i])
					{
						set.add(i);
					}
				}
				if(set.size() > 0)
				{
					result.add(set);
				}				
			}
		}
		else
		{
			flags[n] = true;
			subSet(array, n - 1, sum, flags, result);
			flags[n] = false;	
			subSet(array, n - 1, sum, flags, result);
		}
	}
}
