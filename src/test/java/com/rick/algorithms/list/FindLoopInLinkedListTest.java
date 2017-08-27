package com.rick.algorithms.list;

import junit.framework.TestCase;

public class FindLoopInLinkedListTest extends TestCase {
	
	private FindLoopInLinkedList finder = new FindLoopInLinkedList();
	private SingleLinkedNode loopLinkedList = null;
	private SingleLinkedNode noLoopLinkedList = null;
	private SingleLinkedNode oneElementLinkedList = null;
	private SingleLinkedNode nullLinkedList = null;
	
	protected void setUp() throws Exception
	{
		SingleLinkedNode a = new SingleLinkedNode("A");
		SingleLinkedNode b = new SingleLinkedNode("B");
		SingleLinkedNode c = new SingleLinkedNode("C");
		SingleLinkedNode d = new SingleLinkedNode("D");
		SingleLinkedNode e = new SingleLinkedNode("E");
		SingleLinkedNode f = new SingleLinkedNode("F");
		SingleLinkedNode g = new SingleLinkedNode("G");
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		e.setNext(f);
		f.setNext(g);
		g.setNext(a);
		
		loopLinkedList = a;
		StringBuilder sb = new StringBuilder();
		sb.append("loopLinkedList=");
		sb.append(a).append(b).append(c).append(d).append(e).append(f).append(g).append(a);
		System.out.println(sb.toString());
		
		SingleLinkedNode n1 = new SingleLinkedNode("N1");
		SingleLinkedNode n2 = new SingleLinkedNode("N2");
		SingleLinkedNode n3 = new SingleLinkedNode("N3");		
		n1.setNext(n2);
		n2.setNext(n3);
		
		noLoopLinkedList = n1;
		sb = new StringBuilder();
		sb.append("noLoopLinkedList=");
		sb.append(n1).append(n2).append(n3);
		System.out.println(sb.toString());
		
		SingleLinkedNode b1 = new SingleLinkedNode("B1");
		oneElementLinkedList = b1;
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testHasLoopNormal(){
		assertTrue(!finder.hasLoopNormal(nullLinkedList));
		assertTrue(!finder.hasLoopNormal(oneElementLinkedList));
		assertTrue(!finder.hasLoopNormal(noLoopLinkedList));
		assertTrue(finder.hasLoopNormal(loopLinkedList));
	}
	
	public void testHasLoopTwoPass(){
		assertTrue(!finder.hasLoopTwoPass(nullLinkedList));
		assertTrue(!finder.hasLoopTwoPass(oneElementLinkedList));
		assertTrue(!finder.hasLoopTwoPass(noLoopLinkedList));
		assertTrue(finder.hasLoopTwoPass(loopLinkedList));
	}
}
