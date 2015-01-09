package com.rick.algorithms.knapsack;

import java.util.ArrayList;
import java.util.List;
import com.rick.algorithms.util.Util;

public class DPBottomUpKnapSack extends AbstractKnapSack {

	public DPBottomUpKnapSack() {

	}

	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w) {
		verifyInput(val, wt, w);
		int[][] matrix = getSolutionMatrix(val, wt, w);
		List<Integer> list = getOptimalSubset(matrix, wt);
		return list;
	}
	
	int[][] getSolutionMatrix(int[] val, int[] wt, int maxWeight)
	{
		int rows = val.length;
		int cols = maxWeight;
		int[][] matrix = new int[rows + 1][cols + 1];
		
		for(int i = 0; i < rows; i++)matrix[i][0] = 0;
		for(int i = 0; i < cols; i++)matrix[0][i] = 0;
		
		for(int i = 1; i <= rows; i++)
		{
			for(int j = 1; j <= cols; j++)
			{
				if(j >= wt[i-1])
				{
					matrix[i][j] = Math.max(matrix[i-1][j], val[i-1] + matrix[i-1][j-wt[i-1]]);
				}
				else
				{
					matrix[i][j] = matrix[i-1][j];
				}
			}
		}
		Util.printMatrix(matrix);
		return matrix;
	}
	
	List<Integer> getOptimalSubset(int[][] matrix, int[] wt)
	{
		List<Integer> list = new ArrayList<Integer>();
		int row = matrix.length - 1;
		int col = matrix[0].length - 1;
		while(row >0 && col > 0)
		{
			int previousVal = matrix[row-1][col];
			if(previousVal != matrix[row][col])
			{
				row--;
				list.add(row);
				col = col - wt[row];
			}
			else
			{
				row--;
			}
		}
		
		return list;
	}
}
