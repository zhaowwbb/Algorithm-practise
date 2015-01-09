package com.rick.algorithms.sorting;

public class CallCountingComparator implements Comparator {
	private int _callCount;
	private final Comparator _comparator;
	
	public CallCountingComparator(Comparator comparator) {
		this._callCount = 0;
		this._comparator = comparator;
	}

	@Override
	public int compare(Object left, Object right) throws ClassCastException {
		_callCount++;
		return _comparator.compare(left, right);
	}

	public int getCallCount()
	{
		return this._callCount;
	}
}
