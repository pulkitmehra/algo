package com.algo.problems;

import org.junit.Test;

import com.ds.Utils;

public class ReverseStringAndWords {

	String a = "how are you";
	String b = "a b c";

	@Test
	public void reverseAString() {
		char[] arr = b.toCharArray();

		for (int i = 0, j = arr.length - 1; i < j; ++i, --j) {
			Utils.swap(arr, i, j);
		}

		int i = 0, j = 0, k = 0;
		while (j < arr.length) {
			i = j;
			while (arr[j] != ' ') {
				k = j++;
				if (j == arr.length) {
					break;
				}
			}
			while (i < k) {
				Utils.swap(arr, i, k);
				i++; k--;
			}
			j++;
			i = j;
		}
		System.out.println(String.valueOf(arr));
	}

}
