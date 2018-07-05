package com.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {

	public static class TNode {
		public int val;
		public TNode p;
		public TNode left;
		public TNode right;
		public int size;

		public static TNode get(int v) {
			TNode n = new TNode();
			n.val = v;
			n.size = 1;
			return n;
		}

		public void inc() {
			++size;
		}

		public void nodes(TNode l, TNode r) {
			if (l != null) {
				left = l;
				l.p = this;
			}

			if (r != null) {
				right = r;
				r.p = this;
			}
		}

		@Override
		public String toString() {
			return (left != null ? this.left.val + "" : "null") + "-(" + (val) + ")-"
					+ (right != null ? this.right.val + "" : "null");
		}

	}

	public static TNode mine() {
		TNode n40 = TNode.get(40);
		TNode n60 = TNode.get(60);
		TNode n70 = TNode.get(70);
		TNode n75 = TNode.get(75);
		TNode n65 = TNode.get(65);
		TNode n68 = TNode.get(68);
		TNode n20 = TNode.get(20);
		TNode n30 = TNode.get(30);
		TNode n35 = TNode.get(35);
		TNode n25 = TNode.get(25);
		TNode n32 = TNode.get(32);
		TNode n31 = TNode.get(31);
		TNode n34 = TNode.get(34);
		TNode n36 = TNode.get(36);
		TNode n13 = TNode.get(13);
		TNode n12 = TNode.get(12);
		TNode n15 = TNode.get(15);
		TNode n10 = TNode.get(10);
		TNode n5 = TNode.get(5);

		n40.nodes(n20, n60);
		n20.nodes(n10, n30);
		n10.nodes(n5, n15);
		n15.nodes(n12, null);
		n12.nodes(null, n13);

		n30.nodes(n25, n35);
		n35.nodes(n34, n36);
		n34.nodes(n31, null);
		n31.nodes(null, n32);

		n60.nodes(null, n70);
		n70.nodes(n65, n75);
		n65.nodes(null, n68);

		return n40;

	}

	public static TNode bitTree() {
		TNode root = TNode.get(1);

		root.left = TNode.get(0);
		root.left.left = TNode.get(0);
		root.left.left.left = TNode.get(0);
		root.left.left.right = TNode.get(1);
		root.left.right = TNode.get(1);
		root.left.right.right = TNode.get(1);
		root.left.right.right.left = TNode.get(0);

		root.right = TNode.get(1);
		root.right.right = TNode.get(0);
		root.right.right.right = TNode.get(0);

		root.right.left = TNode.get(0);
		root.right.left.right = TNode.get(0);
		root.right.left.right.right = TNode.get(0);
		root.right.left.right.left = TNode.get(1);
		root.right.left.right.left.right = TNode.get(1);

		return root;
	}

	public static TNode epi() {
		TNode n = TNode.get(1);
		n.left = TNode.get(2);
		n.left.left = TNode.get(3);
		n.left.left.left = TNode.get(4);
		n.left.left.right = TNode.get(5);

		n.left.right = TNode.get(6);
		n.left.right.right = TNode.get(7);
		n.left.right.right.left = TNode.get(8);

		n.right = TNode.get(9);
		n.right.right = TNode.get(15);
		n.right.right.right = TNode.get(16);
		n.right.left = TNode.get(10);
		n.right.left.right = TNode.get(11);
		n.right.left.right.left = TNode.get(12);
		n.right.left.right.left.right = TNode.get(14);
		n.right.left.right.right = TNode.get(13);

		return n;
	}

	public static TNode minesm() {
		TNode n40 = TNode.get(40);
		TNode n60 = TNode.get(60);
		TNode n70 = TNode.get(70);
		TNode n75 = TNode.get(75);
		TNode n65 = TNode.get(65);
		TNode n68 = TNode.get(68);
		TNode n20 = TNode.get(20);
		TNode n28 = TNode.get(28);
		TNode n30 = TNode.get(30);
		TNode n35 = TNode.get(35);
		TNode n25 = TNode.get(25);
		TNode n32 = TNode.get(32);
		TNode n31 = TNode.get(31);
		TNode n34 = TNode.get(34);
		TNode n36 = TNode.get(36);
		TNode n13 = TNode.get(13);
		TNode n12 = TNode.get(12);
		TNode n15 = TNode.get(15);
		TNode n10 = TNode.get(10);
		TNode n5 = TNode.get(5);

		n40.nodes(n20, n60);
		n20.nodes(n10, n30);
		n10.nodes(n5, n15);

		n30.nodes(n25, n35);
		n25.nodes(null, n28);

		n60.nodes(null, n70);
		n70.nodes(n65, n75);
		n65.nodes(null, n68);

		return n40;

	}

	public static TNode symTree() {
		TNode root = TNode.get(1);
		TNode n_2a = TNode.get(2);
		TNode n_2b = TNode.get(2);
		root.left = n_2a;
		root.right = n_2b;

		TNode n_4a = TNode.get(4);
		TNode n_5a = TNode.get(5);
		n_2a.left = n_4a;
		n_2a.right = n_5a;

		TNode n_4b = TNode.get(4);
		TNode n_5b = TNode.get(5);
		n_2b.left = n_5b;
		n_2b.right = n_4b;

		TNode n_6a = TNode.get(6);
		TNode n_7a = TNode.get(7);
		n_4a.left = n_6a;
		n_4a.right = n_7a;

		TNode n_8a = TNode.get(8);
		TNode n_9a = TNode.get(9);
		n_5a.left = n_8a;
		n_5a.right = n_9a;

		TNode n_8b = TNode.get(8);
		TNode n_9b = TNode.get(9);
		n_5b.left = n_9b;
		n_5b.right = n_8b;

		TNode n_6b = TNode.get(6);
		TNode n_7b = TNode.get(7);
		n_4b.left = n_7b;
		n_4b.right = n_6b;

		return root;

	}

	public static TNode coreman() {
		TNode root = TNode.get(15);
		TNode n_18 = TNode.get(18);
		TNode n_17 = TNode.get(17);
		TNode n_20 = TNode.get(20);
		TNode n_9 = TNode.get(9);
		TNode n_13 = TNode.get(13);
		TNode n_7 = TNode.get(7);
		TNode n_6 = TNode.get(6);
		TNode n_3 = TNode.get(3);
		TNode n_2 = TNode.get(2);
		TNode n_4 = TNode.get(4);

		root.left = n_6;
		root.left.p = root;
		root.right = n_18;
		root.right.p = root;

		n_18.left = n_17;
		n_18.left.p = n_18;

		n_18.right = n_20;
		n_18.right.p = n_18;

		n_6.left = n_3;
		n_6.left.p = n_6;
		n_6.right = n_7;
		n_6.right.p = n_6;

		n_3.left = n_2;
		n_3.left.p = n_3;
		n_3.right = n_4;
		n_3.right.p = n_3;

		n_7.right = n_13;
		n_7.right.p = n_7;
		n_13.left = n_9;
		n_13.left.p = n_13;
		return root;

	}

	public static TNode bstepi() {
		TNode root = TNode.get(19);
		root.left = TNode.get(7);
		root.right = TNode.get(43);

		root.left.left = TNode.get(3);
		root.left.right = TNode.get(11);

		root.left.left.left = TNode.get(2);
		root.left.left.right = TNode.get(5);

		root.left.right.right = TNode.get(17);
		root.left.right.right.left = TNode.get(13);

		root.right.left = TNode.get(23);
		root.right.left.right = TNode.get(37);
		root.right.left.right.left = TNode.get(29);
		root.right.left.right.right = TNode.get(41);

		root.right.left.right.left.right = TNode.get(31);

		root.right.right = TNode.get(47);
		root.right.right = TNode.get(53);

		return root;
	}

	public static TNode mineByInsert() {
		int[] arr = new int[] { 40, 20, 10, 5, 60, 70, 75, 65, 68, 15, 30, 35, 25, 28 };
		TNode n = null;
		for (int i : arr) {
			n = insert(n, i);
		}
		return n;
	}

	public static TNode insert(TNode node, int x) {
		if (node == null) {
			return TNode.get(x);
		}

		if (x <= node.val) {
			node.left = insert(node.left, x);
		} else {
			node.right = insert(node.right, x);
		}
		node.inc();

		return node;
	}

	public static void print(TNode root) {
		List<Integer> ans = new ArrayList<>();
		inorder(ans, root);
		System.out.println(ans);
		Tree.print(root, "", true, "");
		System.out.println("");
	}

	public static void inorder(List<Integer> list, TNode n) {
		if (n != null) {
			inorder(list, n.left);
			list.add(n.val);
			inorder(list, n.right);
		}
	}

	public static void print(TNode n, String prefix, boolean isTail, String postfix) {
		if (n == null) {
			return;
		}
		System.out.println(prefix + (isTail ? "└── " : "├── ") + postfix + " v:" + n.val + " s:" + (n.size));
		// + (n.p != null ? (" p:" + n.p.val) : " p:null"));
		List<TNode> children = Arrays.asList(n.left, n.right);
		for (int i = 0; i < children.size() - 1; i++) {
			print(children.get(i), prefix + (isTail ? "    " : "│   "), false, "l-");
		}
		if (children.size() > 0) {
			TNode tNode = children.get(children.size() - 1);
			print(tNode, prefix + (isTail ? "    " : "│   "), true, "r-");
		}
	}

}
