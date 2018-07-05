package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.algo.DivideAndConquer;

/**
 * Given a array, find an array which has maximum sum. It can be solved by DnQ.
 * with righting merge routine which finds longest subarry in left , right and
 * crossing middle
 * 
 * @author pulkitmehra
 *
 */
@DivideAndConquer
public class MaximumSubarrayProblem {

	@Test
	public void maximumSubarray() {
		int[] arr = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		// int[] arr = new int[] { 1, -3, 2, 1, 2, -1 };
		int[] ans = findMaxSubarray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(ans));
		System.out.println(Arrays.toString(bruteForce(arr)));
	}

	public int[] bruteForce(int[] arr) {
		int main_sum = Integer.MIN_VALUE;
		int mri = -1;
		int mli = -1;
		for (int i = 0; i < arr.length - 1; i++) {

			int max_l_sum = arr[i];
			int sum = 0;
			int ri = i;
			int li = i;
			for (int j = i; j >= 0; j--) {
				if (i == j) {
					continue;
				}
				sum += arr[j];
				if (sum > max_l_sum) {
					max_l_sum = sum;
					li = j;
				}
			}
			if (max_l_sum > main_sum) {
				main_sum = max_l_sum;
				mri = ri;
				mli = li;
			}
		}
		return new int[] { mli, mri, main_sum };
	}

	/**
	 * nlogn
	 */
	public int[] findMaxSubarray(int[] arr, int s, int e) {
		if (s == e) {
			return new int[] { s, e, arr[s], -1 };
		}
		int m = s + ((e - s) / 2);
		int[] left = findMaxSubarray(arr, s, m);
		int[] right = findMaxSubarray(arr, m + 1, e);
		int[] cross = findCross(arr, s, m, e);

		if (left[2] > right[2] && left[2] > cross[2]) {
			return left;
		} else if (right[2] > left[2] && right[2] > cross[2]) {
			return right;
		} else {
			return cross;
		}
	}

	public int[] findCross(int[] arr, int s, int m, int e) {
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		int left_index = m;
		for (int i = m; i >= s; i--) {
			sum += arr[i];
			if (sum > left_sum) {
				left_sum = sum;
				left_index = i;
			}
		}

		int right_index = m + 1;
		int right_sum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = m + 1; i <= e; i++) {
			sum += arr[i];
			if (sum > right_sum) {
				right_sum = sum;
				right_index = i;
			}
		}
		return new int[] { left_index, right_index, left_sum + right_sum, -2 };
	}
}
