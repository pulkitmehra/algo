package com.algo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class LongestDistinctSubarray {

	String[] arr = { "f", "s", "d", "e", "x", "s", "e", "d", "x", "z" };

	@Test
	public void longestSubarray() {
		Map<String, Integer> map = new HashMap<>();
		int s = 0, e = 0, b = 0, f = 0, j = 0, size = arr.length, diff = -1;

		while (j < size) {
			e = j;
			Integer idx = map.get(arr[j]);
			if (idx == null) {
				if (e - s > diff) {
					b = s;
					f = e;
					diff = e - s;
				}
			} else {
				s = idx + 1;
			}
			map.put(arr[j], j);
			j++;
		}
		System.out.println("s=" + b + " f=" + f);
	}

}
