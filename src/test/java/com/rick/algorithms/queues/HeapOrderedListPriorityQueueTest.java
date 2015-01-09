package com.rick.algorithms.queues;

import com.rick.algorithms.sorting.Comparator;

public class HeapOrderedListPriorityQueueTest extends
		AbstractPriorityQueueTestCase {

	@Override
	protected Queue createQueue(Comparator comparable) {
		return new HeapOrderedListPriorityQueue(comparable);
	}

}
