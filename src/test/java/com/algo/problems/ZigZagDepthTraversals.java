package com.algo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class ZigZagDepthTraversals {

	@Test
	public void treeTest() {
		TNode epi = Tree.minesm();
		Tree.print(epi);
	}

	Map<Integer, List<Integer>> map = new HashMap<>();

	@Test
	public void depthTraversal() {
		TNode r = Tree.minesm();
		Tree.print(r);
		dt(r, 1);
		Set<Entry<Integer, List<Integer>>> entrySet = map.entrySet();
		for (Entry<Integer, List<Integer>> entry : entrySet) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

	@Test
	public void zigZag() {
		TNode r = Tree.minesm();
		Tree.print(r);
		zigzag(r, 1);
		Set<Entry<Integer, List<Integer>>> entrySet = map.entrySet();
		for (Entry<Integer, List<Integer>> entry : entrySet) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

	public void dt(TNode r, int l) {
		if (r == null) {
			return;
		}
		List<Integer> list = map.get(l);
		if (list == null) {
			list = new ArrayList<>();
			map.put(l, list);
		}
		list.add(r.val);
		dt(r.left, l + 1);
		dt(r.right, l + 1);
	}

	public void zigzag(TNode r, int l) {
		if (r == null) {
			return;
		}
		List<Integer> list = map.get(l);
		if (list == null) {
			list = new LinkedList<>();
			map.put(l, list);
		}
		if (l % 2 == 0) {
			list.add(r.val);
		} else {
			list.add(0, r.val);
		}

		zigzag(r.left, l + 1);
		zigzag(r.right, l + 1);
	}

}
