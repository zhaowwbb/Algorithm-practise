package com.rick.algorithms.dijkstra;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Collections;

import com.rick.algorithms.util.Util;

public class Dijkstra {

	public Dijkstra() {
		
	}
	
	private void addList(Vertex v, List<Vertex> list)
	{
		v.getValueList().clear();
		for(int j = 0; j < list.size();j++)
		{
			v.getValueList().add(list.get(j).getValue());
		}
		v.getValueList().add(v.getValue());	
	}
	
	public List<Vertex> findShortestPath(List<Vertex> list,Vertex start, Vertex end)
	{
		List<Vertex> result = new ArrayList<Vertex>();
		if(null == list || null == start || null == end)return result;
		Map<String, Vertex> map = new HashMap<String, Vertex>();
		for(int i = 0; i < list.size(); i++)
		{
			Vertex v = list.get(i);
			if(!v.getValue().equals(start.getValue())){
				map.put(v.getValue(), v);
				v.setWeight(0);
			}
		}
		result.add(start);
		Vertex v = start;
		Map<String, Vertex> mm = new HashMap<String, Vertex>();
		mm.put(v.getValue(), v);
		while(map.size() != 0)
		{
			Vertex hitVertex = null;
			List<Edge> edges = v.getEdges();
			int maxWeight = Integer.MAX_VALUE;
			for(int i = 0; i < edges.size(); i++)
			{
				Edge e = edges.get(i);
				if(mm.containsKey(e.getTarget().getValue()))continue;
				
				int w = v.getWeight() + e.getWeight();
				if(e.getTarget().getWeight() == 0)
				{
					e.getTarget().setWeight(w);
					addList(e.getTarget(), result);
				}
				if(w < e.getTarget().getWeight())
				{
					e.getTarget().setWeight(w);
					addList(e.getTarget(), result);
				}
				else if(w > e.getTarget().getWeight())
				{
					w = e.getTarget().getWeight();
					Set<String> set = new HashSet<String>();
					
					for(int j = 0; j < e.getTarget().getValueList().size(); j++)
					{
						set.add(e.getTarget().getValueList().get(j));
					}
					for(Iterator<Vertex> it = result.iterator(); it.hasNext();)
					{
						Vertex vertex = it.next();
						if(!set.contains(vertex.getValue()))
						{
							it.remove();
						}
					}					
				}
				if(w < maxWeight)
				{
					maxWeight = w;
					hitVertex = e.getTarget();
				}
				
			}
//			System.out.println("Found shortest vertex:" + hitVertex);
			if(hitVertex != null)
			{
				result.add(hitVertex);
				
				v = hitVertex;
				mm.put(v.getValue(), v);
				map.remove(v.getValue());
			}
			else
			{
				Util.log("Found shortest vertex: null");
				break;
			}
		}
		return result;
	}
	
	public List<Vertex> getShortestPathAfterCompute(Vertex v)
	{
		List<Vertex> list = new ArrayList<Vertex>();
		Vertex ver = v;
		while(ver != null)
		{
			list.add(ver);
			ver = ver.getPrevious();
		}
		Collections.reverse(list);
		return list;
	}
	
	public void compute(Vertex source)
	{
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		source.setWeight(0);
		queue.add(source);
		while(!queue.isEmpty())
		{
			Vertex v = queue.poll();
			for(int i = 0; i < v.getEdges().size(); i++)
			{
				Edge e = v.getEdges().get(i);
				Vertex t = e.getTarget();
				int distance = v.getWeight() + e.getWeight();
				if(distance < t.getWeight())
				{
					queue.remove(t);
					t.setPrevious(v);
					t.setWeight(distance);
					queue.add(t);
				}	
			}
		}
	}
	
	public List<Vertex> findShortestPath(Vertex src, Vertex dst)
	{
		List<Vertex> result = new ArrayList<Vertex>();
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		
		src.setWeight(0);
		queue.add(src);
		while(!queue.isEmpty())
		{
			Vertex u = queue.poll();
			for(int i = 0; i < u.getEdges().size(); i++)
			{
				Edge e = u.getEdges().get(i);
				Vertex v = e.getTarget();
				int distance = u.getWeight() + e.getWeight();
				if(distance < v.getWeight())
				{
					queue.remove(v);
					v.setWeight(distance);
					
					v.setPrevious(u);
					queue.add(v);
				}
			}
		}
		
		Vertex vv = dst;
		while(vv != null)
		{
			result.add(vv);
			vv = vv.getPrevious();
		}
		
		Collections.reverse(result);
		
		return result;
	}
}
