package com.algo.problems;

import org.junit.Test;

import com.ds.ListNode;

public class ReverseASubLinkedList {
	
	

	@Test
	public void reverseASubList() {
		int s = 2;
		int e = 8;
		
		// increent to start
		ListNode head = ListNode.small();
		ListNode h = head;
		ListNode.print(h);
		
		int k = 1;
		while (k++ < s) {
			h = h.next;
		}

		ListNode i = h.next;
		while (s++ < e) {
			ListNode t = i.next;
			i.next = t.next;
			t.next = h.next;
			h.next = t;
		}
		ListNode.print(head);
		
	}

}
