package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PowerSetBacktrack {

	@Test
	public void testBacktrackPowerSet() {
		List<Integer> input = Arrays.asList(1, 2, 3);

		List<List<Integer>> ans = new ArrayList<>();
		powerSet(0, input.size(), input, ans, new ArrayList<>());
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	private void powerSet(int i, int size, List<Integer> input, List<List<Integer>> ans, List<Integer> backtrack) {
		if (i == size) {
			System.out.println(backtrack);
			ans.add(new ArrayList<>(backtrack));
		} else {

			backtrack.add(input.get(i));
			powerSet(i + 1, size, input, ans, backtrack);
			backtrack.remove(backtrack.size() - 1);
			powerSet(i + 1, size, input, ans, backtrack);
		}

	}

}
