package com.rick.algorithms.tree;

public class TreeTraversal {
	
	public Node createTree(){
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		f.setLeftChild(b);
		f.setRightChild(g);
		
		b.setLeftChild(a);
		b.setRightChild(d);
		
		d.setLeftChild(c);
		d.setRightChild(e);
		
		g.setRightChild(i);
		i.setLeftChild(h);
		return f;
	}
	
	public void printPreOrder(Node root){
		if(null == root)return;
		System.out.print("" + root.getValue() + ", ");
		printPreOrder(root.getLeftChild());
		printPreOrder(root.getRightChild());
	}
	
	public void printPostOrder(Node root){
		if(null == root)return;
		printPostOrder(root.getLeftChild());
		printPostOrder(root.getRightChild());
		System.out.print("" + root.getValue() + ", ");		
	}
	
	public void printInOrder(Node root){
		if(null == root)return;
		printInOrder(root.getLeftChild());
		System.out.print("" + root.getValue() + ", ");	
		printInOrder(root.getRightChild());			
	}
	
	public void testPreOrder(){
		Node root = createTree();		
		System.out.println("Expected Pre-order:");
		System.out.println("F, B, A, D, C, E, G, I, H");
		System.out.println("Actual   Pre-order:");
		printPreOrder(root);
		System.out.println(" ");
		System.out.println("====================");		
	}
	
	public void testPostOrder(){
		Node root = createTree();		
		System.out.println("Expected Post-order:");
		System.out.println("A, C, E, D, B, H, I, G, F");
		System.out.println("Actual   Post-order:");
		printPostOrder(root);
		System.out.println(" ");
		System.out.println("====================");				
	}

	public void testInOrder(){
		Node root = createTree();		
		System.out.println("Expected In-order:");
		System.out.println("A, B, C, D, E, F, G, H, I");
		System.out.println("Actual   In-order:");
		printInOrder(root);
		System.out.println(" ");
		System.out.println("====================");				
	}	
	
	public static void main(String[] args) {
		TreeTraversal t = new TreeTraversal();
		t.testPreOrder();
		t.testPostOrder();
		t.testInOrder();

	}

}
