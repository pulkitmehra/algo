package com.algo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class KApartSortedHeap {

	@Test
	public void arry_k_apart_from_its_originalposition() {
		int[] arr = { 3, -1, 2, 6, 4, 5, 8 };
		int k = 2;

		PriorityQueue<Integer> minQ = new PriorityQueue<>(k + 1, (a, b) -> a.compareTo(b));
		int i = 0;
		for (; i < k + 1 && i < arr.length; i++) {
			minQ.offer(arr[i]);
		}

		List<Integer> result = new ArrayList<>();
		while (!minQ.isEmpty()) {
			result.add(minQ.poll());
			if (i < arr.length) {
				minQ.offer(arr[i]);
				i++;
			}
		}
		System.out.println(result);
	}

}
