package com.algo.problems;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class SymetricTree {

	@Test
	public void print() {
		TNode symTree = Tree.symTree();
		Tree.print(symTree);
	}

	@Test
	public void copyMirrorImage() {
		TNode symTree = Tree.symTree();
		TNode mirror = copyLikeMirror(symTree);

		// mirror.left.left.right = TNode.get(88);

		Tree.print(mirror);
		System.out.println(isEqual(symTree, mirror));
	}

	@Test
	public void withoutCopySymettricTest() {
		TNode symTree = Tree.symTree();
		symTree.left.left.right = TNode.get(88);
		System.out.println(isEqualWithoutCopy(symTree.left, symTree.right));
	}

	public boolean isEqualWithoutCopy(TNode t1, TNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 != null && t2 != null) {
			return t1.val == t2.val && isEqualWithoutCopy(t1.left, t2.right) && isEqualWithoutCopy(t1.right, t2.left);
		}
		return false;
	}

	private boolean isEqual(TNode symTree, TNode mirror) {
		if (symTree == null && mirror == null) {
			return true;
		} else if (symTree != null && mirror != null) {
			return symTree.val == mirror.val && isEqual(symTree.left, mirror.left)
					&& isEqual(symTree.right, mirror.right);
		}
		return false;
	}

	public TNode copyLikeMirror(TNode n) {
		if (n == null) {
			return null;
		}
		TNode c = TNode.get(n.val);
		c.left = copyLikeMirror(n.right);
		c.right = copyLikeMirror(n.left);
		return c;
	}

}
