package com.ds;

import java.util.Arrays;

public class StackQueueDS {
	public static class Stack {
		int[] arr;
		int top;

		public Stack(int size) {
			arr = new int[size];
		}

		public boolean isOverflow() {
			return top == arr.length;
		}

		public boolean isUnderflow() {
			return top == 0;
		}

		public void push(int e) {
			if (isOverflow()) {
				throw new RuntimeException("Stack is overflow :" + this);
			}
			arr[top++] = e;
		}

		public int pop() {
			if (isUnderflow()) {
				throw new RuntimeException("Stack is underflow :" + this);
			}

			return arr[--top];
		}
		
		public int size() {
			return top;
		}

		@Override
		public String toString() {
			return "Stack [arr=" + Arrays.toString(arr) + ", top=" + top + "]";
		}

	}

	public static class CircularQueue {
		int[] arr;
		int t = 0;
		int h = 0;
		int c = 0;

		public CircularQueue(int size) {
			arr = new int[size];
		}

		public int size() {
			return c;
		}

		public boolean isOverflow() {
			return c == arr.length;
		}

		public boolean isUnderflow() {
			return c == 0;
		}

		public void enqueue(int e) {
			if (isOverflow()) {
				throw new RuntimeException("Q is overflow" + " h:" + h + " t:" + t);
			}
			arr[t++] = e;
			if (t == arr.length) {
				t = 0;
			}
			c++;
		}

		public int dequeue() {
			if (isUnderflow()) {
				throw new RuntimeException("Q is underflow" + " h:" + h + " t:" + t);
			}

			int e = arr[h++];
			if (h == arr.length) {
				h = 0;
			}
			c--;
			return e;
		}

		@Override
		public String toString() {
			return "CQ [arr=" + Arrays.toString(arr) + ", t=" + t + ", h=" + h + "]";
		}

	}
}
