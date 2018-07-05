package com.algo.problems.dp;

import org.junit.Test;

public class WaysToReachIn2DMatrix {

	@Test
	public void numberOfWaysToReachACellIn2Dmatrix() {
		int m = 3;
		int n = 4;
		int[][] memo = new int[m][n];
		System.out.println(waysToReach(m - 1, n - 1, memo));

	}

	int waysToReach(int y, int x, int[][] memo) {
		if (y < 0 || x < 0) {
			return 0;
		}
		if (y == 0 && x == 0) {
			return 1;
		}
		memo[y][x] = waysToReach(y, x - 1, memo) + waysToReach(y - 1, x, memo);
		return memo[y][x];
	}

}
