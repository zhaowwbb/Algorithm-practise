package com.rick.algorithms.bstrees;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Node {

	private Object _value;
	private Node _parent;
	private Node _leftChild;
	private Node _rightChild;
	private boolean isVisited;
	
	public Node(Object o) {
		this._value = o;
		this._parent = null;
		this._leftChild = null;
		this._rightChild = null;

	}
	
	public Node(Object o, Node parent, Node left, Node right) {
		this._value = o;
		this._parent = parent;
		this._leftChild = left;
		this._rightChild = right;
	}
	
	public void setLeftChild(Node lChild)
	{
		this._leftChild = lChild;
	}

	public void setRightChild(Node rChild)
	{
		this._rightChild = rChild;
	}

	public void setParent(Node parent)
	{
		this._parent = parent;
	}
	
	public Node getLeftChild()
	{
		return this._leftChild;
	}
	
	public Node getRightChild()
	{
		return this._rightChild;
	}
	
	public Node getParent()
	{
		return this._parent;
	}

	public Object getValue()
	{
		return this._value;
	}
	
	public static List getListRecursiveInOrder(Node node)
	{
		List list = new ArrayList();
		recursiveInOrder(list, node);
		return list;
	}
	
	private static void recursiveInOrder(List list, Node node)
	{
		if(null == node)return;
		recursiveInOrder(list, node.getLeftChild());
		list.add(node.getValue());
		recursiveInOrder(list, node.getRightChild());
	}
	
	public static List getListRecursivePreOrder(Node node)
	{
		List list = new ArrayList();
		recursivePreOrder(list, node);
		return list;		
	}
	
	private static void recursivePreOrder(List list, Node node)
	{
		if(null == node)return;
		list.add(node.getValue());
		recursivePreOrder(list, node.getLeftChild());		
		recursivePreOrder(list, node.getRightChild());
	}
	
	public static List getListRecursivePostOrder(Node node)
	{
		List list = new ArrayList();
		recursivePostOrder(list, node);
		return list;		
	}
	
	private static void recursivePostOrder(List list, Node node)
	{
		if(null == node)return;
		
		recursivePostOrder(list, node.getLeftChild());		
		recursivePostOrder(list, node.getRightChild());
		list.add(node.getValue());
	}
	
	public static List getListIterativeInOrder(Node node)
	{
		List list = new ArrayList();
		if(null == node)return list;
		Stack stack = new Stack();
		stack.push(node);
		while(!stack.isEmpty())
		{
			Node n = (Node)stack.peek();
			
			
			if(n.getLeftChild() != null && !n.getLeftChild().isVisited)
			{
				stack.push(n.getLeftChild());
			}
			else
			{
				list.add(n.getValue());
				n.isVisited = true;
				stack.pop();
				if(n.getRightChild() != null && !n.getRightChild().isVisited)
				{
					stack.push(n.getRightChild());
				}
			}
		}
		return list;
	}
}
