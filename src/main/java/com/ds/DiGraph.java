package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DiGraph {

	private Map<Integer, List<WEdge>> adjList = new HashMap<>();

	public void addEdge(int from, int to, int w) {
		adjList.putIfAbsent(from, new LinkedList<>());
		adjList.get(from).add(new WEdge(from, to, w));
	}

	public void addEdge(int from, int to) {
		addEdge(from, to, 0);
	}

	public Iterable<Integer> adj(int v) {
		return Optional.ofNullable(adjList.get(v)).map(l -> l.stream().map((e) -> e.to).collect(Collectors.toList()))
				.orElse(Collections.emptyList());
	}

	public Iterable<WEdge> adjEdges(int v) {
		return Optional.ofNullable(adjList.get(v)).orElse(Collections.emptyList());
	}

	public List<Integer> V() {
		return new ArrayList<>(adjList.keySet());
	}

	public List<WEdge> edges() {
		return adjList.values().stream().flatMap(List::stream).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		Set<Entry<Integer, List<WEdge>>> entrySet = adjList.entrySet();
		StringBuilder b = new StringBuilder();
		for (Entry<Integer, List<WEdge>> entry : entrySet) {
			List<WEdge> values = entry.getValue();
			b.append("[" + entry.getKey() + "]--" + values + "\n");
		}
		return b.toString();
	}

	public static class WEdge {
		public Integer from;
		public Integer to;
		public Integer weight;

		public WEdge(Integer from, Integer to, Integer weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "{(" + from + ")--[" + weight + "]-->(" + to + ")}";
		}
	}

	public static DiGraph mini() {
		DiGraph mini = new DiGraph();
		mini.addEdge(5, 1, 2);
		mini.addEdge(5, 7, 4);
		mini.addEdge(5, 4, 1);

		mini.addEdge(4, 5, 1);
		mini.addEdge(4, 7, 1);

		mini.addEdge(7, 5, 7);
		mini.addEdge(7, 3, 2);

		mini.addEdge(1, 3, 8);

		mini.addEdge(3, 6, 2);

		mini.addEdge(6, 2, 6);
		mini.addEdge(6, 0, 1);
		mini.addEdge(6, 4, 4);

		mini.addEdge(2, 7, 9);
		mini.addEdge(0, 4, 1);
		mini.addEdge(0, 2, 3);

		return mini;
	}

	public static DiGraph clsr() {
		DiGraph clsr = new DiGraph();
		clsr.addEdge(1, 2, 6);
		clsr.addEdge(1, 5, 7);

		clsr.addEdge(5, 3, -3);
		clsr.addEdge(5, 4, 9);

		clsr.addEdge(2, 5, 8);
		clsr.addEdge(2, 3, 5);
		clsr.addEdge(2, 4, -4);

		clsr.addEdge(3, 2, -2);

		clsr.addEdge(4, 3, 7);
		clsr.addEdge(4, 1, 2);

		return clsr;
	}
}
