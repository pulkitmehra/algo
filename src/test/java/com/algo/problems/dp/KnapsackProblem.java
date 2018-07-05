package com.algo.problems.dp;

import org.junit.Test;

public class KnapsackProblem {
	int[] v = { 1, 5, 12, 2 };
	int[] w = { 3, 2, 1, 2 };

	int canCarry = 6;

	@Test
	public void knapsackProblem() {
		int[][] cache = new int[4][6];
		System.out.println(maximumProfit(v, w, 0, 0, canCarry, cache));
	}

	/*
	 * the maximum cache could be combination of index and weight
	 * See pic explaination
	 */
	public int maximumProfit(int[] v, int[] w, int offset, int weight, int canCarry, int[][] cache) {

		if (weight >= canCarry || offset == v.length) {
			return 0;
		}
		if (cache[offset][weight] != 0) {
			return cache[offset][weight];
		}
		int itemSacked = v[offset] * w[offset] + maximumProfit(v, w, offset + 1, weight + w[offset], canCarry, cache);
		int itemLeft = maximumProfit(v, w, offset + 1, weight, canCarry, cache);

		int max = Math.max(itemLeft, itemSacked);
		cache[offset][weight] = max;
		return max;

	}
}
