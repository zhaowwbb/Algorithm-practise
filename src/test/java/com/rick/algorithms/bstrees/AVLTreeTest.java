package com.rick.algorithms.bstrees;

import junit.framework.TestCase;

public class AVLTreeTest extends TestCase {

	public AVLTreeTest() {
		// TODO Auto-generated constructor stub
	}

	public AVLTreeTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void test1()
	{
		AVLTree<Integer> tree = new AVLTree<Integer>();
		int[] array = {6,5,3,1,8,7,2,4};
		for(int i = 0; i < array.length; i++)
		{
			tree.add(array[i]);
		}
		
		System.out.println("tree=" + tree);
	}

}
