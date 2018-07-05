package com.algo.problems;

import org.junit.Test;

import com.algo.DynamicProblem;

/**
 * Longest increasing subsequence is [2,1,4,3,5]
 * 2->4->5 is increasing subsequence
 * 
 * @author pulkitmehra
 *
 */
@DynamicProblem
public class LongestIncreasingSubSequence {

	/**
	 * Best explained by:
	 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-300-longest-increasing-subsequence/
	 */
	@Test
	public void longestIncSequenceTopDownNSqr() {
		int[] arr = new int[] { -2, -1 };
		int[] memo = new int[arr.length];
		int ans = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			ans = Math.max(ans, lis(arr, i, memo));
		}
		System.out.println(ans);
	}

	@Test
	public void longestIncSequenceBottomUpNSqr() {

	}

	/**
	 * Best explained in
	 * https://stackoverflow.com/questions/4938833/find-longest-increasing-sequence
	 */
	@Test
	public void longestIncSequenceBinSearchNlogn() {
	}

	int lis(int[] arr, int r, int[] memo) {
		if (r == 0) {
			return 1;
		}
		if (memo[r] != 0) {
			return memo[r];
		}

		int ans = 1;
		for (int i = 0; i < r; i++) {
			if (arr[r] > arr[i]) {
				ans = Math.max(ans, 1 + lis(arr, i, memo));
			}
		}
		memo[r] = ans;
		return ans;

	}

}
