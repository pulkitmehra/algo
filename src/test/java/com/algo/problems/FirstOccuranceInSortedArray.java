package com.algo.problems;

import org.junit.Test;

public class FirstOccuranceInSortedArray {
	
	@Test
	public void findFirstOccurance() {
		int[] arr = new int[] {1,1,2,2,2,3,4,5,5,6,7};
		int n=5;
		int i = findNum(arr, n, 0, arr.length-1);
		if(arr[i] == n ) {
			System.out.println("found "+arr[i]+" at "+i);
		}else {
			System.out.println("Not Found");
		}
	}
	
	public int findNum(int[] arr, int n, int s, int e) {
		if(s==e) return s;
		int m = s +(e-s)/2;
		if(arr[m] < n) {
			return findNum(arr, n, m+1, e);
		}
		return findNum(arr, n, s, m);
	}

}
