package com.rick.algorithms.queues;

import com.rick.algorithms.sorting.Comparator;

public class UnsortedListPriorityQueueTest extends
		AbstractPriorityQueueTestCase {

	@Override
	protected Queue createQueue(Comparator comparable) {
		return new UnsortedListPriorityQueue(comparable);
	}

}
