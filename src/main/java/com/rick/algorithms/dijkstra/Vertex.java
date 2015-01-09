package com.rick.algorithms.dijkstra;

import java.util.List;
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex>{
	private String value;
	private int weight = Integer.MAX_VALUE;
	private List<Edge> list = new ArrayList<Edge>();
	private List<String> valueList = new ArrayList<String>();
	private Vertex previous = null;
	
	public Vertex(String v)
	{
		this.value = v;
	}
	
	public Vertex(String v, List<Edge> edges)
	{
		this.list.addAll(edges);
		this.value = v;
	}
	
	public void addEdge(Edge e)
	{
		list.add(e);
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int w)
	{
		this.weight = w;
	}
	
	public List<Edge> getEdges()
	{
		return this.list;
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public List<String> getValueList()
	{
		return this.valueList;
	}
	
	public void setValueList(List<String> list)
	{
		this.valueList = list;
	}
	
	public Vertex getPrevious()
	{
		return this.previous;
	}
	
	public void setPrevious(Vertex v)
	{
		this.previous = v;
	}
	
    public int compareTo(Vertex other)
    {
        return Double.compare(weight, other.weight);
    }
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(value);
		sb.append("]");
		return sb.toString();
	}
}
