package com.algo.problems;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import com.ds.Utils;

public class Heap_KlongestString {

	@Test
	public void findK_3_LongestStrings() {
		List<String> readmin = Utils.readmin();

		PriorityQueue<String> minQ = new PriorityQueue<>(3,
				(a, b) -> a.length() == b.length() ? 0 : a.length() > b.length() ? 1 : -1);

		Iterator<String> stream = readmin.iterator();

		int i = 0;
		while (i < 3 && stream.hasNext()) {
			minQ.add(stream.next());
			i++;
		}
		System.out.println(minQ);
		while (stream.hasNext()) {
			String next = stream.next();
			if (minQ.peek().length() < next.length()) {
				minQ.poll();
				minQ.offer(next);
			}
		}

		while (!minQ.isEmpty()) {
			System.out.println(minQ.poll());
		}
	}

}
