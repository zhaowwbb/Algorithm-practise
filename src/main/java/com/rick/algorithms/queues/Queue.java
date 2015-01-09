package com.rick.algorithms.queues;

public interface Queue {
	public void enqueue(Object o);
	
	public Object dequeue() throws EmptyQueueException;
	
	public void clear();
	
	public int size();	
	
	public boolean isEmpty();
}
