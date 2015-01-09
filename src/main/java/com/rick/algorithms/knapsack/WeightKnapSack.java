package com.rick.algorithms.knapsack;

import java.util.List;

public interface WeightKnapSack {
	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w);
}
