package com.rick.algorithms.list;

public class FindMiddleElement {
	private void printList(SingleLinkedNode head){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if(head != null){
			SingleLinkedNode node = head;
			while(node != null){
				sb.append("[").append(node.getValue()).append("]");
				node = node.getNext();
			}
		}
		
		sb.append("}");
		
		System.out.println("list=" + sb.toString());
	}
	
	public String findMiddleNormal(SingleLinkedNode head){
		printList(head);
		if(null == head)return null;
		int size = 0;
		SingleLinkedNode node = head;
		
		while(node.getNext() != null){
			size++;
			node = node.getNext();
		}
		int midPos = size/2;		
		node = head;

		for(int i = 0; i < midPos; i++){
			node = node.getNext();
		}

		String value = node.getValue();
		System.out.println("findMiddleNormal(), Middle element list[" + midPos + "]=" + value);
		return value;
	}
	
	public String findMiddleQuick(SingleLinkedNode head){
		printList(head);
		if(null == head)return null;
		SingleLinkedNode oneStep = head;
		SingleLinkedNode twoStep = head;
		SingleLinkedNode middleNode = null;
		boolean isStop = false;
		while(!isStop){
			if(null == oneStep.getNext()){
				isStop = true;
				middleNode = oneStep;				
			}else{				
				if(null == twoStep.getNext() || null == twoStep.getNext().getNext()){
					isStop = true;
					middleNode = oneStep;						
				}else{
					oneStep = oneStep.getNext();
					twoStep = twoStep.getNext().getNext();
				}
			}
		}
		System.out.println("findMiddleQuick(), Middle element =" + middleNode.getValue());		
		return middleNode.getValue();
	}
}
