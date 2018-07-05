package com.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;

public class Collections2 {

	@Test
	public void linkedListIterator() {
		LinkedList<String> l = new LinkedList<>();
		l.add("a");
		l.add("b");
		l.add("b");
		l.add("d");

		ListIterator<String> it1 = l.listIterator();
		ListIterator<String> it2 = l.listIterator();
		it2.next();

		while (it2.hasNext()) {
			String a = peek(it2);
			String b = peek(it1);
			if (a.equals(b)) {
				it2.remove();
			}
			it1.next();
			it2.next();
		}
		System.out.println(l);

	}

	private String peek(ListIterator<String> it) {
		if (it.hasNext()) {
			String val = it.next();
			it.previous();
			return val;
		}
		return null;
	}

	@Test
	public void comparatorTest() {
		List<Interval> l = new ArrayList<>();
		l.add(Interval.of(-3, -2));
		l.add(Interval.of(-2, -1));
		l.add(Interval.of(1, 2));
		l.add(Interval.of(0, 1));
		l.add(Interval.of(-2, 2));

		java.util.Collections.sort(l);
		System.out.println(l);
	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval one, Interval other) {
			if (one.e != other.e)
				return one.e < other.e ? -1 : 1;
			return one.s < other.s ? 1 : -1;
		}

	}

	@Test
	public void removeif() {
		List<Integer> l;
		// l.removeIf(filter)
	}

	@Test
	public void computeIfAbsentTest() {
		Map<Integer, Integer> m = new HashMap<>();

		m.computeIfAbsent(1, (e) -> 1);
		m.computeIfAbsent(1, (e) -> 1);
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.computeIfAbsent(1, (e) -> new ArrayList<>()).add(1);
		map.computeIfAbsent(1, (e) -> new ArrayList<>()).add(1);
		System.out.println(map);
	}

	static class Interval implements Comparable<Interval> {
		int s;
		int e;

		public static Interval of(int s, int e) {
			Interval i = new Interval();
			i.s = s;
			i.e = e;
			return i;
		}

		@Override
		public int compareTo(Interval other) {
			if (e != other.e)
				return e < other.e ? -1 : 1;
			return s < other.s ? 1 : -1;
		}

		@Override
		public String toString() {
			return "[" + s + "," + e + "]";
		}

	}

}
