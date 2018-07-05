package com.algo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class IntervalHeight {

	int[][] arr = { { 1, 5 }, { 2, 7 }, { 4, 5 }, { 6, 10 }, { 8, 9 }, { 11, 13 }, { 14, 15 }, { 12, 15 }, { 9, 17 },
			{ 13, 14 } };

	@Test
	public void intervalHeight() {
		List<Interval> list = get();
		int max = 0, local = 1, i = 0;

		Interval prev = list.get(i);
		i++;
		while (i < list.size()) {
			Interval curr = list.get(i);
			if (prev.e < curr.s) {
				local = 0;
				prev = curr;
			} else {
				prev.s = Math.min(prev.s, curr.s);
				prev.e = Math.max(prev.e, curr.e);
				max = Math.max(++local, max);
			}
			i++;
		}
		System.out.println("height " + max);
	}

	public List<Interval> get() {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			intervals.add(new Interval(arr[i][0], arr[i][1]));
		}
		Collections.sort(intervals);
		return intervals;
	}

	static class Interval implements Comparable<Interval> {

		int s, e;

		Interval(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Interval o) {
			if (s == o.s) {
				return s < o.s ? -1 : 1;
			}
			return o.e == e ? 0 : o.e > e ? -1 : 1;
		}

	}

}
