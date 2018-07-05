package com.algo.problems.dp;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

public class StepsAndStairs {

	int[] steps = { 1, 2 };
	int stairs = 4;

	@Test
	public void noOfWays() {
		Map<TwDPt, Integer> memo = new HashMap<>();
		System.out.println(noOfWays(0, stairs, steps, memo));
	}

	int noOfWays(int step, int stairs, int[] steps, Map<TwDPt, Integer> memo) {
		if (stairs < 0)
			return 0;
		if (stairs == 0)
			return 1;
		TwDPt key = TwDPt.get(stairs, step);
		if (memo.containsKey(key))
			return memo.get(key);

		int sum = 0;
		for (int i = 0; i < steps.length; i++) {
			sum += noOfWays(steps[i], stairs - steps[i], steps, memo);
		}
		memo.put(key, sum);
		return sum;
	}

}
