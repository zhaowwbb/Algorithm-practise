package com.rick.algorithms;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rick.algorithms.sorting.SortingTestSuite;
import com.rick.algorithms.queues.QueueTestSuite;
import com.rick.algorithms.bsearch.BSearchTestSuite;
import com.rick.algorithms.bstrees.NodeTest;
import com.rick.algorithms.bstrees.BinarySearchTreeTest;
import com.rick.algorithms.dijkstra.DijkstraTest;
import com.rick.algorithms.knapsack.KnapSackTestSuite;
import com.rick.algorithms.maze.MazeTest;
import com.rick.algorithms.ssearch.BoyerMooreStringSearcherTest;
import com.rick.algorithms.ssearch.BruteForceStringSearcherTest;
import com.rick.algorithms.trietree.DictionaryTest;
import com.rick.algorithms.trietree.WordSearchUtilityTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SortingTestSuite.class,
	BSearchTestSuite.class,
	NodeTest.class,
	BinarySearchTreeTest.class,
	KnapSackTestSuite.class,
	BruteForceStringSearcherTest.class,
	BoyerMooreStringSearcherTest.class,
	DijkstraTest.class,
	MazeTest.class,
	DictionaryTest.class,
	WordSearchUtilityTest.class,
	QueueTestSuite.class
})

public class AllTestSuite {

	public AllTestSuite() {
	}

}
