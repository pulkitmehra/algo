package com.algo.problems;

import org.junit.Test;

import com.ds.StackQueueDS.CircularQueue;

public class StackUsingTwoQueue {

	@Test
	public void stackBeha() {
		StackTwoQueue s = new StackTwoQueue(3);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s);
	}

	static class StackTwoQueue {
		CircularQueue cq1;
		CircularQueue cq2;
		int size;
		int curr;

		StackTwoQueue(int size) {
			cq1 = new CircularQueue(size);
			cq2 = new CircularQueue(size);
			this.size = size;
		}

		int size() {
			return cq1.size();
		}

		void push(int e) {
			cq1.isOverflow();
			cq1.enqueue(e);
		}

		int pop() {
			cq1.isUnderflow();
			int s = cq1.size();
			for (int i = 0; i < s-1; i++) {
				cq2.enqueue(cq1.dequeue());
			}
			int e = cq1.dequeue();
			CircularQueue t = cq1;
			cq1 = cq2;
			cq2 = t;
			return e;
		}

		@Override
		public String toString() {
			return "StackTwoQueue [cq1=" + cq1 + ", cq2=" + cq2 + "]";
		}

	}

}
