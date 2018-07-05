package com.algo.problems;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import com.ds.Tree.TNode;

public class GenerateAllBinaryTree {

	@Test
	public void generateBinaryTree() {
		List<TNode> nodes = generateBinaryTree(4);
		System.out.println(nodes);
	}

	private List<TNode> generateBinaryTree(int i) {
		List<TNode> nodes = new ArrayList<>();
		if(i==0) {
			nodes.add(null);
		}
		for (int j = 0; j < i; j++) {
			List<TNode> leftTree = generateBinaryTree(j);
			List<TNode> rightTree = generateBinaryTree(i-1-j);
			
			for (TNode left : leftTree) {
				for (TNode right : rightTree) {
					TNode tNode = TNode.get(0);
					tNode.left=left;
					tNode.right=right;
					nodes.add(tNode);
				}
			}
		}
		return nodes;
	}
}
