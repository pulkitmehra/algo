package com.alogo.problems.invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ThreeSum {

	int[] arr = { 3, 5, 11, 2, 7 };

	@Test
	public void threeSum() {
		System.out.println(threeSum(arr, 21));
	}

	public List<List<Integer>> threeSum(int[] arr, int k) {
		Arrays.sort(arr);
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int j = k - arr[i];
			List<List<Integer>> twoSums = TwoSum.twoSums(arr, j);
			if (!twoSums.isEmpty()) {
				for (List<Integer> subList : twoSums) {
					subList.add(arr[i]);
				}
				lists.addAll(twoSums);
			}
		}
		return lists;
	}
}
