package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Permutations {

	String s = "abc";

	@Test
	public void sol1ByReplacingAtEachLevel() {
		List<String> ans = new ArrayList<>();
		permutateByReplacing(0, s.length() - 1, s.toCharArray(), ans);
		System.out.println(ans);
	}

	@Test
	public void permutayte2() {
		List<String> ans = new ArrayList<>();
		permutateBySubString(s, "", ans);
		System.out.println(ans);
	}

	private void permutateBySubString(String word, String iter, List<String> ans) {
		if (word.equals("")) {
			ans.add(iter);
		} else {
			for (int i = 0; i < word.length(); i++) {
				String left = word.substring(0, i);
				String right = word.substring(i + 1, word.length());
				permutateBySubString(left + right, iter + word.charAt(i), ans);
			}
		}

	}

	private void permutateByReplacing(int i, int j, char[] charArray, List<String> ans) {
		if (i == j) {
			ans.add(String.valueOf(charArray));
		} else {
			for (int k = i; k <= j; k++) {
				swap(charArray, i, k);
				permutateByReplacing(i + 1, j, charArray, ans);
				swap(charArray, k, i);
			}
		}

	}

	private void swap(char[] charArray, int i, int k) {
		if (i == k)
			return;
		char t = charArray[i];
		charArray[i] = charArray[k];
		charArray[k] = t;
	}

}
