package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpiralOrder {

	int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	@Test
	public void writespiral() {
		int m = 4;
		int n = 3;

		int[][] board = new int[m][n];

		int y = 0;
		int x = 0;

		int total = m * n;
		int i = 1, d = 0;

		while (i <= total) {
			int[] r = directional(board, delta[d], y, x, i);
			i = r[2];
			y = r[0];
			x = r[1];
			d = (d + 1) % 4;
			y = y + delta[d][0];
			x = x + delta[d][1];
			i++;
		}

		for (int j = 0; j < board.length; j++) {
			for (int k = 0; k < board[j].length; k++) {
				System.out.print(board[j][k] + ",");
			}
			System.out.println();
		}
	}

	int[] directional(int[][] board, int[] d, int y, int x, int i) {
		while (y >= 0 && y <= board.length - 1 && x >= 0 && x <= board[y].length - 1 && board[y][x] == 0) {
			board[y][x] = i++;
			y = y + d[0];
			x = x + d[1];
		}
		return new int[] { y - d[0], x - d[1], --i };
	}

	@Test
	public void readSpiralOrder() {

		int[][] board3 = { { 1, 2, 3, 4, 5 }, { 14, 15, 16, 17, 6 }, { 13, 20, 19, 18, 7 }, { 12, 11, 10, 9, 8 } };
		int[][] board = { { 1, 2, 3, 4, 5 }, { 10, 9, 8, 7, 6 } };

		int m = board.length;
		int n = board[m - 1].length;
		int total = m * n;
		int d = 0, i = 1, y = 0, x = 0;
		List<Integer> list = new ArrayList<>();

		while (i <= total) {
			int[] di = delta[d];

			while (y >= 0 && y <= board.length - 1 && x >= 0 && x <= board[y].length - 1 && board[y][x] != -1) {
				list.add(board[y][x]);
				board[y][x] = -1;
				y = y + di[0];
				x = x + di[1];
				i++;
			}

			y = y - di[0];
			x = x - di[1];
			d = (d + 1) % 4;

			y = y + delta[d][0];
			x = x + delta[d][1];
		}
		System.out.println(list);
	}

}
