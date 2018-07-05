package com.algo.problems;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class BuildTreeFromPreorderDistinct {

	@Test
	public void preOrderDistinct() {
		int[] arr = { 43, 23, 37, 29, 31, 41, 47, 53 };
		TNode buildTree = buildTree(arr, 0, arr.length - 1);
		Tree.print(buildTree);
	}

	public TNode buildTree(int[] arr, int lo, int hi) {
		if (hi < lo)
			return null;
		int v = arr[lo];
		int m = lo;
		while (m + 1 <= hi && arr[m + 1] < v) {
			m = m + 1;
		}
		TNode n = TNode.get(v);
		n.left = buildTree(arr, lo + 1, m);
		n.right = buildTree(arr, m + 1, hi);
		return n;
	}

}
