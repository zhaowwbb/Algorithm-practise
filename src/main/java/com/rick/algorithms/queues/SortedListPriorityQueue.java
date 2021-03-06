package com.rick.algorithms.queues;

import java.util.LinkedList;
import java.util.List;
import com.rick.algorithms.sorting.Comparator;

public class SortedListPriorityQueue implements Queue {
	private final Comparator _comparator;
	private final List list;
	
	public SortedListPriorityQueue(Comparator comparator) {
		this._comparator = comparator;
		this.list = new LinkedList();
	}

	public void enqueue(Object o) {
		int pos = list.size();
		while(pos > 0 && _comparator.compare(list.get(pos - 1), o) > 0)
		{
			pos--;
		}
		list.add(pos, o);
	}

	public Object dequeue() throws EmptyQueueException {
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		Object o = list.remove(list.size() - 1);
		return o;
	}

	public void clear() {
		list.clear();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		
		return list.size() == 0;
	}

}
