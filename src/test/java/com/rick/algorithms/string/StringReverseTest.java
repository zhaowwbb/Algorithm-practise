package com.rick.algorithms.string;

import junit.framework.TestCase;

public class StringReverseTest extends TestCase {
	private StringReverse stringReverseUtil = new StringReverse();
	private final String src = "ABCD";
	private final String dst = "DCBA";	
	protected void setUp() throws Exception
	{
		
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testReverse(){
		assertEquals(stringReverseUtil.reverse(src), dst);
	}

	public void testRecursiveReverse(){
		String str = stringReverseUtil.recursiveReverse(src);
		System.out.println("Recursive reverse string = " + str);
		assertEquals(str, dst);
	}
}
