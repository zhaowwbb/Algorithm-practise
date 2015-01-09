package com.rick.algorithms.ssearch;

import com.rick.algorithms.util.Util;

public class BoyerMooreStringSearcher implements StringSearcher {
	private static final int SIZE = 256;
	private int count = 0;
	private int[] array;

	public BoyerMooreStringSearcher()
	{
		this.count = 0;
		this.array = new int[SIZE];
	}
	
	@Override
	public int search(String src, String pattern) {
		int pos = -1;
		this.count = 0;
		if(null == src || null == pattern)return pos;
		compute(pattern);
		int start = 0;
		int end = src.length() - pattern.length();
		while(start <= end)
		{
			int i = pattern.length() - 1;
			char c = 0;
			count++;
			while(i >= 0 && pattern.charAt(i) == (c = src.charAt(start + i)))
			{
				i--;
			}
			if(i < 0)
			{
				pos = start;
				break;
			}
			int max = Math.max(i - array[c], 1);
//			System.out.println("[search]move:" + max);
			start += max;			
		}
		Util.log("BoyerMooreStringSearcher Found pos=" + pos + ", comparison count=" + count);
		return pos;
	}
	
	private void compute(String pattern)
	{
		for(int i = 0; i < SIZE; i++)array[i] = -1;
		for(int i = 0; i < pattern.length(); i++)
		{
			array[pattern.charAt(i)] =  i;
		}
	}

	public int findOccurrence(String src, String pattern) {
		int occurrence = 0;
		this.count = 0;
		if(null == src || null == pattern)return occurrence;
		
		int start = 0;
		int end = src.length() - pattern.length();
		compute(pattern);
		while(start <= end)
		{
			int i = pattern.length() - 1;
			count++;
			char c = 0;
			while(i >= 0 && pattern.charAt(i) == (c = src.charAt(start + i)))
			{
				i--;
			}
			if(i < 0)
			{
				occurrence++;
			}
			int max = Math.max(i - array[c], 1);
//			System.out.println("[findOccurrence]move:" + max);
			start += max;
		}
		Util.log("BoyerMooreStringSearcher() findOccurrence=" + occurrence + ", comparison count=" + count);
		return occurrence;
	}

}
