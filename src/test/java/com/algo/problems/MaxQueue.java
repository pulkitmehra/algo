package com.algo.problems;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class MaxQueue {

	Deque<Integer> q = new ArrayDeque<>();
	Deque<Integer> maxq = new ArrayDeque<>();

	public void enqueue(int v) {
		while (!maxq.isEmpty() && maxq.peekLast() < v) {
			maxq.pollLast();
		}
		maxq.addLast(v);
		q.addLast(v);
	}

	public int deque() {
		if (maxq.peek() == q.peek()) {
			maxq.poll();
		}
		return q.poll();
	}

	public int max() {
		return maxq.peek();
	}

	@Test
	public void testMaxQ() {
		enqueue(2);
		enqueue(6);
		enqueue(1);
		enqueue(5);
		System.out.println(max());
		System.out.println(deque());

		System.out.println(deque());
		System.out.println(max());

	}
}
