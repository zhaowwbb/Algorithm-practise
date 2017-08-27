package com.rick.algorithms.list;

public class SingleLinkedNode {
	private String value;
	private SingleLinkedNode next;
	
	public SingleLinkedNode(String v){
		this.value = v;
		this.next = null;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setNext(SingleLinkedNode node){
		this.next = node;
	}
	
	public SingleLinkedNode getNext(){
		return this.next;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(this.value).append("]");
		return sb.toString();
	}
	
}
