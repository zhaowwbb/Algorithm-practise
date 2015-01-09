package com.rick.algorithms.queues;

import com.rick.algorithms.sorting.Comparator;
import com.rick.algorithms.sorting.NaturalComparator;
import com.rick.algorithms.util.Util;

import junit.framework.TestCase;

public abstract class AbstractPriorityQueueTestCase extends TestCase {
	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;
	
	private Queue _queue;
	
	protected void setUp() throws Exception
	{
		_queue = createQueue(NaturalComparator.instance);
		super.setUp();
	}
	
	protected void tearDown() throws Exception
	{
		_queue = null;
		super.tearDown();
	}
	
	protected abstract Queue createQueue(Comparator comparable);

	public void testAccessAnEmptyQueue() {
		assertTrue(_queue.isEmpty());
		assertTrue(_queue.size() == 0);
		int val = 0;
		try
		{
			_queue.dequeue();
		}catch(EmptyQueueException e)
		{
			val = 1;
		}
		assertTrue(val == 1);
		Util.log(_queue, "testAccessAnEmptyQueue() success"); 
	}
	
	public void testEnqueueDequeue() {
		
		_queue.enqueue(ONE);
		assertTrue(_queue.size() == 1);
		_queue.enqueue(TWO);
		assertTrue(_queue.size() == 2);
		_queue.enqueue(THREE);
		assertTrue(_queue.size() == 3);
		
		assertTrue(THREE.equals(_queue.dequeue()));
		assertTrue(_queue.size() == 2);
		assertTrue(TWO.equals(_queue.dequeue()));
		assertTrue(_queue.size() == 1);
		assertTrue(ONE.equals(_queue.dequeue()));
		assertTrue(_queue.size() == 0);
		assertTrue(_queue.isEmpty());
		Util.log(_queue, "testEnqueueDequeue() success"); 
	}
	
	public void testClear() {
		_queue.enqueue(ONE);
		_queue.enqueue(TWO);
		_queue.enqueue(THREE);
		
		_queue.clear();
		assertTrue(_queue.size() == 0);
		assertTrue(_queue.isEmpty());
		Util.log(_queue, "testClear() success"); 
	}
}
