package com.rick.algorithms.list;

import junit.framework.TestCase;

public class FindMiddleElementTest extends TestCase{
	private FindMiddleElement finder = new FindMiddleElement();
	private SingleLinkedNode list1 = null; 
	private SingleLinkedNode list2 = null; 
	private SingleLinkedNode emptyList = null; 
	private SingleLinkedNode oneElementList = null; 
	private String list1MiddleItem = null; 
	private String list2MiddleItem = null; 
	private String oneElementListMiddleItem = null; 
	
	protected void setUp() throws Exception
	{
		list1 = new SingleLinkedNode(String.valueOf(1));
		SingleLinkedNode node = null;
		SingleLinkedNode prevNode = null;
		prevNode = list1;
		//9 items
		for(int i = 2; i < 10; i++){
			node = new SingleLinkedNode(String.valueOf(i));
			prevNode.setNext(node);
			prevNode = node;
		}
		list1MiddleItem = new String(String.valueOf(5));
		
		list2 = new SingleLinkedNode(String.valueOf(1));
		prevNode = list2;
		//10 items
		for(int i = 2; i <= 10; i++){
			node = new SingleLinkedNode(String.valueOf(i));
			prevNode.setNext(node);
			prevNode = node;
		}
		list2MiddleItem = new String(String.valueOf(5));
		//1 item
		oneElementList = new SingleLinkedNode(String.valueOf(1));
		oneElementListMiddleItem = new String(String.valueOf(1));
		super.setUp();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testFindMiddleNormal(){
		String obj = null;
		obj = finder.findMiddleNormal(emptyList);
		assertEquals(obj, null);
		
		obj = finder.findMiddleNormal(list1);
		assertEquals(obj, list1MiddleItem);
		
		obj = finder.findMiddleNormal(list2);
		assertEquals(obj, list2MiddleItem);	
		
		obj = finder.findMiddleNormal(oneElementList);
		assertEquals(obj, oneElementListMiddleItem);			
	}
	
	public void testFindMiddleQuick(){
		String obj = null;
		obj = finder.findMiddleQuick(emptyList);
		assertEquals(obj, null);
		
		obj = finder.findMiddleQuick(oneElementList);
		assertEquals(obj, oneElementListMiddleItem);			
		
		obj = finder.findMiddleQuick(list1);
		assertEquals(obj, list1MiddleItem);
		
		obj = finder.findMiddleQuick(list2);
		assertEquals(obj, list2MiddleItem);	
		

	}
}
