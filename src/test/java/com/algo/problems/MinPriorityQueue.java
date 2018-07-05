package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.ds.Utils;

public class MinPriorityQueue {

	@Test
	public void createHeap() {
		int[] arr = new int[] { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		for (int i = arr.length / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void heapSort() {
		int[] arr = new int[] { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		for (int i = arr.length / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
		int size = arr.length-1;
		
		while(size>0) {
			swap(arr, 0, size--);
			heapify(arr, 0, size);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void insertTest() {
		int[] arr = new int[] { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		for (int i = arr.length / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
		int[] copy = insert(arr, 1);
		System.out.println(Arrays.toString(copy));
	}
	
	@Test
	public void delete() {
		int[] arr = new int[] { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		for (int i = arr.length / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
		int[] copy = delete(arr, 0);
		System.out.println(Arrays.toString(copy));
	}
	
	public int[] delete(int[] arr, int i) {
		
		arr[i] = Integer.MAX_VALUE;
		heapify(arr, i, arr.length-1);
		return Utils.decreaseBy(arr, 1);
	}
	
	public int[] insert(int[] arr, int num) {
		int[] copy = Utils.increaseBy(arr, 1);
		copy[copy.length-1]=num;
		
		int i = copy.length-1;
		int p =parent(i);
		while(p>=0 && num < copy[p] ) {
			swap(copy, p, i);
			i = p;
			p=parent(p);
		}
		return copy;
	}

	public void heapify(int[] arr, int i, int s) {
		if (i >= s) {
			return;
		}
		int l = left(i);
		int r = right(i);
		int small = i;
		if (l <= s && arr[l] < arr[i]) {
			small = l;
		}
		if (r <= s && arr[r] < arr[small]) {
			small = r;
		}
		if (small != i) {
			swap(arr, small, i);
			heapify(arr, small, s);
		}
	}

	public void swap(int[] arr, int from, int to) {
		if (from == to)
			return;
		int t = arr[from];
		arr[from] = arr[to];
		arr[to] = t;
	}

	public int left(int i) {
		return (2 * i) + 1;
	}

	public int right(int i) {
		return 2 * (++i);
	}

	public int parent(int i) {
		return Math.abs((i - 1) / 2);
	}

}
