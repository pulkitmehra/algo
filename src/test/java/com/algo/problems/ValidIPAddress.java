package com.algo.problems;

import org.junit.Test;

public class ValidIPAddress {

	@Test
	public void validIps() {
		String s = "19216811";

		for (int i = 1; i < s.length() && i < 4; ++i) {
			String first = s.substring(0, i);
			if (isValid(first)) {
				for (int j = 1; j < 4 && i + j < s.length(); ++j) {
					String second = s.substring(i, i + j);
					if (isValid(second)) {
						for (int k = 1; i + j + k < s.length() && k < 4; k++) {
							String third = s.substring(i + j, i + j + k);
							String fourth = s.substring(i + j + k, s.length());
							if (isValid(third) && isValid(fourth)) {
								System.out.println(first + "." + second + "." + third + "." + fourth);
							}
						}
					}
				}
			}
		}
	}

	private boolean isValid(String s) {
		if (s.length() > 3) {
			return false;
		}
		if (s.length() > 1 && s.charAt(0) == '0') {
			return false;
		}
		int v = Integer.parseInt(s);
		return v > 0 && v < 255;
	}

}
