package com.rick.algorithms.trietree;

import java.util.HashSet;
import java.util.Set;

import com.rick.algorithms.util.Util;

import junit.framework.TestCase;


public class WordSearchUtilityTest extends TestCase {
	private WordSearchUtility utility;
	
	public void setUp() throws Exception
	{
		utility = new WordSearchUtility();
	}
	
	public void testIsValid()
	{
		assertTrue(utility.isValid("abc", 0, 0));
		assertTrue(utility.isValid("aMcZk", 0, 0));
		assertTrue(utility.isValid("a1c", 0, 0) == false);
		assertTrue(utility.isValid("aMc@Zk", 0, 0) == false);
		Util.log(utility, "testIsValid() success"); 
	}

	public void testCalculateDiagonals()
	{
		char[][] array =
			{
				{'A','B','C','D','E'},
				{'F','G','H','I','J'},
				{'K','L','M','N','O'},
				{'P','Q','R','S','T'}
			};
		Set<String> set = new HashSet<String>();
//		System.out.println("calculateDiagonals():");
		utility.calculateDiagonals(set, array);
//		System.out.println("calculateColumns():");
		utility.calculateColumns(set, array);
		
		Util.log(utility, "testCalculateDiagonals() success"); 
	}
}
