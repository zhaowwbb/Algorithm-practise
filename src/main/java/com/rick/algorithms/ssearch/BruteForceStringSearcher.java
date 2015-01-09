package com.rick.algorithms.ssearch;

import com.rick.algorithms.util.Util;

public class BruteForceStringSearcher implements StringSearcher {
	private int count = 0;
	
	public BruteForceStringSearcher() {
		this.count = 0;
	}

	public int search(String src, String pattern) {
		int pos = -1;
		this.count = 0;
		if(null == src || null == pattern)return pos;
		int start = 0;
		int end = src.length();
		while(start < end)
		{
			int i = 0;
			while(i < pattern.length() && start + i < end && src.charAt(start + i) == pattern.charAt(i))
			{
				i++;
			}
			if(i == pattern.length())
			{
				pos = start;
				break;
			}
			start++;
			count++;
		}
		Util.log("BruteForceStringSearcher() Found pos=" + pos + ", comparison count=" + count);
		return pos;
	}
	
	public int findOccurrence(String src, String pattern) {
		int occurrence = 0;
		this.count = 0;
		if(null == src || null == pattern)return occurrence;
		int start = 0;
		int end = src.length() - pattern.length();
		while(start <= end)
		{
			int i = 0;
			while(i < pattern.length() && src.charAt(start + i) == pattern.charAt(i))
			{
				i++;
			}
			if(i == pattern.length())
			{
				occurrence++;
			}
			start++;
			count++;
		}
		Util.log("BruteForceStringSearcher() findOccurrence=" + occurrence + ", comparison count=" + count);
		return occurrence;
	}
}
