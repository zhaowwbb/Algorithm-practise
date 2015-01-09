package com.rick.algorithms.queues;

import java.util.LinkedList;
import java.util.List;

import com.rick.algorithms.sorting.Comparator;

public class HeapOrderedListPriorityQueue implements Queue {
	private final Comparator _comparator;
	private final List _list;
	
	public HeapOrderedListPriorityQueue(Comparator comparator) {
		this._comparator = comparator;
		this._list = new LinkedList();
	}


	@Override
	public void clear() {
		_list.clear();
	}

	@Override
	public int size() {
		return _list.size();
	}

	@Override
	public boolean isEmpty() {
		return _list.size() == 0;
	}

	private void swap(List list, int left, int right)
	{
		Object o = list.get(left);
		list.set(left, list.get(right));
		list.set(right, o);
	}
	
	private void swim(int index)
	{
		if(index <= 0)return;
		int parent = (index - 1) >> 1;
		if(_comparator.compare(_list.get(index), _list.get(parent)) > 0)
		{
			swap(_list, parent, index);
			swim(parent);
		}
	}
	
	private void sink(int index)
	{
		int left = (index << 1) + 1;
		int right = (index << 1) + 2;
		int largest = index;
		if(left < _list.size() && _comparator.compare(_list.get(left), _list.get(largest)) > 0)
		{
			largest = left;
		}
		if(right < _list.size() && _comparator.compare(_list.get(right), _list.get(largest)) > 0)
		{
			largest = right;
		}
		if(largest != index)
		{
			swap(_list, largest, index);
			sink(largest);
		}
	}
	
	@Override
	public void enqueue(Object o) {
		_list.add(o);
		swim(_list.size() - 1);
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		Object o = _list.get(0);
		if(_list.size() == 1){
			return _list.remove(0);
		}
		else
		{
			swap(_list, 0, _list.size() - 1);
			_list.remove(_list.size() - 1);
			sink(0);
		}
		
		return o;
	}

}
