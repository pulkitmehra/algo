package com.ds;

public class ListNode {
	public int val;
	public ListNode next;

	public static ListNode get(int v) {
		return new ListNode(v);
	}

	public ListNode(int v) {
		this.val = val;
	}

	public static ListNode small() {
		ListNode head = ListNode.get(2);
		ListNode _3 = ListNode.get(3);
		ListNode _4 = ListNode.get(4);
		ListNode _5 = ListNode.get(5);
		ListNode _6 = ListNode.get(6);
		ListNode _7 = ListNode.get(7);
		ListNode _8 = ListNode.get(8);
		ListNode _9 = ListNode.get(9);
		ListNode _10 = ListNode.get(10);
		ListNode _11 = ListNode.get(11);
		head.next = _3;
		_3.next = _4;
		_4.next = _5;
		_5.next = _6;
		_6.next = _7;
		_7.next = _8;
		_8.next = _9;
		_9.next = _10;
		_10.next = _11;
		return head;
	}

	public static void print(ListNode h) {
		while (h != null) {
			System.out.print(h.val + ",");
			h = h.next;
		}
		System.out.println();
	}
}
