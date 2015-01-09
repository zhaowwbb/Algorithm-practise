package com.rick.algorithms.queues;

import java.util.List;
import java.util.LinkedList;
import com.rick.algorithms.sorting.Comparator;

public class UnsortedListPriorityQueue implements Queue {

	private final Comparator _comparator;
	private final List list;
	
	public UnsortedListPriorityQueue(Comparator comparator) {
		this._comparator = comparator;
		this.list = new LinkedList();
	}

	@Override
	public void enqueue(Object o) {
		list.add(o);
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		int maxIndex = findMaxIndex();
		
		Object o = list.remove(maxIndex);
		
		return o;
	}
	
	private int findMaxIndex()
	{
		int pos = 0;
		for(int i = 1; i < list.size(); i++)
		{
			if(_comparator.compare(list.get(i), list.get(pos)) > 0)
			{
				pos = i;
			}
		}
		return pos;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

}
