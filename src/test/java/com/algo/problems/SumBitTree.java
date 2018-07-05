package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class SumBitTree {

	int sum;

	@Test
	public void print() {
		TNode bitTree = Tree.bitTree();
		Tree.print(bitTree);
		sumTree(bitTree, "");
		System.out.println(sum);
	}
	
	@Test
	public void sum2() {
		TNode bitTree = Tree.bitTree();
		Tree.print(bitTree);
		List<List<Integer>> ans=new ArrayList<>();
		sumTree2(bitTree, new ArrayList<>(), ans);
		for (List<Integer> list : ans) {
			System.out.println(list);
		}
	}

	public void sumTree(TNode n, String backTrack) {
		if (n != null) {
			if (n.left == null && n.right == null) {
				sum += Integer.parseInt(backTrack + n.val, 2);
				return;
			}
			backTrack += n.val;
			sumTree(n.left, backTrack);
			sumTree(n.right, backTrack);
		}
	}

	public void sumTree2(TNode n, List<Integer> backTrack, List<List<Integer>> ans) {
		if (n != null) {
			if (n.left == null && n.right == null) {
				backTrack.add(n.val);
				ans.add(new ArrayList<>(backTrack));
				backTrack.remove(backTrack.size() - 1);
				return;
			}
			backTrack.add(n.val);
			sumTree2(n.left, backTrack, ans);
			sumTree2(n.right, backTrack, ans);
			backTrack.remove(backTrack.size() - 1);
		}
	}

}
