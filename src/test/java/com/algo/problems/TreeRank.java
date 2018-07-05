package com.algo.problems;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

/**
 * 
 * 
 * 
 * @author pulkitmehra
 *
 */
public class TreeRank {

	@Test
	public void test() {
		TNode epi = Tree.epi();
		//Tree.print(epi);
	}

	@Test
	public void findRank() {

	}

	int rank = 0;

	@Test
	public void findNodeInRank() {
		TNode epi = Tree.epi();
		System.out.println(rank(18,epi));
	}


	public TNode rank(int r, TNode n) {
		if (n != null) {
			TNode node = rank(r, n.left);
			if (node != null) {
				return node;
			}
			rank++;
			if (rank == r) {
				return n;
			}
			return rank(r, n.right);

		}
		return null;
	}
}
