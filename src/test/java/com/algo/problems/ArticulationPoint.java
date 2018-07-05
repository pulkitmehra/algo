package com.algo.problems;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.ds.Graph;

public class ArticulationPoint {

	@Test
	public void graphArticulationPoint() {
		Graph G = Graph.medium2();
		G.print();

		List<Integer> vertices = G.V();
		boolean[] visited = new boolean[vertices.size() + 1];
		int[] low = new int[vertices.size() + 1];
		int[] discover = new int[vertices.size() + 1];
		AtomicInteger time = new AtomicInteger();
		for (Integer u : vertices) {
			if (!visited[u]) {
				dfs(visited, G, u, null, low, discover, time);
			}
		}

	}

	private void dfs(boolean[] visited, Graph g, Integer u, Integer p, int[] low, int[] discover, AtomicInteger time) {
		visited[u] = true;
		discover[u] = time.incrementAndGet();
		low[u] = time.get();

		int[] adj = g.adj(u);
		if (p == null && adj.length > 1) {
			System.out.println("Root is Articulation point is ");
		}
			for (Integer v : adj) {

				if (!visited[v]) {
					dfs(visited, g, v, u, low, discover, time);
					low[u] = Math.min(low[u], low[v]);
					if( low[v] >= low[u]) {
						System.out.println("articulation vertex :"+u);
					}
				}else if(v!=p) { //this is a back edge
					low[u] = Math.min(discover[u], low[v]);
				}
			}
		
	}

}
