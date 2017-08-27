package com.rick.algorithms.list;

import java.util.Set;
import java.util.HashSet;

public class FindLoopInLinkedList {
	
	public boolean hasLoopNormal(SingleLinkedNode head){
		if(null == head)return false;
		SingleLinkedNode node = head;
		Set<SingleLinkedNode> set = new HashSet<SingleLinkedNode>();
		while(node != null){
			if(set.contains(node)){
				System.out.println("Found loop item:" + node.getValue());
				return true;
			}else{
				set.add(node);
				node = node.getNext();
			}
		}
		return false;
	}
	
	public boolean hasLoopTwoPass(SingleLinkedNode head){
		if(null == head)return false;		
		SingleLinkedNode slowNode = head;
		SingleLinkedNode fastNode = head.getNext();
		if(null == fastNode)return false;
		if(slowNode == fastNode || slowNode == fastNode.getNext())return true;

		while(fastNode != null){
			slowNode = slowNode.getNext();
			
			fastNode = fastNode.getNext();
			if(null == fastNode)return false;
			
			System.out.println("slowNode=" + slowNode.getValue() + ", fastNode=" + fastNode.getValue());
			if(slowNode == fastNode || slowNode == fastNode.getNext()){
				return true;
			}
			fastNode = fastNode.getNext();
		}
		
		return false;
	}

}
