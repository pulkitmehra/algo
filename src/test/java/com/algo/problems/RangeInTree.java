package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class RangeInTree {

	@Test
	public void rangx() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		List<Integer> range = new ArrayList<>();
		range(epi, 3, 17, range);
		System.out.println(range);
	}

	public void range(TNode n, int lo, int hi, List<Integer> list) {
		if (n == null)
			return;
		if (n.val < lo)
			return;
		range(n.left, lo, hi, list);
		if (n.val <= hi) {
			list.add(n.val);
			range(n.right, lo, hi, list);
		}
	}

}
