package com.algo.problems;

import org.junit.Test;

public class LastOccuranceInDuplicateSortedArray {
	
	
	@Test
	public void LastOccuranceInDuplicateSortedArray() {
		int[] arr = new int[] { 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 7 };
		int n = 1;
		int mid = findNum(arr, n, 0, arr.length - 1);
		if (arr[mid] == n) {
			System.out.println("found " + arr[mid] + " at " + mid);
			if (mid + 1 <= arr.length - 1)
				System.out.println("next number is " + arr[mid + 1]);
		} else {
			System.out.println("Not Found");
		}
	}
	

	public int findNum(int[] arr, int n, int s, int e) {
		int m = s + (e - s) / 2;
		if((m == e && arr[m] == n) || (arr[m] == n && arr[m+1] > n))
            return m;
		if (arr[m] <= n) {
			return findNum(arr, n, m + 1, e);
		}
		return findNum(arr, n, s, m-1);
	}

}
