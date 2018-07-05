package com.alogo.problems.invariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TwoSum {

	int[] arr = { -1, 0, 2, 5, 7, 9 };

	@Test
	public void twoSum() {
		Arrays.sort(arr);
		System.out.println(twoSums(arr, 7));
	}

	public static List<List<Integer>> twoSums(int[] arr, int k) {
		List<List<Integer>> list = new ArrayList<>();
		int i = 0, j = arr.length - 1, sum = 0;

		while (i < j) {
			sum = arr[i] + arr[j];
			if (sum == k) {
				List<Integer> set = new ArrayList<>();
				set.add(arr[i]);
				set.add(arr[j]);
				list.add(set);
				i++;
				j--;
			} else if (sum < k) {
				i++;
			} else {
				j--;
			}
		}
		return list;
	}

}
