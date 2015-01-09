package com.rick.algorithms.knapsack;


public abstract class AbstractKnapSack implements WeightKnapSack {

	protected void verifyInput(int[] val, int[] wt, int w)
	{
		assert val != null : "value array can't be null";
		assert wt != null : "weight array can't be null";
		assert val.length == wt.length : "value array and weight array must be same length";
	}

}
