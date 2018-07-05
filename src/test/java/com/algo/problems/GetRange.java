package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

public class GetRange {
	
	@Test
	public void testRange() {
		int[] arr = new int[] {5,7,7,8,8,10};
		int[] searchRange = searchRange(arr, 8);
		System.out.println(Arrays.toString(searchRange));
	}

	public int[] searchRange(int[] nums, int target) {
		int found = searchNumber(nums, target, 0, nums.length - 1);
		if (found == -1) {
			return new int[] { -1, -1 };
		}
		int left = findRange(nums, target, 0, found - 1, 0);
		int right = findRange(nums, target, found + 1, nums.length - 1,1);
		
		return new int[] {left!=-1? left: found, right !=-1? right: found};
	}

	int findRange(int[] arr, int n, int s, int e, int direction) {
		if(e < s) {
			return -1;
		}
		if (s == e) {
			if (arr[s] == n) {
				return s;
			}
			return -1;
		}
		int m = s + (e - s) / 2;
		if (n < arr[m]) {
			return findRange(arr, n, s, m - 1, direction);
		} else if (n > arr[m]) {
			return findRange(arr, n, m + 1, e, direction);
		} else {
			if (direction == 0) {
				int find = findRange(arr, n, s, m - 1, direction);
				return find != -1 ? find : m;
			} else {
				int find = findRange(arr, n, m + 1, e, direction);
				return find != -1 ? find : m;
			}
		}

	}

	int searchNumber(int[] arr, int n, int s, int e) {
		if(e < s) {
			return -1;
		}
		if (s == e) {
			if (arr[s] == n) {
				return s;
			}
			return -1;
		}

		int m = s + (e - s) / 2;
		if (n < arr[m]) {
			return searchNumber(arr, n, s, m - 1);
		} else if (n > arr[m]) {
			return searchNumber(arr, n, m + 1, e);
		} else {
			return m;
		}
	}

}
