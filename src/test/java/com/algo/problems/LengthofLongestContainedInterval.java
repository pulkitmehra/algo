package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class LengthofLongestContainedInterval {

	int[] arr = { -1, 5, 4, -2, -3, 0, 1, 2, 7, 9, 8, 6 };

	@Test
	public void testLongestSubSequence() {
		Map<Integer, Integer> intervals = Arrays.stream(arr).boxed()
				.collect(Collectors.toMap(Function.identity(), Function.identity()));
		List<Integer> soln = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		int d = Integer.MIN_VALUE;

		while (!intervals.isEmpty()) {
			Integer i = intervals.keySet().iterator().next(), j = i;
			soln.add(i);
			intervals.remove(i);
			Integer t = null;
			while (!intervals.isEmpty() && (t = intervals.remove(--i)) != null) {
				soln.add(t);
			}

			while (!intervals.isEmpty() && (t = intervals.remove(++j)) != null) {
				soln.add(t);
			}
			if (soln.size() > d) {
				d = soln.size();
				ans.add(new ArrayList<>(soln));
			}
			soln.clear();
		}

		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

}
