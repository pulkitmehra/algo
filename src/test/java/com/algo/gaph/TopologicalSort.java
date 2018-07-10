package com.algo.gaph;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.ds.Graph;

public class TopologicalSort {

	@Test
	public void print() {
		Graph.dac().print();
	}

	@Test
	public void topologicalSort() {
		Graph G = Graph.dac();
		boolean[] visited = new boolean[G.V().size() + 1];
		AtomicInteger time = new AtomicInteger(0);
		LinkedList<Integer> list = new LinkedList<>();
		for (int u : G.V()) {
			if (!visited[u]) {
				System.out.println(u);
				dfsTopSort(visited, u, time, G, list);
			}
		}
		for (Integer i : list) {
			System.out.print("("+i+")->");
		}
	}

	private void dfsTopSort(boolean[] visited, int u, AtomicInteger time, Graph G, LinkedList<Integer> list) {
		visited[u] = true;
		G.setStart(u, time.incrementAndGet());

		for (int v : G.adj(u)) {
			if (!visited[v]) {
				dfsTopSort(visited, v, time, G, list);
			} else if (isActivityInProgress(G, v)) {
				throw new RuntimeException("Graph is not acyclic");
			}
		}
		G.setEnd(u, time.incrementAndGet());
		list.addFirst(u);
	}

	private boolean isActivityInProgress(Graph g, int u) {
		return g.getStart(u) != -1 && g.getStart(u) == -1;
	}

}
