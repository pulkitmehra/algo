package com.algo.gaph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

import org.junit.Test;

import com.ds.DiGraph;
import com.ds.DiGraph.WEdge;

public class Dijkstra {
	
	@Test
	public void dijkstraInUsingPQJava() {
		DiGraph graph = positiveWGraph();
		Map<Integer, Integer> distanceTo = new HashMap<>();
		Map<Integer, Integer> parent = new HashMap<>();
		PriorityQueue<WEdge> q = new PriorityQueue<>(minQComp());
		
		q.offer(new WEdge(1, 1, 0));
		distanceTo.put(1, 0);
		
		while (!q.isEmpty()) {
			WEdge minEdge = q.poll();
			for(WEdge edge:  graph.adjEdges(minEdge.to)) {
				if(relax(edge,distanceTo,parent)) {
					q.offer(edge);
				}
			}
		}
		System.out.println(distanceTo);
		System.out.println(parent);
		System.out.println(printShortestPathTo(parent, 3));
	}
	
	private LinkedList<Integer> printShortestPathTo(Map<Integer, Integer> parent, int i) {
		StringBuilder b = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		while (parent.get(i)!=null) {
			list.addFirst(i);
			i = parent.get(i);
		}
		list.addFirst(i);
		return list;
	}

	private boolean relax(WEdge edge, Map<Integer, Integer> distanceTo, Map<Integer, Integer> parent) {
		Integer dTo = Optional.ofNullable(distanceTo.get(edge.to)).orElse(Integer.MAX_VALUE);
		Integer dFrm = Optional.ofNullable(distanceTo.get(edge.from)).orElse(Integer.MAX_VALUE);
		int weight = dFrm + edge.weight;
		if(dTo > weight) {
			distanceTo.put(edge.to,  weight);
			parent.put(edge.to, edge.from);
			return true;
		}
		return false;
	}

	private static Comparator<WEdge> minQComp(){
		return (one, another) -> one.weight.compareTo(another.weight);
	}
	
	
	
	
	private DiGraph positiveWGraph() {
		DiGraph graph = new DiGraph();
		graph.addEdge(1, 2, 10);
		graph.addEdge(1, 5, 5);
		graph.addEdge(2, 5, 2);
		graph.addEdge(2, 3, 1);
		graph.addEdge(5, 2, 3);
		graph.addEdge(5, 3, 9);
		graph.addEdge(5, 2, 4);
		graph.addEdge(4, 3, 6);
		graph.addEdge(4, 1, 2);
		graph.addEdge(3, 4, 4);
		return graph;
	}

}
