package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.Collections;

import com.rick.algorithms.util.Util;

public class BruteForceSubSetSumTest extends AbstractSubSetSumTest {

	public SubSetSum getInstance() {
		return new BruteForceSubSetSum();
	}

	public void testGetSubSet4()
	{
		int[] array = {-7, -3, -2, 5, 8};
		int sum = 0;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		printList(list, array);
		assertTrue(list.size() == 1);
		List<Integer> subSet = list.get(0);
		for(int i = 0; i < subSet.size(); i++)
		{
			subSet.set(i, array[subSet.get(i)]);
		}
		Collections.sort(subSet);
		assertTrue(subSet.get(0).equals(-3));
		assertTrue(subSet.get(1).equals(-2));
		assertTrue(subSet.get(2).equals(5));
		Util.log(_instance, "testGetSubSet4() success"); 
	}
}
