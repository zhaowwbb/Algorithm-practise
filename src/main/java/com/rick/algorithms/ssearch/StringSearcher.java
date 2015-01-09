package com.rick.algorithms.ssearch;

public interface StringSearcher {

	/**
	 * 
	 * @param src source string
	 * @param pattern pattern to be found in src
	 * @return the position of the first occurrence of pattern string, -1 for not found
	 */
	public int search(String src, String pattern);
	
	/**
	 * 
	 * @param src source string
	 * @param pattern pattern string
	 * @return the total occurrence of pattern string
	 */
	public int findOccurrence(String src, String pattern);
	
}
