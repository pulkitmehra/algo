package com.algo.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

public class CourseSelection {

	int time = 0;
	int hasCycles = 0;

	@Test
	public void canFinishTest() {
		System.out.println(canFinish(1, new int[][] {}));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, Boolean> visited = new HashMap<>();
		Graph G = new Graph(prerequisites);
		LinkedList<Integer> list = new LinkedList<>();
		for (Integer u : G.V()) {
			if (visited.get(u) == null) {
				System.out.println(u);
				dfs(u, G, visited, list);
			}
		}
		System.out.println(hasCycles);
		System.out.println(list);
		return hasCycles == 0 && list.size() >= numCourses;
	}

	void dfs(int u, Graph G, HashMap<Integer, Boolean> visited, LinkedList<Integer> list) {
		visited.put(u, true);
		G.setStart(u, ++time);
		for (int v : G.adj(u)) {
			if (visited.get(v) == null) {
				dfs(v, G, visited, list);
			} else if (G.isActivityInProgress(v)) {
				System.out.println("hasCycles" + G.getStart(v) + "," + G.getEnd(v));
				hasCycles++;
			}
		}
		G.setEnd(u, ++time);
		list.addFirst(u);
	}

	static class Graph {
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		HashMap<Integer, Integer> start = new HashMap<>();
		HashMap<Integer, Integer> end = new HashMap<>();

		public Graph(int[][] p) {
			for (int i = 0; i < p.length; i++) {
				LinkedList<Integer> list = map.get(p[i][0]);
				if (list == null) {
					list = new LinkedList<>();
					map.put(p[i][0], list);
				}
				list.add(p[i][1]);
				list = map.get(p[i][1]);
				if (list == null) {
					list = new LinkedList<>();
					map.put(p[i][1], list);
				}
			}
		}

		public void print() {
			for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			}

		}

		public Iterable<Integer> adj(int i) {
			return map.get(i) == null ? new LinkedList<>() : map.get(i);
		}

		public Iterable<Integer> V() {
			return map.keySet();
		}

		public void setStart(int i, int t) {
			start.put(i, t);
		}

		public void setEnd(int i, int t) {
			end.put(i, t);
		}

		public Integer getStart(int i) {
			return start.get(i);
		}

		public Integer getEnd(int i) {
			return end.get(i);
		}

		public boolean isActivityInProgress(int v) {
			return getStart(v) != null && getEnd(v) == null;
		}
	}

}