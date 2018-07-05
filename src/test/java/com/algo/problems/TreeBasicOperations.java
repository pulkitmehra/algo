package com.algo.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.ds.Tree;
import com.ds.Tree.TNode;

public class TreeBasicOperations {

	@Test
	public void printOfTree() {
		TNode node = Tree.coreman();
		Tree.print(node);
		Tree.print(Tree.minesm());
		Tree.print(Tree.mineByInsert());
	}

	@Test
	public void rankTest() {
		TNode root = Tree.mineByInsert();
		Tree.print(root);
		System.out.println(rank(root, 65, 0));
	}

	@Test
	public void selectTest() {
		TNode root = Tree.mineByInsert();
		Tree.print(root);
		System.out.println(select(root, 11));
	}

	@Test
	public void predecessorTest() {
		TNode mine = Tree.mine();
		System.out.println(predecessor(mine, 20));
		System.out.println(predecessor(mine, 35));
	}

	@Test
	public void successor() {
		TNode mine = Tree.mine();
		System.out.println(successor(mine, 35));
		System.out.println(successor(mine, 20));
	}

	@Test
	public void deleteTest() {
		TNode mine = Tree.mine();
		Tree.print(mine);
		delete(mine, 15);
		Tree.print(mine);
	}

	@Test
	public void firstKSmallestAndLargestElements() {
		TNode mine = Tree.mine();
		List<Integer> l = new ArrayList<>();
		inorder(mine, l);
		System.out.println(l);
		LinkedList<Integer> list = new LinkedList<>();
		firstSmallestKElements(mine, 5, list);
		System.out.println(list);
		list.clear();
		firstLargestKElements(mine, 5, list);
		System.out.println(list);
	}

	@Test
	public void rangx() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		List<Integer> range = new ArrayList<>();
		range(epi, 3, 17, range);
		System.out.println(range);
	}

	@Test
	public void postOrderTraversal() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		postOrderTraversal(epi);
	}

	@Test
	public void preOrderTraversal() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		preOrderTraversal(epi);
		preOrderTraversalR(epi);
	}
	
	@Test
	public void KthInorderElement() {
		TNode epi = Tree.bstepi();
		Tree.print(epi);
		System.out.println(KthElementInOrder(epi, new AtomicInteger(), 13));
	}

	public TNode search(TNode root, int x) {
		if (root == null) {
			return null;
		}
		if (root.val == x) {
			return root;
		}
		if (x <= root.val) {
			return search(root.left, x);
		}
		return search(root.right, x);
	}

	boolean delete(TNode root, int x) {
		TNode found = search(root, x);
		if (found == null) {
			return false;
		}
		if (found.left == null && found.right == null) {
			transplant(found, null);
		} else if (found.left != null && found.right == null) {
			transplant(found, found.left);
		} else { // we have both children

			if (found.right.left == null && found.right.right == null) {
				transplant(found, found.right);
			} else {
				TNode succesor = successor(root, x);
				if (succesor.right == null) {
					transplant(found, succesor);
					succesor.right = found.right;
				} else {
					transplant(succesor, succesor.right);
					transplant(found, succesor);
					succesor.right = found.right;
					succesor.left = found.left;
					found.left = null;
					found.right = null;
				}
			}
		}
		return true;
	}

	public void transplant(TNode to, TNode from) {
		if (from == null && to.p != null) {
			if (to.p.left == to) {
				to.p.left = null;
			} else {
				to.p.right = null;
			}
		}

		if (to.p != null && from != null) {
			if (to.p.left == to) {
				to.p.left = from;
			} else {
				to.p.right = from;
			}
			from.p = to.p;
		}

	}

	public TNode successor(TNode root, int x) {
		TNode node = search(root, x);
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			TNode n = node.right;
			while (n.left != null) {
				n = n.left;
			}
			return n;
		}

		TNode p = node.p;
		while (p != null) {
			if (p.right != node) {
				return p;
			}
			node = p;
			p = p.p;
		}
		return null;
	}

	public TNode predecessor(TNode root, int x) {
		TNode node = search(root, x);
		if (node == null) {
			return null;
		}
		if (node.left != null) {
			TNode n = node.left;
			while (n.right != null) {
				n = n.right;
			}
			return n;
		}

		TNode p = node.p;
		while (p != null) {
			if (p.right == node) {
				return p;
			}
			node = p;
			p = p.p;
		}
		return null;
	}

	public void firstSmallestKElements(TNode n, int k, List<Integer> list) {
		if (n != null && list.size() < k) {
			firstSmallestKElements(n.left, k, list);
			if (list.size() < k) {
				list.add(n.val);
				firstSmallestKElements(n.right, k, list);
			}
		}

	}

	public TNode KthElementInOrder(TNode n, AtomicInteger c, int k) {
		if (n == null)
			return null;

		TNode l = KthElementInOrder(n.left, c, k);
		if (l != null)
			return l;

		if (c.incrementAndGet() == k) {
			return n;
		}
		return KthElementInOrder(n.right, c, k);
	}

	public void firstLargestKElements(TNode n, int k, LinkedList<Integer> list) {
		if (n != null && list.size() < k) {
			firstSmallestKElements(n.right, k, list);
			if (list.size() < k) {
				list.addFirst(n.val);
				firstSmallestKElements(n.left, k, list);
			}
		}

	}

	public void inorder(TNode n, List<Integer> list) {
		if (n != null) {
			inorder(n.left, list);
			list.add(n.val);
			inorder(n.right, list);
		}
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

	public int rank(TNode n, int r, int rank) {
		if (n == null) {
			return -1;
		}
		if (n.val == r) {
			return rank + 1 + (n.left != null ? n.left.size : 0);
		} else if (r < n.val) {
			return rank(n.left, r, rank);
		}
		return rank(n.right, r, rank + 1 + (n.left != null ? n.left.size : 0));

	}

	public TNode select(TNode n, int s) {
		if (n == null) {
			return null;
		}

		int lc = n.left != null ? n.left.size : 0;
		if (s == (lc + 1)) {
			return n;
		}
		if ((s - 1) < lc) {
			return select(n.left, s);
		}
		return select(n.right, s - lc - 1);
	}

	public void preOrderTraversal(TNode n) {
		Deque<TNode> aux = new ArrayDeque<>();
		aux.add(n);

		while (!aux.isEmpty()) {
			TNode p = aux.pollFirst();
			System.out.print(p.val + ",");
			if (p.right != null)
				aux.addFirst(p.right);
			if (p.left != null)
				aux.addFirst(p.left);
		}
		System.out.println();
	}
	
	public void preOrderTraversalR(TNode n) {
		if(n!=null) {
			System.out.print(n.val+",");
			preOrderTraversalR(n.left);
			preOrderTraversalR(n.right);
		}
	}

	public void postOrderTraversal(TNode n) {
		Deque<TNode> aux = new ArrayDeque<>();
		Deque<TNode> ans = new ArrayDeque<>();
		aux.push(n);

		while (!aux.isEmpty()) {
			TNode t = aux.pop();
			ans.add(t);
			if (t.left != null)
				aux.push(t.left);
			if (t.right != null)
				aux.push(t.right);
		}

		ans.descendingIterator().forEachRemaining(e -> System.out.print(e.val + ","));
		System.out.println();
	}
}
