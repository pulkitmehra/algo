package com.algo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

/**
 * find the way out of the maze
 * 
 * 
 * @author pulkitmehra
 *
 */
public class Maze_1 {

	//@formatter:off
	int[][] maze = new int[][] { 
		new int[] {0,0,1,0,0}, 
		new int[] {1,0,0,0,0}, 
		new int[] {0,1,0,1,0}, 
		new int[] {0,0,0,1,0}, 
		new int[] {0,0,0,0,0}, 
	};
	//@formatter:on
	@Test
	public void maze_search_by_dfs() {
		LinkedList<TwDPt> trace = new LinkedList<>();
		boolean[][] visited = new boolean[maze.length][maze.length + 1];
		int[] s = new int[] { 0, 4 };
		int[] d = new int[] { 4, 0 };
		searchDfs(maze, trace, visited, s[0], s[1], d);
		System.out.println(trace);
	}

	boolean searchDfs(int[][] maze, LinkedList<TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {

		if (y < 0 || y > maze.length - 1 || x < 0 || x > maze[y].length - 1 || visited[y][x]) {
			return false;
		}

		visited[y][x] = true;
		if (maze[y][x] == 1) {
			return false;
		}
		trace.addLast(TwDPt.get(y, x));
		if (y == d[0] && x == d[1]) {
			return true;
		}
		if (searchDfs(maze, trace, visited, y - 1, x, d) || searchDfs(maze, trace, visited, y + 1, x, d)
				|| searchDfs(maze, trace, visited, y, x - 1, d) || searchDfs(maze, trace, visited, y, x + 1, d)) {
			return true;
		}
		trace.removeLast();
		return false;
	}

	@Test
	public void searchByBFS() {
		Map<TwDPt, TwDPt> trace = new HashMap<>();
		boolean[][] visited = new boolean[maze.length][maze.length + 1];
		int[] s = new int[] { 0, 4 };
		int[] d = new int[] { 4, 0 };
		System.out.println(searchMazebfs(maze, trace, visited, s[0], s[1], d));
		backtrackTrace(trace, d);

	}

	private void backtrackTrace(Map<TwDPt, TwDPt> trace, int[] d) {
		TwDPt dest = TwDPt.get(d[0], d[1]);
		TwDPt parent = trace.get(dest);
		while (parent != null) {
			System.out.print(dest + "->");
			dest = parent;
			parent = trace.get(dest);
		}
		System.out.print(dest + "->");
	}

	private boolean searchMazebfs(int[][] maze2, Map<TwDPt, TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {

		Queue<TwDPt> q = new LinkedList<>();
		q.offer(TwDPt.get(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			TwDPt f = q.poll();
			y = f.y;
			x = f.x;

			if (f.y == d[0] && f.x == d[1]) {
				return true;
			}

			List<TwDPt> adj = Arrays.asList(TwDPt.get(y + 1, x), TwDPt.get(y - 1, x), TwDPt.get(y, x - 1),
					TwDPt.get(y, x + 1));
			for (TwDPt pt : adj) {
				if (pt.y < 0 || pt.y > maze.length - 1 || pt.x < 0 || pt.x > maze.length - 1 || visited[pt.y][pt.x]) {
					continue;
				}
				visited[pt.y][pt.x] = true;
				if (maze[pt.y][pt.x] == 0) {
					trace.put(pt, f);
					q.offer(pt);
				}

			}
		}
		return false;

	}

}
