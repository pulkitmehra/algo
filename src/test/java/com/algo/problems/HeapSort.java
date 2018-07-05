package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.algo.Sorting;
import com.ds.Node;

@Sorting
public class HeapSort {
	
	@Test
	public void createTreeTest() {
		int[] arr=new int[] {5,2,1,6,3,14,12,8,9};
		Node n = createTree(arr, 0);
		System.out.println(n);
	}
	
	@Test
	public void heapifyAnArray() {
		int[] arr=new int[] {5,2,1,6,3,14,12,8,9};
		for(int i = arr.length/2; i>=0; i--) {
			heapify(arr, arr.length-1, i);
		}
		Node n = createTree(arr,0);
		System.out.println(n);
	}
	
	@Test
	public void heapSort() {
		int[] arr=new int[] {5,2,1,6,3,14,12,8,9};
		for(int i = arr.length-1; i>=0; i--) {
			heapify(arr, arr.length-1, i);
		}
		Node node = createTree(arr,0);
		System.out.println(node);
		for(int n = arr.length-1; n > 0;) {
			swap(arr, 0, n);
			heapify(arr, --n, 0);
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void heapify(int[] arr, int size, int i) {
		if(i > size) {
			return;
		}
		
		int lc =left(i);
		int rc = right(i);
		
		int largest = i;
		if(lc <= size && arr[lc] > arr[i]) {
			largest = lc;
		}
		if(rc <= size && arr[largest] < arr[rc]) {
			largest = rc;
		}
		if (largest!=i) {
			swap(arr, largest, i);
			heapify(arr, size, largest);
		}
	}
	
	private void swap(int[] arr, int j, int i) {
		if(i==j) return;
		int t = arr[j];
		arr[j] = arr[i];
		arr[i] = t;		
	}

	public Node createTree(int[] arr,int i) {
		if(i > arr.length-1) {
			return null;
		}
		
		int lc=left(i);
		int rc=right(i);
		
		Node left = createTree(arr,lc);
		if(left == null && lc < arr.length-1) {
			left = Node.of(arr[lc]);
		}
		Node right = createTree(arr,rc);
		if(right == null && rc < arr.length-1) {
			left = Node.of(arr[rc]);
		}
		Node n= Node.of(arr[i]);
		n.toLeft(left);
		n.toRight(right);
		return n;
	}
	
	
	
	public int left(int i) {
		return Math.abs(2*++i-1);
	}
	
	public int right(int i) {
		return Math.abs(2*++i);
	}
	
	public int parent(int i) {
		return Math.abs((i-1)/2);
	}

}
