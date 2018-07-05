package com.algo.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.ds.Graph;

public class BreadthFirstSearchProblems {

	@Test
	public void printGraphs() {
		Graph.small(true).print();
		System.out.println(Graph.small(true).V());
		System.out.println(Graph.small(true).E());
		System.out.println("##########################");
		Graph.small(false).print();
		System.out.println(Graph.small(false).V());
		System.out.println(Graph.small(false).E());
	}

	@Test
	public void printShoretestPathToEachNodeInANonDGraph() {
		Graph g = Graph.small(false);
		boolean[] visited = new boolean[g.V().size() + 1];
		int[] distance = new int[g.V().size() + 1];
		bfs(g, 2, visited, distance);
		System.out.println(Arrays.toString(visited));
		System.out.println(Arrays.toString(distance));
	}

	@Test
	public void printShoretestPathToEachNodeInADGraph() {
		Graph g = Graph.small(true);
		boolean[] visited = new boolean[g.V().size() + 1];
		int[] distance = new int[g.V().size() + 1];
		bfs(g, 2, visited, distance);
		System.out.println(Arrays.toString(visited));
		System.out.println(Arrays.toString(distance));
	}

	@Test
	public void diameterOfGraph() {
		Graph g = Graph.small(false);
		boolean[] visited = new boolean[g.V().size() + 1];
		int[] distance = new int[g.V().size() + 1];
		System.out.println(diameter(g, 1, visited, distance));
	}

	public int diameter(Graph G, int s, boolean[] visited, int[] distance) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visited[s] = true;
		int max = 1;
		while (!q.isEmpty()) {
			int x = q.poll();
			for (Integer u : G.adj(x)) {
				if (!visited[u]) {
					q.offer(u);
					visited[u] = true;
					distance[u] = distance[x] + 1;
					max = Math.max(max, distance[u]);
				}
			}
			System.out.println();
			visited[x] = true;
		}

		return max;
	}

	public void bfs(Graph G, int s, boolean[] visited, int[] distance) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		visited[s] = true;
		System.out.println(s);
		System.out.println("-----------");
		while (!q.isEmpty()) {
			int x = q.poll();
			for (Integer u : G.adj(x)) {
				if (!visited[u]) {
					q.offer(u);
					visited[u] = true;
					distance[u] = distance[x] + 1;
					System.out.print(u + ",");
				}
			}
			System.out.println();
			visited[x] = true;
		}
	}
}
