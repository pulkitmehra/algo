package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.ds.Utils;

public class DutchFlagProblem {

	int[] a = { 3, -1, 2, 5, 0, 2, -1, 5, 2, 9, -1 };

	@Test
	public void usingQsort() {
		int idx = 5;
		int i = -1, s = 0, v = a[idx], e = a.length - 1, j = e + 1, len = a.length;

		while (s < len) {
			if (a[s] < v)
				Utils.swap(a, s, ++i);
			s++;
		}
		a[++i] = v;
		while (e > i) {
			if (a[e] > v)
				Utils.swap(a, e, --j);
			e--;
		}
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void inOnePass() {
		int i = -1, j = a.length, k = 0, v = a[5];

		while (k < j) {
			if (a[k] < v)
				Utils.swap(a, ++i, k++);
			else if (a[k] > v)
				Utils.swap(a, --j, k);
			else
				k++;
		}
		System.out.println(Arrays.toString(a));
	}
}
