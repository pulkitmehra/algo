package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

import com.ds.Utils;

public class Heap_MergeKSortedList {

	static class IteraratorWrapper {
		Iterator<String> it;
		int index;

		public IteraratorWrapper(Iterator<String> it, int index) {
			super();
			this.it = it;
			this.index = index;
		}

		@Override
		public String toString() {
			return "[index=" + index + "]";
		}

	}

	static class ElementWrapper {
		String element;
		int eIndex;

		public ElementWrapper(String element, int eIndex) {
			super();
			this.element = element;
			this.eIndex = eIndex;
		}

		@Override
		public String toString() {
			return "(" + element + ", " + eIndex + ")";
		}

	}

	@Test
	public void k_sorted_list() {
		List<List<String>> sortedLists = Utils.sortedLists();
		System.out.println(k_sortedList(sortedLists));
	}

	@Test
	public void k_sorted_list_small() {
		List<List<String>> sortedLists = Arrays.asList(Arrays.asList("a", "b", "c", "d"),
				Arrays.asList("g", "h", "i", "J"), Arrays.asList("x", "y"));

		System.out.println(k_sortedList(sortedLists));
	}

	public List<String> k_sortedList(List<List<String>> sortedLists) {

		PriorityQueue<ElementWrapper> minQ = new PriorityQueue<>(sortedLists.size(),
				(a, b) -> a.element.compareTo(b.element));

		List<IteraratorWrapper> sortListWraps = new ArrayList<>();
		int i = 0;
		for (List<String> sortList : sortedLists) {
			sortListWraps.add(new IteraratorWrapper(sortList.iterator(), i++));
		}
		i--;
		while (i >= 0) {
			IteraratorWrapper itwrap = sortListWraps.get(i);
			Iterator<String> it = itwrap.it;
			if (it.hasNext()) {
				minQ.offer(new ElementWrapper(it.next(), itwrap.index));
			}
			i--;
		}
		System.out.println(minQ);
		List<String> result = new ArrayList<>();
		while (!minQ.isEmpty()) {
			ElementWrapper e = minQ.poll();
			result.add(e.element);
			IteraratorWrapper itwrap = sortListWraps.get(e.eIndex);
			Iterator<String> it = itwrap.it;
			if (it.hasNext()) {
				minQ.offer(new ElementWrapper(it.next(), e.eIndex));
			}
		}
		return result;
	}

}
