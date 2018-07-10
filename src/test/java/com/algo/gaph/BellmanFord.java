package com.algo.gaph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ds.DiGraph;
import com.ds.DiGraph.WEdge;

public class BellmanFord {

	@Test
	public void forPositiveWeightCycle() {
		DiGraph G = graphWithPositiveWeightedCycles();
		bellmanford(G);
	}
	@Test
	public void forNegativeWeightCycle() {
		DiGraph G = graphWithNegativeWeightedCycles();
		bellmanford(G);
	}

	private void bellmanford(DiGraph G) {
		System.out.println(G);
		Map<Integer, Integer> parent = new HashMap<>();
		Map<Integer, Integer> distance = new HashMap<>();

		for (Integer v : G.V()) {
			parent.put(v, null);
			distance.put(v, Integer.MAX_VALUE);
		}
		parent.put(1, null);
		distance.put(1, 0);
		
		for(Integer v :  G.V()) {
			System.out.print(v+",");
			for(WEdge edge : G.adjEdges(v)) {
				relax(edge,distance,parent);
			}
		}
		System.out.println();
		System.out.println("vertex :"+G.V());
		System.out.println("parent : "+parent);
		System.out.println("distance : "+distance);
		List<WEdge> edges = G.edges();
		for(WEdge edge : edges) {
			if(distance.get(edge.to) > (distance.get(edge.from) + edge.weight)) {
				System.out.println("Negative weighted cycles "+edge+" ==> "+ distance.get(edge.to)+" > "+(distance.get(edge.from)+" + "+ edge.weight));
			}else {
				System.out.println("Positive weighted cycles "+edge+" ==> "+ distance.get(edge.to)+" > "+(distance.get(edge.from)+" + "+ edge.weight));
			}
		}
	}

	private void relax(WEdge edge, Map<Integer, Integer> distance, Map<Integer, Integer> parent) {
		if(distance.get(edge.to) > (distance.get(edge.from) + edge.weight)) {
			distance.put(edge.to, distance.get(edge.from) + edge.weight);
			parent.put(edge.to, edge.from);
		}
	}

	DiGraph graphWithPositiveWeightedCycles() {
		DiGraph graph = new DiGraph();
		graph.addEdge(1, 2, 6);
		graph.addEdge(1, 5, 7);
		
		graph.addEdge(2, 3, 5);
		graph.addEdge(2, 5, 8);
		graph.addEdge(2, 4, -4);
		
		graph.addEdge(5, 3, -3);
		graph.addEdge(5, 4, 9);
		
		graph.addEdge(3, 2, -2);
		
		graph.addEdge(4, 3, 7);
		graph.addEdge(4, 1, 2);
		
		return graph;
	}

	DiGraph graphWithNegativeWeightedCycles() {
		DiGraph graph = new DiGraph();
		graph.addEdge(1, 2, 6);
		graph.addEdge(1, 5, 7);
		graph.addEdge(2, 3, 5);
		graph.addEdge(2, 5, 8);
		graph.addEdge(2, 4, -4);
		graph.addEdge(3, 2, -2);
		graph.addEdge(5, 4, -6);
		graph.addEdge(4, 1, 2);
		graph.addEdge(4, 3, 7);
		graph.addEdge(4, 5, 3);
		return graph;
	}

}
