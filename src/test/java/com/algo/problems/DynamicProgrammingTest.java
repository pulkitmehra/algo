package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class DynamicProgrammingTest {

	@Test
	public void optimalCutRodTest() {
		int[] p = new int[11];
		p[0] = 0;
		p[1] = 1;
		p[2] = 5;
		p[3] = 8;
		p[4] = 9;
		p[5] = 10;
		p[6] = 17;
		p[7] = 17;
		p[8] = 20;
		p[9] = 24;
		p[10] = 30;

		Map<Integer, List<Integer>> cuts = new HashMap<>();
		cuts.put(0, new ArrayList<>());

		int[] memo = new int[11];
		memo[0] = 0;
		for (int i = 1; i < memo.length; i++) {
			memo[i] = -1;
		}

		int cost_per_cut = 1;
		int price = cutRod(10, memo, p, cuts, cost_per_cut);
		System.out.println(price);
		System.out.println(cuts);
		System.out.println(Arrays.toString(memo));

	}

	public int cutRod(int n, int[] memo, int[] p, Map<Integer, List<Integer>> cuts, int cost_per_cut) {
		if (memo[n] != -1) {
			return memo[n];
		}

		int q = Integer.MIN_VALUE;
		List<Integer> cut = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			// cost per cut should be subtracted from current one and then number optimal cuts happened in lower chain
			int q1 = Math.max(q, (p[i]  + cutRod(n - i, memo, p, cuts, cost_per_cut)));
			if (q1 > q) {
				cut.clear();
				cut.add(i);
				cut.addAll(cuts.get(n - i));
			}
			q = q1;
		}
		memo[n] = q;
		cuts.put(n, cut);
		return q;
	}
	
	public void bottomUpApproachRoCut() {
		
	}

}
