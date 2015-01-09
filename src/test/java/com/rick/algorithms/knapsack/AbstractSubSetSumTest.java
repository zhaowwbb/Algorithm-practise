package com.rick.algorithms.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;
import com.rick.algorithms.util.Util;

public abstract class AbstractSubSetSumTest extends TestCase {

	protected SubSetSum _instance;

	public abstract SubSetSum getInstance();
	
	public void setUp() throws Exception
	{
		_instance = getInstance();
	}
	
	protected void printList(List list, int[] array)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			List<Integer> set = (List<Integer>)list.get(i);
			sb.append("{");
			for(int j = 0; j < set.size(); j++)
			{
				sb.append("[").append(array[set.get(j)]).append("]");
			}
			sb.append("} ");
		}
		Util.log("SubSetSum:=" + sb.toString());
	}
	
	public void testGetSubSet1()
	{
		int[] array = {2,5,3,4,1,6,7,8,9};
		int sum = 7;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		printList(list, array);
		assertTrue(list.size() == 5);
		List<String> target = new ArrayList<String>();
		target.add("124");
		target.add("16");
		target.add("25");
		target.add("34");
		target.add("7");
		List<String> src = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
		{
			List<Integer> set = list.get(i);
			List<Integer> values = new ArrayList<Integer>();
			for(int j = 0; j < set.size(); j++)
			{
				values.add(array[set.get(j)]);
			}
			Collections.sort(values);
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < values.size(); j++)
			{
				sb.append(values.get(j));
			}
			src.add(sb.toString());
		}
		Collections.sort(src);
		for(int i = 0; i < src.size(); i++)
		{
			assertTrue(src.get(i).equals(target.get(i)));
		}
		Util.log(_instance, "testGetSubSet1() success"); 
	}

	public void testGetSubSet2()
	{
		int[] array = {8,7,5,11,6};
		int sum = 20;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
		printList(list, array);
		assertTrue(list.size() == 1);
		List<Integer> subSet = list.get(0);
		for(int i = 0; i < subSet.size(); i++)
		{
			subSet.set(i, array[subSet.get(i)]);
		}
		Collections.sort(subSet);
		assertTrue(subSet.get(0).equals(5));
		assertTrue(subSet.get(1).equals(7));
		assertTrue(subSet.get(2).equals(8));
		Util.log(_instance, "testGetSubSet2() success"); 
	}
	

	
	private List<String> getCase3Data()
	{
		String[] strs = {
				"[7][21]",
				"[1][6][21]",
				"[2][5][21]",
				"[3][4][21]",
				"[1][2][4][21]",
				"[6][22]",
				"[1][5][22]",
				"[2][4][22]",
				"[1][2][3][22]",
				"[5][23]",
				"[1][4][23]",
				"[2][3][23]",
				"[4][24]",
				"[1][3][24]",
				"[3][25]",
				"[1][2][25]",
				"[2][26]",
				"[1][27]",
				"[28]",
				"[1][2][3][4][5][6][7]"
		};
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < strs.length; i++)
		{
			list.add(strs[i]);
		}
		Collections.sort(list);
		return list;
	}
	
	public List<String> convertData(List<List<Integer>> list, int[] array)
	{
		List<String> targets = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
		{
			List<Integer> set = list.get(i);
			List<Integer> subSet= new ArrayList<Integer>();
			for(int j = 0; j < set.size(); j++)
			{
				subSet.add(array[set.get(j)]);				
			}
			Collections.sort(subSet);			

			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < subSet.size(); j++)
			{
				sb.append("[").append(subSet.get(j)).append("]");				
			}
			targets.add(sb.toString());
		}
		Collections.sort(targets);
		return targets;
	}
	
	private void printData(List<List<Integer>> list, int[] array)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("String[] strs = {\n");
		for(int i = 0; i < list.size(); i++)
		{
			List<Integer> set = list.get(i);
			List<Integer> subSet= new ArrayList<Integer>();
			for(int j = 0; j < set.size(); j++)
			{
				subSet.add(array[set.get(j)]);				
			}
			Collections.sort(subSet);
			sb.append("		\"");
			for(int j = 0; j < subSet.size(); j++)
			{
				sb.append("[").append(subSet.get(j)).append("]");				
			}
			sb.append("\",\n");
		}	
		sb.append("};");
		Util.log(sb.toString());
	}
	
	public void testGetSubSet3()
	{
		int[] array = {1, 2, 3, 4, 5, 6, 7, 28, 27, 26, 25, 24, 23, 22, 21};
		int sum = 28;
		List<List<Integer>> list = _instance.getSubSet(array, sum);
//		printData(list,array);
		List<String> src = getCase3Data();
		List<String> dst = convertData(list, array);
		assertTrue(src.size() == dst.size());
		for(int i = 0; i < src.size(); i++)
		{
			assertEquals(src.get(i), dst.get(i));
		}
		
//		System.out.println("size =" + list.size());
		printList(list, array);
		Util.log(_instance, "testGetSubSet3() success"); 
	}
}
