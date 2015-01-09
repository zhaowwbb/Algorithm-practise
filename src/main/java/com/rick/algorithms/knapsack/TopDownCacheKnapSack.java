package com.rick.algorithms.knapsack;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.rick.algorithms.util.Util;

public class TopDownCacheKnapSack extends AbstractKnapSack {

	public class Item{
		int value;
		int weight;
		int id;
		Item(int v, int w, int id)
		{
			this.value = v;
			this.weight = w;
			this.id = id;
		}
		
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("value=").append(value);
			sb.append(",weight=").append(weight);
			sb.append(",ID=").append(id);
			return sb.toString();
		}
	}
	
	public class Bag{
		List<Integer> list;
		int weight;
		int value;
		
		public Bag()
		{
			this.list = new ArrayList<Integer>();
			this.weight = 0;
			this.value = 0;
		}
		
		public Bag(int value, int weight)
		{
			this.list = new ArrayList<Integer>();
			this.weight = weight;
			this.value = value;	
		}
		
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("weight=").append(weight);
			sb.append(",value=").append(value);
			for(int i = 0; i < list.size(); i++)
			{
				sb.append("[").append(list.get(i)).append("]");
			}
			return sb.toString();			
		}
	}
	
	private Map<Integer, Bag> cache = new HashMap<Integer, Bag>();
	
	public List<Integer> getOptimalSubset(int[] val, int[] wt, int w) {
		verifyInput(val, wt, w);
		cache.clear();
		List<Item> items = getItems(val, wt);
		Bag bag = getBestBag(items, val.length - 1, w);
		return bag.list;
	}
	
	private List<Item> getItems(int[] val, int[] wt)
	{
		List<Item> list = new ArrayList<Item>();
		for(int i = 0; i < val.length; i++)
		{
			list.add(new Item(val[i], wt[i], i));
		}
		
		return list;
	}
	
	private Bag getBestBag(List<Item> list, int n, int w)
	{
		if(cache.containsKey(w))
		{
			Util.log("Found cache for:" + w + ",bag=" + cache.get(w));
			return cache.get(w);
		}
//		if(w < 0)return null;
		if(w <= 0)return new Bag();
		
//		Item previous = null;
		Bag bestBag = null;
		if(n < 0)return new Bag();
		if(n > 0)
		{
//			previous = list.get(n - 1);
			Bag lastBag = getBestBag(list, n - 1, w - list.get(n).weight);
			
			
			if(0 == lastBag.value)
			{
				bestBag = new Bag(list.get(n).value, list.get(n).weight);
				bestBag.list.add(n);				
			}
			else
			{
				int lastValue = lastBag.value;
				int lastWeight = lastBag.weight;
				int curValue = list.get(n).value + lastValue;
				int curWeight = list.get(n).weight + lastWeight;
				
				if(curWeight <= w && curValue > lastValue)
				{
					bestBag = new Bag(curValue, curWeight);
					bestBag.list.addAll(lastBag.list);
					bestBag.list.add(n);
				}
			}
		}
		else
		{
			bestBag = new Bag(list.get(n).value, list.get(n).weight);
			bestBag.list.add(n);
		}
		Util.log("bestBag:" + bestBag);
		cache.put(w, bestBag);
		return bestBag;
	}

}
