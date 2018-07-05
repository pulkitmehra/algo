package com.algo.problems;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class LeastCommonAncestorUsingMap {

	@Test
	public void test() {
		TNode root = Tree.epi();
		Tree.print(root);
		Map<Integer, TNode> map = new HashMap<>();
		createParentMap(root, map);
		System.out.println(map);

		int i = 12;
		int j = 16;
		if (map.get(i) == null) {
			System.out.println(root);
			return;
		}
		if (map.get(j) == null) {
			System.out.println(root);
			return;
		}
		TNode p = map.get(j);
		TNode q = map.get(j);
		while (p != q) {
			if (map.get(p.val) == null || map.get(q.val) == null) {
				System.out.println(root);
				return;
			}
			p = map.get(p.val);
			q = map.get(q.val);
		}
		System.out.println(p);

	}

	public TNode createParentMap(TNode n, Map<Integer, TNode> map) {
		if (n != null) {
			if (n.left != null) {
				TNode l = createParentMap(n.left, map);
				map.put(l.val, n);
			}
			if (n.right != null) {
				TNode r = createParentMap(n.right, map);
				map.put(r.val, n);
			}
			return n;
		}
		return null;
	}

}
