package com.algo.problems.dp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

public class SearchPatterIn2DArr {

	//@formatter:off
	int[][] arr = {
			{1,2,8,4},
			{5,6,10,13},
			{9,10,6,12}
	};
	//@formatter:on

	@Test
	public void findPattern() {
		int[] pattern = { 6, 10, 6, 2 };
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		List<TwDPt> indexes = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == pattern[0]) {
					if (findPattern(arr, pattern, i, j, 0, visited, indexes)) {
						System.out.println("found " + indexes);
						break;
					}
				}
			}
		}
	}

	public boolean findPattern(int[][] arr, int[] pattern, int y, int x, int offset, boolean[][] visited,
			List<TwDPt> indexes) {
		if (offset == pattern.length) {
			return true;
		}
		if (y < 0 || y == arr.length || x < 0 || x == arr[y].length || visited[y][x] == true
				|| arr[y][x] != pattern[offset]) {
			return false;
		}
		visited[y][x] = true;
		indexes.add(TwDPt.get(y, x));
		offset++;
		if (findPattern(arr, pattern, y - 1, x, offset, visited, indexes)
				|| findPattern(arr, pattern, y + 1, x, offset, visited, indexes)
				|| findPattern(arr, pattern, y, x - 1, offset, visited, indexes)
				|| findPattern(arr, pattern, y, x + 1, offset, visited, indexes)) {
			return true;
		}
		visited[y][x] = false;
		indexes.remove(indexes.size() - 1);
		offset--;
		return false;
	}

}
