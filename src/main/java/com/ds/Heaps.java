package com.ds;

import java.util.PriorityQueue;

import org.junit.Test;

public class Heaps {

	@Test
	public void minHeap() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, (a, b) -> a == b ? 0 : a < b ? -1 : 0);
		for (int i = 0; i < 5; i++) {
			minHeap.add(i);
		}
		System.out.println(minHeap);
		
		Integer element = minHeap.poll();
		System.out.println(minHeap);
	}
}
