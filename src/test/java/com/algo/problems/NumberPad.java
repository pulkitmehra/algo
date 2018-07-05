package com.algo.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class NumberPad {
	char[][] pad = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, };

	@Test
	public void usingReccursion() {
		String number = "23";
		List<String> ans = new ArrayList<>();
		char[] arr = new char[number.length()];
		permutate(ans, arr, number, 0);
		System.out.println(ans);
	}

	private void permutate(List<String> ans, char[] arr, String number, int digit) {
		if (digit == number.length()) {
			ans.add(String.valueOf(arr));
		} else {
			char[] options = pad[Integer.valueOf(number.substring(digit, digit + 1))];
			for (int j = 0; j < options.length; j++) {
				arr[digit] = options[j];
				permutate(ans, arr, number, digit + 1);
			}
		}
	}

	@Test
	public void usingNormal() {
		String number = "23";
		Queue<String> q = new LinkedList<>();
		q.add("");
		for (int i = 0; i < number.length(); i++) {
			char[] arr = pad[Integer.valueOf(number.substring(i, i + 1))];
			findPerm(q, i + 1, arr);
		}
		System.out.println(q);
	}

	private void findPerm(Queue<String> q, int digit, char[] arr) {
		while (q.peek().length() != digit) {
			String e = q.poll();
			for (char c : arr) {
				q.offer(e + String.valueOf(c));
			}
		}
	}
}
