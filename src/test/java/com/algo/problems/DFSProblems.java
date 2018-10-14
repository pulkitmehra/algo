package com.algo.problems;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.ds.Graph;

public class DFSProblems {

	@Test
	public void print() {
		Graph medium = Graph.medium(true);
		Graph.medium(false).print();
	}

	@Test
	public void printEdgesTypes() {
		Graph G = Graph.medium(true);
		AtomicInteger time = new AtomicInteger(0);
		boolean[] visited = new boolean[G.V().size() + 1];
		for (int s : G.V()) {
			if (!visited[s]) {
				dfs(visited, s, G, time);
			}
		}
	}

	public void dfs(boolean[] visited, int u, Graph G, AtomicInteger time) {
		visited[u] = true;
		G.setStart(u, time.incrementAndGet());
		for (int v : G.adj(u)) {
			if (!visited[v]) {
				System.out.println("Forward Edge: (" + u + ") -> (" + v + ")");
				dfs(visited, v, G, time);
			} else if (G.getStart(v) != 0 && G.getEnd(v) == 0) { // started but not ended
				System.out.println("Back Edge: (" + u + ") -> (" + v + ")");
			} else if (G.getStart(v) != 0 && G.getEnd(v) != 0 && G.getStart(v) < G.getStart(u)
					&& G.getEnd(u) < time.get()) {
				System.out.println("Cross Edge: (" + u + ") -> (" + v + ")");
			}
		}
		G.setEnd(u, time.incrementAndGet());
	}

	@Test
	public void cyclesUnDirected() {
		Graph G = Graph.medium(false);
		boolean[] visited = new boolean[G.V().size() + 1];
		for (int s : G.V()) {
			if (!visited[s]) {
				dfs(visited, s, s, G);
			}
		}
	}

	public void dfs(boolean[] visited, int u, int p, Graph G) {
		G.toGrey(u);
		for (int v : G.adj(u)) {
			if (G.isWhite(v)) {
				dfs(visited, v, u, G);
			} else if (G.isGrey(v) && v != p) {//check if its not the same vertice
				System.out.println("Cycles : (" + u + ") -> (" + v + ")");
			}
		}
		G.toBlack(u);
	}

}
