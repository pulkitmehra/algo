package com.algo.problems;

import org.junit.Test;

public class BaseConversion {

	@Test
	public void baseConversion() {
		System.out.println(convertToBase("1100", 2, 3));
	}

	@Test
	public void baseConversionBig() {
		System.out.println(convertToBase("6B4", 12, 13));
	}

	public String convertToBase(String s, int src, int dst) {
		int base10 = toBase10(s, src);
		System.out.println(base10);
		return toBaseX(base10, dst);
	}

	private String toBaseX(int base10, int base) {

		StringBuilder b = new StringBuilder();
		while (base10 != 0) {
			int rem = base10 % base;
			if (rem > 9) {
				b.append((char) ('A' + (rem - 10)));
			} else {
				b.append(rem);
			}
			base10 = base10 / base;
		}

		return b.reverse().toString();
	}

	private int toBase10(String s, int base) {
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			int num = 0;
			if (Character.isDigit(c)) {
				num = c - '0';
			} else {
				num = (c - 'A') + 10;
			}
			sum += num * Math.pow(base, s.length() - 1 - i);
		}
		return sum;
	}

}
