package com.algo.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class MergeIntervalOverlapping {
	
	@Test
	public void testMerge() {
		List<Interval> l = new ArrayList<>();
		l.add(new Interval(1, 3));
		l.add(new Interval(2, 6));
		l.add(new Interval(8, 10));
		l.add(new Interval(15, 18));
		System.out.println(merge(l));
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}

	}

	public List<Interval> merge(List<Interval> l) {
		if (l.isEmpty() || l.size() == 1) {
			return l;
		}
		java.util.Collections.sort(l, new IntervalComparator());
		Interval last = null;
		int j = l.size() - 1;
		for (int i = j; i >= 0; i--) {
			Interval e = l.get(i);
			if (last == null || e.end < last.start) {
				last = e;
				swap(l, i, j--);
			} else {
				last.start = Math.min(last.start, e.start);
				last.end = Math.max(last.end, e.end);
			}
		}
		return l.subList(++j, l.size());
	}

	static void swap(List<Interval> l, int from, int to) {
		if (from == to)
			return;
		Interval t = l.get(from);
		l.set(from, l.get(to));
		l.set(to, t);
	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval one, Interval other) {
			if (one.end != other.end)
				return one.end < other.end ? -1 : 1;
			return one.start == other.start ? 0 :one.start < other.start ? 1 : -1;
		}

	}

}
