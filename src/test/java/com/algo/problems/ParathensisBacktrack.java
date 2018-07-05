package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParathensisBacktrack {

	@Test
	public void test_backtrackParanthesis() {
		int k = 3;
		List<String> bktrk = new ArrayList<>();
		List<List<String>> ans = new ArrayList<>();

		backtrack(k, k, bktrk, ans);
		for (List<String> list : ans) {
			System.out.println(list);
		}
	}

	private void backtrack(int l, int r, List<String> bktrk, List<List<String>> ans) {
		if (l > r) {
			return;
		}
		if (l == 0 && r == 0) {
			ans.add(new ArrayList<>(bktrk));
			return;
		}
		if (l - 1 >= 0) {
			bktrk.add("{");
			backtrack(l - 1, r, bktrk, ans);
			bktrk.remove(bktrk.size() - 1);
		}
		if (r - 1 >= 0) {
			bktrk.add("}");
			backtrack(l, r - 1, bktrk, ans);
			bktrk.remove(bktrk.size() - 1);
		}
		
	}

}
