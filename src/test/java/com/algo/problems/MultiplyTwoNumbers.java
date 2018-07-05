package com.algo.problems;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.Test;

public class MultiplyTwoNumbers {
	int[] a = { 1, 9, 3, 7, 0, 7, 7, 2, 1 };
	int[] b = { -7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7 };

	@Test
	public void multiplyTwoNumbers() {
		int[] big = a.length > b.length ? a : b;
		int[] small = a.length <= b.length ? a : b;

		LinkedList<Integer> res = new LinkedList<>();

		for (int i = small.length - 1; i >= 0; i--) {
			LinkedList<Integer> ans = multiply(big, small[i]);
			System.out.println("ans:" + ans);
			addToResult(ans, res, small.length - 1 - i);
			System.out.println("res:" + res);
		}

	}

	private void addToResult(LinkedList<Integer> ans, LinkedList<Integer> res, int i) {
		ListIterator<Integer> rit = res.listIterator(res.size());
		while (rit.hasPrevious() && i != 0) {
			rit.previous();
			i--;
		}

		int c = 0;
		ListIterator<Integer> ait = ans.listIterator(ans.size());
		while (ait.hasPrevious()) {
			if (rit.hasPrevious()) {
				int s = Math.abs(ait.previous()) + Math.abs(rit.previous()) + c;
				c = s / 10;
				rit.set(s % 10);
			} else {
				int s = Math.abs(ait.previous()) + c;
				c = s / 10;
				rit.add(s % 10);
				rit.previous();
			}
		}
		if (c > 0) {
			res.addFirst(c);
		}
	}

	private LinkedList<Integer> multiply(int[] big, int n) {
		int c = 0;
		LinkedList<Integer> ans = new LinkedList<>();
		for (int j = big.length - 1; j >= 0; j--) {
			int s = Math.abs((big[j]) * n) + c;
			c = s / 10;
			ans.addFirst(s % 10);
		}
		if (c > 0) {
			ans.addFirst(c);
		}
		return ans;
	}
}
