package com.rick.algorithms.queues;

import com.rick.algorithms.sorting.Comparator;

public class SortedListPriorityQueueTest extends AbstractPriorityQueueTestCase {

	protected Queue createQueue(Comparator comparator) {
		return new SortedListPriorityQueue(comparator);
	}

}
