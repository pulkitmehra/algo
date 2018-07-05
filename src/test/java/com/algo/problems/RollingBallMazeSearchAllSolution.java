package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

/**
 * 
 * A ball roll to a wall L, R, U, D and stop.
 * 
 * @author pulkitmehra
 *
 */
public class RollingBallMazeSearchAllSolution {

	//@formatter:off
		int[][] maze = new int[][] { 
			new int[] {0,0,0,1,0}, 
			new int[] {0,1,0,0,0}, 
			new int[] {0,0,0,0,1}, 
			new int[] {0,0,1,0,0}, 
			new int[] {0,0,0,0,0},
		};
	//@formatter:on
	int[][] delltas = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

	@Test
	public void searchAllSoln() {
		List<List<TwDPt>> ans = new ArrayList<>();
		List<TwDPt> soln = new ArrayList<>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		allMazeSoln(ans, soln, 0, 4, 4, 0, visited);
		for (List<TwDPt> res : ans) {
			System.out.println(res);
		}

	}

	void allMazeSoln(List<List<TwDPt>> ans, List<TwDPt> soln, int y, int x, int ey, int ex, boolean[][] visited) {
		if (ey == y && ex == x) {
			soln.add(TwDPt.get(ey, ex));
			ans.add(new ArrayList<>(soln));
			soln.remove(soln.size() - 1);
			return;
		}

		soln.add(TwDPt.get(y, x));
		visited[y][x] = true;
		TwDPt right = directionalTraverse(maze, visited, y, x, 3);
		if ((right.y != y || right.x != x) && !visited[right.y][right.x]) {
			allMazeSoln(ans, soln, right.y, right.x, ey, ex, visited);
		}
		TwDPt left = directionalTraverse(maze, visited, y, x, 2);
		if ((left.y != y || left.x != x) && !visited[left.y][left.x]) {
			allMazeSoln(ans, soln, left.y, left.x, ey, ex, visited);
		}

		// go up (0)
		TwDPt up = directionalTraverse(maze, visited, y, x, 0);
		if ((up.y != y || up.x != x) && !visited[up.y][up.x]) {
			allMazeSoln(ans, soln, up.y, up.x, ey, ex, visited);
		}

		TwDPt down = directionalTraverse(maze, visited, y, x, 1);
		if ((down.y != y || down.x != x) && !visited[down.y][down.x]) {
			allMazeSoln(ans, soln, down.y, down.x, ey, ex, visited);
		}
		soln.remove(soln.size() - 1);
		visited[y][x] = false;

	}

	TwDPt directionalTraverse(int[][] maze, boolean[][] visited, int y, int x, int delta) {
		y = y + delltas[delta][0];
		x = x + delltas[delta][1];
		while (y >= 0 && y <= maze.length - 1 && x >= 0 && x <= maze[y].length - 1 && maze[y][x] == 0) {
			y = y + delltas[delta][0];
			x = x + delltas[delta][1];
		}

		return TwDPt.get(y - delltas[delta][0], x - delltas[delta][1]);
	}

}
