package com.algo.problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class ShortestWordDistance {

	String[] s = { "apple", "banana", "dog", "pie", "cat", "house", "banana", "man", "cat", "test" };
	String[] key = { "banana", "cat" };
//pie banana
	@Test
	public void findWordDistanceUsingLinkedList() {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>(2, 1f, true);
		Arrays.stream(key).forEach(e -> map.put(e, null));

		int size = s.length, idx = 0, found = 0, b = -1, e = -1;

		while (idx < size) {
			if (map.containsKey(s[idx])) {
				Integer v = map.get(s[idx]);
				if (v == null) {
					++found;
				}
				map.put(s[idx], idx);
				if (found == map.size()) {
					if ((b == -1 && e == -1) || (idx - map.entrySet().iterator().next().getValue() < (e - b))) {
						b = map.entrySet().iterator().next().getValue();
						e = idx;
					}

				}
			}
			++idx;
		}
		System.out.println("b" + b + ",e" + e);

	}

	@Test
	public void findWordDistance() {
		Set<String> keywords = Arrays.stream(key).collect(Collectors.toSet());
		int found = 0;
		int i = 0, j = i;
		int diff = Integer.MAX_VALUE;
		int b = 0;
		int e = s.length - 1;

		while (j < s.length) {
			while (found != keywords.size() && j < s.length) {
				if (keywords.contains(s[j])) {
					found++;
				}
				if (found != keywords.size())
					j++;
			}

			while (found == keywords.size()) {
				if ((j - i) < diff) {
					diff = j - 1;
					b = i;
					e = j;
				}

				if (keywords.contains(s[i])) {
					found--;
				}
				i++;
			}
			j++;
		}
		System.out.println(b + "," + e);
	}

}
