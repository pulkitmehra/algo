package com.ds;

public class Node {
	int val;
	Node L;
	Node R;

	public static Node of(int v) {
		Node n = new Node();
		n.val = v;
		return n;
	}

	public void toLeft(Node left) {
		this.L = left;
	}

	public void toRight(Node right) {
		this.R = right;
	}

	@Override
	public String toString() {
		return (L != null ? L.val : "null") + "-(" + val + ")- " + (R != null ? R.val : "null");
	}

}
