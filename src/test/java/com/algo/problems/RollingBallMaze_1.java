package com.algo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

/**
 * 
 * A ball roll to a wall L, R, U, D and stop.
 * 
 * @author pulkitmehra
 *
 */
public class RollingBallMaze_1 {

	//@formatter:off
		int[][] maze = new int[][] { 
			new int[] {0,0,1,0,0,0,0}, 
			new int[] {1,0,0,0,1,1,0}, 
			new int[] {0,0,0,1,1,0,1}, 
			new int[] {0,1,0,1,0,0,0}, 
			new int[] {0,0,0,0,0,0,0},
			new int[] {0,0,1,0,0,0,0},
			new int[] {0,0,0,0,0,0,0},
		};
	//@formatter:on
	int[][] delltas = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

	@Test
	public void rolling_ball_using_dfs() {
		List<TwDPt> trace = new ArrayList<>();
		boolean[][] visited = new boolean[maze.length][maze.length + 1];
		int[] s = new int[] { 0, 4 };
		int[] d = new int[] { 4, 0 };
		System.out.println(searchDfs(maze, trace, visited, s[0], s[1], d));
		System.out.println(trace);
	}

	private boolean searchDfs(int[][] maze, List<TwDPt> trace, boolean[][] visited, int y, int x, int[] d) {
		if (visited[y][x] == true) {
			return false;
		}
		TwDPt pt = TwDPt.get(y, x);
		trace.add(pt);
		if (y == d[0] && x == d[1]) {
			return true;
		}
		visited[y][x] = true;
		boolean flag = false;
		TwDPt up = get(maze, y, x, new int[] { -1, 0 });
		if (!visited[up.y][up.x] && maze[up.y][up.x] == 0) {
			flag = searchDfs(maze, trace, visited, up.y, up.x, d);
			if (flag)
				return true;
		}
		TwDPt dwn = get(maze, y, x, new int[] { 1, 0 });
		if (!visited[dwn.y][dwn.x] && maze[dwn.y][dwn.x] == 0) {
			flag = searchDfs(maze, trace, visited, dwn.y, dwn.x, d);
			if (flag)
				return true;
		}
		TwDPt left = get(maze, y, x, new int[] { 0, -1 });
		if (!visited[left.y][left.x] && maze[left.y][left.x] == 0) {
			flag = searchDfs(maze, trace, visited, left.y, left.x, d);
			if (flag)
				return true;
		}
		TwDPt right = get(maze, y, x, new int[] { 0, 1 });
		if (!visited[right.y][right.x] && maze[right.y][right.x] == 0) {
			flag = searchDfs(maze, trace, visited, right.y, right.x, d);
			if (flag)
				return true;
		}
		trace.remove(pt);
		return flag;

	}

	private TwDPt get(int[][] maze, int y, int x, int[] delta) {
		y = y + delta[0];
		x = x + delta[1];
		while (y >= 0 && y <= maze.length - 1 && x >= 0 && x <= maze[y].length - 1 && maze[y][x] == 0) {
			y += delta[0];
			x += delta[1];
		}
		return TwDPt.get(y - delta[0], x - delta[1]);
	}

	@Test
	public void rolling_ball_using_bfs() {
		Map<TwDPt, TwDPt> trace = new HashMap<>();
		boolean[][] visited = new boolean[maze.length][maze.length + 1];
		System.out.println(bfsrollUpBall(maze, visited, trace, 0, 6, new int[] { 4, 0 }));
		backTrack(trace, TwDPt.get(4, 0));
	}

	private void backTrack(Map<TwDPt, TwDPt> trace, TwDPt dest) {
		TwDPt p = trace.get(dest);
		System.out.print(dest + "->");
		while (p != null) {
			System.out.print(p + "->");
			p = trace.get(p);
		}

	}

	private boolean bfsrollUpBall(int[][] maze, boolean[][] visited, Map<TwDPt, TwDPt> trace, int y, int x, int[] d) {
		Queue<TwDPt> q = new LinkedList<>();
		q.offer(TwDPt.get(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			TwDPt pt = q.poll();
			int m = pt.y;
			int n = pt.x;
			if (m == d[0] && n == d[1]) {
				return true;
			}
			for (int[] delta : delltas) {
				TwDPt nxt = get(maze, m, n, delta);

				if (!visited[nxt.y][nxt.x]) {
					visited[nxt.y][nxt.x] = true;
					q.offer(nxt);
					trace.put(nxt, pt);
				}
			}

		}
		return false;
	}

}
