package com.algo.problems;

import org.junit.Test;

public class PalindromicPermutation {

	@Test
	public void testPalidromicPermutationUsingString() {
		String candStr = "rotator";
		System.out.println(isPalidromic(candStr));
	}

	public boolean isPalidromic(String val) {
		int num = 0;
		for (int i = 0; i < val.length(); i++) {
			int offset = val.charAt(i) - 'a';
			boolean isSet = (num >> offset & 1) == 1;
			if (isSet) {
				// turn off to zero
				num = num & ~(1 << offset);
			} else {
				//turn on to 1
				num = num | (1 << offset);
			}
		}
		return num == 0 || (num & (num - 1)) == 0;
	}

}
