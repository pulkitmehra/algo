package com.algo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class LRUCache2 {

	@Test
	public void lruTest() {
		LRU l = new LRU(3);
		l.put(1, 1);
		l.put(2, 2);
		l.put(3, 3);
		l.put(4, 4);
		l.get(2);
		l.get(3);
		l.put(5, 5);
		l.printlist();
		
	}

	static class LRU {
		Map<Integer, Node> map = new HashMap<>();
		Node tail = null;
		Node head = null;
		int capacity;

		public LRU(int c) {
			this.capacity = c;
		}

		public void printMap() {
			Set<Entry<Integer, Node>> entrySet = map.entrySet();
			for (Entry<Integer, Node> e : entrySet) {
				System.out.print("[" + e.getValue().k + "," + e.getValue().v + "]");
			}
			System.out.println();
		}

		public void printlist() {
			Node e = head;
			System.out.println("head[" + head.k + "," + head.v + "]");
			System.out.println("tail[" + tail.k + "," + tail.v + "]");
			while (e != null) {
				System.out.print("[" + e.k + "," + e.v + "]");
				e = e.next;
			}
			System.out.println();
		}

		public void put(int k, int v) {
			Node n = map.get(k);
			if (n == null) {
				n = Node.get(k, v);
			}
			map.put(k, n);
			afterNodeInsertion(n);
		}

		public int get(int k) {
			Node v = map.get(k);
			if (v == null) {
				return -1;
			}
			afterNodeAccess(v);
			return v.v;
		}

		private void afterNodeAccess(Node v) {
			if (v != head && v != tail) {// middle
				v.prev.next = v.next;
				v.next.prev = v.prev;
				tail.next = v;
				v.prev = tail;
				v.next = null;
				tail = v;
			} else if (v == head && v != tail) {// first
				head = v.next;
				head.prev = null;
				tail.next = v;
				v.prev = tail;
				v.next = null;
				tail = v;
			}
			// last and single would be taken alright;
		}

		private void afterNodeInsertion(Node n) {
			if (isCapacity()) {
				evict();
			}
			addToLast(n);
		}

		private void addToLast(Node n) {
			if (head == null) {
				head = n;
				tail = n;
			} else {
				n.prev = tail;
				tail.next = n;
				n.next = null;
				tail = n;
			}
		}

		private void evict() {
			Node t = head;
			if (head != null) {
				if (head == tail) {
					head = null;
					tail = null;
				} else {
					head = head.next;
					head.prev = null;
					t.next = null;
					t.prev = null;
				}
			}
			map.remove(t.k);
		}

		private boolean isCapacity() {
			return map.size() > capacity;
		}

		static class Node {
			int k;
			int v;
			Node prev, next;

			public static Node get(int k, int v) {
				Node n = new Node();
				n.k = k;
				n.v = v;
				return n;
			}

			@Override
			public String toString() {
				return "[" + k + "," + v + "]";
			}

		}
	}

}
