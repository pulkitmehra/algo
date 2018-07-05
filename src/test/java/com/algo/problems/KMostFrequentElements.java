package com.algo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.algo.Sorting;

@Sorting
public class KMostFrequentElements {

	@Test
	public void findKMostElement() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 3 };
		System.out.println(quickSelect(arr, 2));
	}

	@Test
	public void findKthMostElement() {
		int[] arr = new int[] { 4, 1, -1, 2, -1, 2, 3 };
		System.out.println(quickSelect(arr, 2));
	}

	public int pivot(List<Pair> p, int s, int e) {

		int i = s - 1;
		while (s < e) {
			if (p.get(s).freq > p.get(e).freq) {
				swap(p, ++i, s);
			}
			s++;
		}
		swap(p, ++i, e);
		return i;
	}

	private void swap(List<Pair> p, int i, int s) {
		if (i == s)
			return;
		Pair t = p.get(i);
		p.set(i, p.get(s));
		p.set(s, t);
	}

	public List<Integer> quickSelect(int[] arr, int k) {

		Map<Integer, Pair> map = new HashMap<Integer, Pair>();

		for (int i = 0; i < arr.length; i++) {
			int v = arr[i];
			Pair p = map.get(v);
			if (p == null) {
				p = Pair.of(v);
				map.put(v, p);
			} else {
				p.incr();
			}
		}

		if (map.size() <= k) {
			return new ArrayList<>(map.keySet());
		} else {
			return quickSelect(new ArrayList<>(map.values()), k, 0, map.size() - 1);
		}
	}

	public List<Integer> quickSelect(List<Pair> p, int k, int s, int e) {
		if (e <= s) {
			return Collections.emptyList();
		}
		int piv = pivot(p, s, e);
		if (k > piv) {
			return quickSelect(p, k, piv + 1, e);
		} else if (k < piv) {
			return quickSelect(p, k, s, piv - 1);
		} else {
			return p.stream().limit(k).map(n -> n.num).collect(Collectors.toList());
		}
	}

	public static class Pair {
		int num;
		int freq;

		static Pair of(int num) {
			Pair p = new Pair();
			p.num = num;
			p.freq = 1;
			return p;
		}

		public void incr() {
			freq += 1;
		}

		@Override
		public String toString() {
			return num + "->" + freq;
		}

	}

}
