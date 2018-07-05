package com.algo.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PallindromeTest {
	
	@Test
	public void pallindromeTest() {
		isPalindrome("0P");
	}

	
	public boolean isPalindrome(String s) {
		int i = 0; 
		int j = s.length() - 1;
			while (i < j) {
			if (normalize(s.charAt(i)) == 0) {
				i++;
				continue;
			}
			if (normalize(s.charAt(j)) == 0) {
				j--;
				continue;
			}
			if (normalize(s.charAt(i)) == normalize(s.charAt(j))) {
				i++;
				j--;
				continue;
			}else {
				return false;
			}
		}
		
		return true;
	}
	
	private char normalize(char c) {
		if (c >= 97 && c <= 122) {
			return (char)(c - 32);
		}else if ((c >= 48 && c <=57) || (c >= 65 && c <=90)) {
			return c;
		}else {
			return 0;
		}
	}
}
