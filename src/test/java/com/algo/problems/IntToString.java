package com.algo.problems;

import org.junit.Test;

public class IntToString {

	@Test
	public void intToString() {
		int x = 123;

		StringBuilder s = new StringBuilder();

		while (x != 0) {
			s.append(Math.abs(x % 10));
			x = x / 10;
		}
		System.out.println(s.reverse().toString());
	}

	@Test
	public void stringToInt() {
		String x = "-123";
		boolean isNeg = false;
		int len = x.length();
		int i = 0;
		if (x.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}
		int sum = 0, pow=0;
		for (int j = len - 1; j >= i; j--) {
			sum += (x.charAt(j) - '0') * Math.pow(10, pow++);
		}
		System.out.println(isNeg ? -1* sum : sum);

	}

}
