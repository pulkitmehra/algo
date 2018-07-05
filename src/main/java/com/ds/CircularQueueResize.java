package com.ds;

public class CircularQueueResize {

	public int[] arr;
	int c;
	int s = 1;
	int h, t;

	public CircularQueueResize(int c) {
		this.c = c;
		this.arr = new int[c];
	}

	public void enqueue(int v) {
		if (s == c) {
			resize();
		}
		arr[t] = v;
		t = (t + 1) % c;
		s++;
	}

	public int dequeue() {
		if (s == 1) {
			throw new RuntimeException("underflow");
		}
		int v = arr[h];
		h = (h + 1) % c;
		s--;
		return v;
	}

	private void resize() {
		c = c * 2;
		int[] narr = new int[c];
		int i = 0;
		if (s != 0) {
			if (h < t) {
				for (int j = h; j < t; j++) {
					narr[i++] = arr[j];
				}
			} else {
				for (int j = h; j <= arr.length - 1; j++) {
					narr[i++] = arr[j];
				}
				for (int j = 0; j < t; j++) {
					narr[i++] = arr[j];
				}
			}
		}
		arr = narr;
		h = 0;
		t = i;
	}

}
