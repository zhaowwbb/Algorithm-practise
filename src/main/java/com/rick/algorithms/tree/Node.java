package com.rick.algorithms.tree;

public class Node {
	private String value = null;
	private Node parent = null;
	private Node leftChild = null;
	private Node rightChild = null;
	
	public Node(String v){
		this.parent = null;
		this.value = v;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getValue() {
		return value;
	}
}
