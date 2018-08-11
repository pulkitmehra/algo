package com.leetcode.premium.fb;

import com.ds.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (!q.isEmpty()) {
            ListNode min = q.poll();
            dummy.next = min;
            if (min.next != null) {
                q.offer(min.next);
            }
            dummy = dummy.next;
        }

        return head.next;
    }

    public ListNode mergeSortSolution(ListNode[] lists) {
        if (lists.length <= 0) return null;
        return partition(lists, 0, lists.length - 1);
    }

    /*
     This is more efficient in space
     */
    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        int mid = (start + end) / 2;

        ListNode leftList = partition(lists, start, mid);

        ListNode rightList = partition(lists, mid + 1, end);

        if (leftList == null) return rightList;

        else if (rightList == null) return leftList;

        else return mergeTwoLists(leftList, rightList);
    }

    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) curr.next = left;
        if (right != null) curr.next = right;
        return head.next;
    }
}
