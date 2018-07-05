package com.algo.problems.dp;

import java.util.Arrays;

import org.junit.Test;

public class MaximizeCoinWithTurn {

	// int[] coins = { 1, 5, 1, 7, 3 };
	int[] coins = { 25, 5, 10, 5, 10, 5, 10, 25, 1, 25, 1, 25, 1, 25, 5, 10 };

	@Test
	public void maximizeCoin() {
		int[][] cache = new int[coins.length][coins.length];
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(maximizeCoin(0, coins.length - 1, cache, true));
	}

	public int maximizeCoin(int lo, int hi, int[][] cache, boolean turn) {
		if (hi < lo) {
			return 0;
		}
		if (hi == lo) {
			if (turn) {
				return coins[lo];
			} else {
				return 0;
			}
		}

		if (cache[lo][hi] != -1) {
			return cache[lo][hi];
		}

		int max = Integer.MIN_VALUE;
		if (turn) {
			max = Math.max(coins[lo] + maximizeCoin(lo + 1, hi, cache, !turn),
					coins[hi] + maximizeCoin(lo, hi - 1, cache, !turn));
		} else {
			max = Math.max(maximizeCoin(lo + 1, hi, cache, !turn), maximizeCoin(lo, hi - 1, cache, !turn));
		}
		cache[lo][hi] = max;
		return max;
	}

}
