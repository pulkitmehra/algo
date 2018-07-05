package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class ExteriorOfTree {

	@Test
	public void exteriorOftree() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		List<Integer> ans = new ArrayList<>();
		ans.add(epi.val);
		addLeftTree(epi.left, ans);
		addRightTree(epi.right, ans);
		System.out.println(ans);
	}

	private void addLeftTree(TNode l, List<Integer> ans) {
		if (l != null) {
			ans.add(l.val);
			addLeftTree(l.left, ans);
			addLeaves(l.right, ans);
		}
	}

	private void addRightTree(TNode r, List<Integer> ans) {
		if (r != null) {
			addLeaves(r.left, ans);
			addRightTree(r.right, ans);
			ans.add(r.val);
		}
	}

	public void addLeaves(TNode r, List<Integer> ans) {
		if (r != null) {
			if (r.left == null && r.right == null) {
				ans.add(r.val);
			} else {
				addLeaves(r.left, ans);
				addLeaves(r.right, ans);
			}
		}
	}

}
