package com.algo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GroupAnagrams {

	int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101 };

	@Test
	public void withPrimenumbers() {
		String[] arr = new String[] { "abc", "def", "bac", "cdi" };
		Map<Integer, List<String>> map = new HashMap<>();
		int k = 1;
		for (String s : arr) {
			for (char c : s.toCharArray()) {
				k *= primes[c - 'a'];
			}
			map.computeIfAbsent(k, (e) -> new ArrayList<>()).add(s);
			k = 1;
		}
		System.out.println(map.values());

	}
}
