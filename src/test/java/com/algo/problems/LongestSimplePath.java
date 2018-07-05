package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.Graph;

//How many ways out of maze
public class LongestSimplePath {

	@Test
	public void print() {
		Graph.largeDac().print();
	}

	@Test
	// Dynamic Programming
	public void longestSimplePathCount() {
		Graph G = Graph.largeDac();
		int[] memo = new int[G.V().size() + 1];
		System.out.println(countSimplePath(memo, G, 4, 10));

	}

	private int countSimplePath(int[] memo, Graph G, int u, int v) {
		if (u == v) {
			return 1;
		}
		if (memo[u] != 0) {
			return 0;
		}
		int sum = 0;
		for (int x : G.adj(u)) {
			sum += countSimplePath(memo, G, x, v);
		}
		memo[u] = sum;
		return sum;
	}

	@Test
	public void simplePaths() {
		Graph G = Graph.largeDac();
		List<String> list = new ArrayList<>();
		listAllSimplePaths(G, 4, 10, list, "");
		System.out.println(list);
	}

	@Test
	public void longestsimplePaths() {
		Graph G = Graph.largeDac();
		System.out.println(longestsimplePathsDFS(G, 4, 10, ""));
		
	}

	private String longestsimplePathsDFS(Graph G, int u, int v, String backtrack) {
		if(u == v) {
			return backtrack+"->"+v;
		}
		
		String longest = "";
		for (int x : G.adj(u)) {
			String t = longestsimplePathsDFS(G, x, v, backtrack+"->"+u);
			if(t.length() > longest.length()) {
				longest = t;
			}
		}
		return longest;
	}

	public int listAllSimplePaths(Graph G, int u, int v, List<String> list, String backtrack) {
		if (u == v) {
			list.add(backtrack + "->" + v);
			return 1;
		}
		for (int x : G.adj(u)) {
			listAllSimplePaths(G, x, v, list, backtrack + "->" + u);
		}
		return 0;
	}
}
