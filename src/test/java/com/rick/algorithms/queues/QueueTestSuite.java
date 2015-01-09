package com.rick.algorithms.queues;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UnsortedListPriorityQueueTest.class,
	SortedListPriorityQueueTest.class,
	HeapOrderedListPriorityQueueTest.class
})

public class QueueTestSuite {

	public QueueTestSuite() {

	}

}
