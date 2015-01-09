package com.rick.algorithms.bstrees;

public class AVLTree<T> {
	private AVLNode<T> root;
	
	private static class AVLNode<T>
	{
		private int height;
		private T value;
		private AVLNode<T> parent;
		private AVLNode<T> left;
		private AVLNode<T> right;
		
		public AVLNode(T t)
		{
			this.value = t;
			this.height = 1;
		}
		
		public String toString()
		{
			return "{[Value]=" + value + ",[height]=" + height + "}";
		}
	}
	
	public AVLTree() {

	}
	
	private int height(AVLNode<T> node)
	{
		if(null == node)return 0;
		return node.height;
	}
	
	private int heightDiff(AVLNode<T> node)
	{
		if(null == node)return 0;
		return height(node.left) - height(node.right);
	}
	
	private AVLNode<T> leftRotate(AVLNode<T> n)
	{
		AVLNode<T> r = n.right;
		n.right = r.left;
		r.left = n;
		r.height = Math.max(height(r.left), height(r.right)) + 1;
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		return r;
	}
	
	private AVLNode<T> rightRotate(AVLNode<T> n)
	{
		AVLNode<T> r = n.left;
		n.left = r.right;
		r.right = n;
		r.height = Math.max(height(r.left), height(r.right)) + 1;
		n.height = Math.max(height(n.left), height(n.right)) + 1;
		return r;		
	}
	
	public void add(T t)
	{
		root = add(root, t);
	}
	
	public AVLNode<T> add(AVLNode<T> p, T t)
	{
		if(null == p){
			return new AVLNode(t);
		}
		else
		{
			int k = ((Comparable)p.value).compareTo(t);
			if(k > 0)
			{
				p.left = add(p.left, t);
			}
			else
			{
				p.right = add(p.right, t);
			}
			p.height = Math.max(height(p.left), height(p.right)) + 1;
			int diff = heightDiff(p);
			if(diff > 1)
			{
				if(heightDiff(p.left) < 0)
				{
					p.left = leftRotate(p.left);
					return rightRotate(p);
				}
				else
				{
					return rightRotate(p);
				}
			}
			else if(diff < -1)
			{
				if(heightDiff(p.right) > 0)
				{
					p.right = rightRotate(p.right);
					return leftRotate(p);
				}
				else
				{
					return leftRotate(p);
				}				
			}
		}
		return p;
	}

}
