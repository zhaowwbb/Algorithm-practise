package com.rick.algorithms.bstrees;

import junit.framework.TestCase;
import java.util.List;
import java.util.ArrayList;
import com.rick.algorithms.util.Util;


public class NodeTest extends TestCase{
	private List _list;
	private Node _root;

	protected void setUp() throws Exception
	{
//		_list = new ArrayList();
		_root = new Node("A");
		
		Node d = new Node("D");
		Node e = new Node("E");
		Node b = new Node("B", _root, d, e);
		d.setParent(b);
		e.setParent(b);
		
		Node f = new Node("F");		
		Node g = new Node("G");		
		Node c = new Node("C", _root, f, g);
		f.setParent(c);
		g.setParent(c);
		
		_root.setLeftChild(b);
		_root.setRightChild(c);
		
		Node h = new Node("H", e, null, null);
		Node i = new Node("I", e, null, null);
		e.setLeftChild(h);
		e.setRightChild(i);
	}
	
	protected void tearDown() throws Exception
	{
		_root = null;
	}
	
	private String getString(List list)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
		}
		Util.log("target=[" + sb.toString() + "]" );
		return sb.toString();
	}

	public void testInOrder()
	{
		String str = "DBHEIAFCG";
		List list = Node.getListRecursiveInOrder(_root);
		String target = getString(list);
		
		assertEquals(str, target);
	}
	
	public void testPreOrder()
	{
		String str = "ABDEHICFG";
		List list = Node.getListRecursivePreOrder(_root);
		String target = getString(list);
		assertEquals(str, target);		
	}
	
	public void testPostOrder()
	{
		String str = "DHIEBFGCA";
		List list = Node.getListRecursivePostOrder(_root);
		String target = getString(list);
		assertEquals(str, target);		
	}
	
	public void testIterativeInOrder()
	{
		String str = "DBHEIAFCG";
		List list = Node.getListIterativeInOrder(_root);
		String target = getString(list);
		
		assertEquals(str, target);
	}
}
