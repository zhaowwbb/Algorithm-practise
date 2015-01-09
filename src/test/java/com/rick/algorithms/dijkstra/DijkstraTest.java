package com.rick.algorithms.dijkstra;

import java.util.List;
import java.util.ArrayList;
import junit.framework.TestCase;
import com.rick.algorithms.util.Util;

public class DijkstraTest extends TestCase {
	private Dijkstra instance;
	private List<Vertex> list = null;
	private Vertex source = null;
	private Vertex target = null;
	private List<String> targetList = null;
	
	public void setUp() throws Exception
	{
		instance = new Dijkstra();
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");

		Edge e12 = new Edge(6, v2);
		Edge e13 = new Edge(3, v3);
		v1.addEdge(e12);
		v1.addEdge(e13);
		
		Edge e21 = new Edge(6, v1);
		Edge e23 = new Edge(2, v3);
		Edge e24 = new Edge(5, v4);
		v2.addEdge(e21);
		v2.addEdge(e23);
		v2.addEdge(e24);
		
		Edge e31 = new Edge(3, v1);
		Edge e32 = new Edge(2, v2);
		Edge e34 = new Edge(3, v4);
		v3.addEdge(e31);
		v3.addEdge(e32);
		v3.addEdge(e34);
		
		Edge e42 = new Edge(5, v2);
		Edge e43 = new Edge(3, v3);
		Edge e45 = new Edge(2, v5);
		Edge e46 = new Edge(3, v6);
		v4.addEdge(e42);
		v4.addEdge(e43);
		v4.addEdge(e45);
		v4.addEdge(e46);
		
		Edge e53 = new Edge(4, v3);
		Edge e54 = new Edge(2, v4);
		Edge e56 = new Edge(5, v6);
		v5.addEdge(e53);
		v5.addEdge(e54);
		v5.addEdge(e56);
		
		Edge e64 = new Edge(3, v4);
		Edge e65 = new Edge(5, v5);
		v6.addEdge(e64);
		v6.addEdge(e65);
		
		list = new ArrayList<Vertex>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		
		targetList = new ArrayList<String>();
		targetList.add("A");
		targetList.add("C");
		targetList.add("D");
		targetList.add("F");
		
		source = v1;
		target = v6;		
	}
	
	public void testFindShortestPathOne()
	{		
		List<Vertex> result = instance.findShortestPath(list, source, target);

		assertTrue(result.size() == targetList.size());
		for(int i = 0; i < result.size(); i++)
		{
			assertEquals(targetList.get(i), result.get(i).getValue());
		}
		Util.log(instance, "testFindShortestPathOne() success");
	}
	
	public void testCompute()
	{		
		instance.compute(source);
		List<Vertex> result = instance.getShortestPathAfterCompute(target);
		assertTrue(result.size() == targetList.size());
		for(int i = 0; i < result.size(); i++)
		{
			assertEquals(targetList.get(i), result.get(i).getValue());
		}
		Util.log(instance, "testCompute() success");
	}
	
	public void testFindShortestPathTwo()
	{
		List<Vertex> result = instance.findShortestPath(source, target);
		assertTrue(result.size() == targetList.size());
		for(int i = 0; i < result.size(); i++)
		{
			assertEquals(targetList.get(i), result.get(i).getValue());
		}
		Util.log(instance, "testFindShortestPathTwo() success");
		
	}
}
