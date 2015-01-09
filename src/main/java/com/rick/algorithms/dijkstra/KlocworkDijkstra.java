package com.rick.algorithms.dijkstra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collections;

public class KlocworkDijkstra {
	public static final String ADJ_LIST_SPLIT = " ";
	private int listSize = 0;	
	
	public KlocworkDijkstra() {

	}
	
	public boolean isEdgeExisted(String k, Vertex v)
	{
		int i = 0;
		for(;i < v.getEdges().size(); i++ )
		{
			Edge e = v.getEdges().get(i);
			if(e.getTarget().getValue().equals(k))
			{
				break;
			}
		}
		if(i == v.getEdges().size())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void addEdge(Vertex src, Vertex dst)
	{
		if(!isEdgeExisted(dst.getValue(), src))
		{
			Edge e = new Edge(1, dst);
			src.addEdge(e);
		}
		if(!isEdgeExisted(src.getValue(), dst))
		{
			Edge e = new Edge(1, src);
			dst.addEdge(e);
		}
	}

	public Vertex readAdjacencyNode(String s, Map<String, Vertex> map)
	{
		String[] strs = s.split(ADJ_LIST_SPLIT);
//		int value = Integer.parseInt(strs[0]);

		String key = strs[0];
		Vertex node = null;
		if(map.containsKey(key))
		{
			node = map.get(key);
		}
		else
		{
			node = new Vertex(key);
		}
		
//		Set<Integer> set = node.adjacencyNodes;
		for(int i = 1; i < strs.length; i++)
		{
			String k = strs[i];
			Vertex v = null;
			if(map.containsKey(k))
			{
				v = map.get(k);
			}
			else
			{
				v = new Vertex(k);
				map.put(k, v);
			}
			addEdge(node, v);
			
//			int v = Integer.parseInt(strs[i]);
////			set.add(v);
//			if(listSize < v)
//			{
//				listSize = v;
//			}
		}
//		node.adjacencyNodes = set;
		return node;
	}
	
	public Map<String, Vertex> readAdjacencyList(String file)
	{
		listSize = 0;
		Map<String, Vertex> map = new HashMap<String, Vertex>();
		
//		List<AdjacencyNode> list = new LinkedList<AdjacencyNode>();
		
		BufferedReader br = null;
	    try {
	    	br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();	        
	        while (line != null) {
	        	Vertex node = readAdjacencyNode(line, map);
	        	if(!map.containsKey(node.getValue()))
	        	{
	        		map.put(node.getValue(), node);
	        	}
	            line = br.readLine();
	        }
	    }
	    catch(FileNotFoundException e)
	    {
	    	 System.out.println("[Error] Can not find file " + file);
	    }
	    catch(IOException ex)
	    {
	    	System.out.println("[Error] Read file failed " + ex);
	    }
	    finally {
	    	try{
	    		 if(br != null)br.close();
	    	 }
	    	 catch(Exception e){}	        
	    }		
		
//	    System.out.println("listSize = " + listSize);
	    return map;
	}

	private static void printQueue(PriorityQueue<Vertex> vertexQueue)
	{
		StringBuilder sb = new StringBuilder();
		for(Iterator it = vertexQueue.iterator(); it.hasNext(); )
		{
			Vertex v = (Vertex)it.next();
			sb.append("[").append(v).append("]");
		}
		System.out.println("vertexQueue=" + sb.toString());
	}
	
	private void print(List list)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++)
		{
			sb.append(list.get(i));
		}
		System.out.println("addList=" + sb.toString());
	}
	
	public void findBestPath(String file, String start, String end)
	{
		Map<String, Vertex> map = readAdjacencyList(file);
		System.out.println("map size:" + map.size());
		Vertex v0 = map.get(start);
		Vertex vx = map.get(end);
		
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		v0.setWeight(0);
		queue.add(v0);
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
					v.setPrevious(u);
					v.setWeight(distance);
					queue.add(v);
//					printQueue(queue);
				}
			}			
		}
		
		List<Vertex> list = new ArrayList<Vertex>();
		System.out.println("KlocworkDijkstra Best path weight:" + vx.getWeight());
		while(vx != null)
		{
			list.add(vx);
			vx = vx.getPrevious();
		}
		Collections.reverse(list);
		print(list);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KlocworkDijkstra k = new KlocworkDijkstra();
		long start = System.currentTimeMillis();
		k.findBestPath("quiz2.txt", "145858", "145524");
		long duration = System.currentTimeMillis() - start;
		System.out.println("findBestPath() takes:" + duration + "(milliseconds)");
	}

}
