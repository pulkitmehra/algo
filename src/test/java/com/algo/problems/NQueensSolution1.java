package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NQueensSolution1 {

	@Test
	public void testNQueens() {
		List<List<String>> solveNQueens = solveNQueens(4);
		for (List<String> list : solveNQueens) {
			System.out.println(list);
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> ans = new ArrayList<>();
		int[][] board = new int[n][n];
		placeQueens(n, 0, board, ans);
		return ans;
	}

	public void placeQueens(int n, int i, int[][] board, List<List<String>> ans) {
		if (n == i) {
			StringBuilder s = new StringBuilder();
			List<String> l = new ArrayList<>();
			for (int p = 0; p < board.length; p++) {
				for (int q = 0; q < board[p].length; q++) {
					if (board[p][q] == 1) {
						s.append('Q');
					} else {
						s.append('.');
					}
				}
				l.add(s.toString());
				s = new StringBuilder();
			}
			ans.add(l);

		} else {
			for (int j = 0; j < n; j++) {
				board[i][j] = 1;
				if (canPlace(board, i, j)) {
					placeQueens(n, i + 1, board, ans);
				}
				board[i][j] = 0;
			}
		}
	}

	public boolean canPlace(int[][] board, int y, int x) {
		// check column
		for (int i = 0; i < board.length; i++) {
			if (board[i][x] == 1 && i != y) {
				return false;
			}
		}

		// check row
		for (int i = 0; i < board[y].length; i++) {
			if (board[y][i] == 1 && i != x) {
				return false;
			}
		}

		// check upper left diagonal
		for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check upper right diaginal
		for (int i = y - 1, j = x + 1; i >= 0 && j < board[y].length; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

}
