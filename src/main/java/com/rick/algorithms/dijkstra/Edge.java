package com.rick.algorithms.dijkstra;

public class Edge {

	private int weight = 0;
	private Vertex dst = null;
	
	public Edge() {
		this.weight = 0;
		this.dst = null;
	}
	
	public Edge(int w, Vertex v)
	{
		this.weight = w;
		this.dst = v;
	}

	public int getWeight()
	{
		return this.weight;
	}
	
	public Vertex getTarget()
	{
		return this.dst;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[weight=").append(weight).append(",target=").append(dst).append("]");
		return sb.toString();
	}
}
