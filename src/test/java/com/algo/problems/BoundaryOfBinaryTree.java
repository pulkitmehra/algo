package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class BoundaryOfBinaryTree {
	

	@Test
	public void testPrint() {
		Tree.print(Tree.epi());
	}

	@Test
	public void printExteriot() {
		List<Integer> l = new ArrayList<>();
		TNode root = Tree.epi();
		l.add(root.val);
		helperL(root.left, l);
		helperR(root.right, l);
		System.out.println(l);
	}

	

	public void helperL(TNode n, List<Integer> l) {
		if(n!=null) {
			l.add(n.val);
			helperL(n.left, l);
			findLeafsInBranch(n.right, l);						
		}
	}
	
	public void helperR(TNode n, List<Integer> l) {
		if(n!=null) {
			l.add(n.val);
			helperR(n.right, l);
			findLeafsInBranch(n.left, l);						
		}
	}

	public void findLeafsInBranch(TNode n, List<Integer> l) {
		if (n != null) {
			if (n.left == null && n.right == null) {
				l.add(n.val);
			}
			findLeafsInBranch(n.left, l);
			findLeafsInBranch(n.right, l);
		}
	}

}
