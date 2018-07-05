package com.algo.problems.dp;

import java.util.Arrays;

import org.junit.Test;

public class MaximizeProfitOnWines {

	int[] prices = { 2, 3, 5, 1, 4 };

	int[][] memo = new int[5][5];

	@Test
	public void testFindMaxProfit() {
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		System.out.println(maxProfit(prices, 0, prices.length - 1, 1));
	}

	/* 
	 * The time complexity is O(n*n) here
	 */
	public int maxProfit(int[] prices, int lo, int hi, int y) {
		if (hi < lo) {
			return 0;
		}

		if (memo[lo][hi] != -1) {
			return memo[lo][hi];
		}

		int max = Math.max((y * prices[lo]) + maxProfit(prices, lo + 1, hi, y + 1),
				(y * prices[hi]) + maxProfit(prices, lo, hi - 1, y + 1));
		memo[lo][hi] = max;
		return max;

	}

}
