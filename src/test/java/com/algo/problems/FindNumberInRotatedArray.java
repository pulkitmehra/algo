package com.algo.problems;

import org.junit.Test;

public class FindNumberInRotatedArray {

	@Test
	public void test() {
		int[] arr = new int[] {4,5,6,7,0,1,2};
		System.out.println(search(arr, 0));
	}
	
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		System.out.println("Go");
		return find(nums, target, 0, nums.length - 1);
	}

	public int find(int[] arr, int t, int s, int e) {
		if (s > e) {
			System.out.println("Return " + s + "," + e);
			return -1;
		}

		int m = s + (e - s) / 2;

		if (arr[m] == t) {
			System.out.println("Got it");
			return m;
		}
		int i = -1;
		if (arr[s] > arr[m] || (t < arr[m] && t >= arr[s])) {
			i = find(arr, t, s, m);

		}
		if (i == -1 && ((arr[m] > arr[e]) || (t > arr[m] && t <= arr[e]))) {
			i = find(arr, t, m + 1, e);
		}
		return i;
	}

}
