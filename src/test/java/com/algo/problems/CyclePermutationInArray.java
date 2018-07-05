package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

public class CyclePermutationInArray {

	int[][] p = { { 2, 1, 0, 3 }, { 0, 1, 2, 3 }, { 3, 2, 1, 0 }, { 3, 2, 1, 0 } };

	String[][] n = { { "a", "b", "c", "d" }, { "a", "b", "c", "d" }, { "a", "b", "c", "d" }, { "a", "b", "c", "d" } };

	@Test
	public void cyclePermutation() {
		for (int i = 0; i < p.length; i++) {

			for (int j = 0; j < p[i].length; j++) {
				if (p[i][j] != j) {
					cycles(-1, p[i][j], n[i][j], p, n, i);
				}
			}
		}
		for (int i = 0; i < n.length; i++) {
			System.out.println(Arrays.toString(n[i]));
		}
	}

	void cycles(int prev, int idx, String e, int[][] p, String[][] n, int i) {
		if (prev != p[i][idx]) { //check that current previous is not equal to current's next
			cycles(idx, p[i][idx], n[i][idx], p, n, i);
		}
		n[i][idx] = e;
		p[i][idx] = idx;
	}

}
