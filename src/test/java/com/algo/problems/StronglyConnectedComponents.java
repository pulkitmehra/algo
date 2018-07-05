package com.algo.problems;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.ds.Graph;

public class StronglyConnectedComponents {

	public static Graph dac() {
		Graph g = new Graph(8, true);
		g.addEdgeDirected(1, 2);
		g.addEdgeDirected(2, 5);
		g.addEdgeDirected(2, 6);
		g.addEdgeDirected(2, 3);
		g.addEdgeDirected(3, 7);
		g.addEdgeDirected(3, 4);
		g.addEdgeDirected(4, 3);
		g.addEdgeDirected(4, 8);
		g.addEdgeDirected(5, 1);
		g.addEdgeDirected(6, 7);
		g.addEdgeDirected(8, 8);
		g.addEdgeDirected(7, 6);
		g.addEdgeDirected(7, 8);
		return g;
	}

	@Test
	public void connectedComponents() {
		Graph dac = dac();
		dac.print();
		System.out.println("-----");
		dac.transpose().print();
	}

	@Test
	public void strongConnections() {
		Graph G = dac();
		AtomicInteger time = new AtomicInteger(0);
		boolean[] visited = new boolean[G.V().size() + 1];
		LinkedList<Integer> list = new LinkedList<>();
		for (int s : G.V()) {
			if (!visited[s]) {
				dfs(visited, s, G, time, list);
			}
		}
		Graph G_ = G.transpose();
		G_.print();
		visited = new boolean[G_.V().size() + 1];
		for (int s : list) {
			if (!visited[s]) {
				System.out.println(dfsOnTranspose(visited, s, G_, ""+s));
			}
		}

	}

	private String dfsOnTranspose(boolean[] visited, int u, Graph G, String res) {
		visited[u] = true;
		for (int v : G.adj(u)) {
			if (!visited[v]) {
				res = dfsOnTranspose(visited, v, G, res + "->" + v);
			}
		}
		return res;
	}

	public void dfs(boolean[] visited, int u, Graph G, AtomicInteger time, LinkedList<Integer> list) {
		visited[u] = true;
		G.setStart(u, time.incrementAndGet());
		for (int v : G.adj(u)) {
			if (!visited[v]) {
				dfs(visited, v, G, time, list);
			}
		}
		G.setEnd(u, time.incrementAndGet());
		list.addFirst(u);
	}
}
