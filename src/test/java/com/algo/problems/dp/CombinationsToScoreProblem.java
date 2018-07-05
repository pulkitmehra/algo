package com.algo.problems.dp;

import org.junit.Test;

public class CombinationsToScoreProblem {

	int[] moves = { 1, 2 };
	int score = 4;

	/**
	 * https://www.youtube.com/watch?v=k4y5Pr0YVhg
	 */
	@Test
	public void findTotalMoves() {
		System.out.println(totalWaysToSum(moves, score, 0));
	}

	public int totalWaysToSum(int[] moves, int score, int index) {
		if (score == 0)
			return 1;
		if (score < 0)
			return 0;

		int sum = 0;
		for (int i = index; i < moves.length; i++) {
			sum += totalWaysToSum(moves, score - moves[i], i);
		}
		return sum;
	}

}
