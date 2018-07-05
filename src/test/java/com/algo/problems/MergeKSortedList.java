package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

public class MergeKSortedList {
	
	@Test
	public void test() {
		int[] arr1=new int[] {1,4,7,9,10};
		int[] arr2=new int[] {1,2,5,9,13};
		int[] arr3=new int[] {6,8,9,12,15};
		int[][] arr = new int[][] {arr1,arr2,arr3};
		int[] mergeKlist = mergeKlist(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(mergeKlist));
	}
	
	int[] mergeKlist(int[][] arr, int s, int e) {
		if(s==e) {
			return arr[s];
		}
		int m=s+(e-s)/2;
		int[] b=mergeKlist(arr, s, m);
		int[] a = mergeKlist(arr, m+1, e);
		return merge(a, b);
	}
	
	int[] merge(int[] a, int[] b) {
		int[] arr=new int[a.length+b.length];
		
		int i=0;
		int j=0;
		int k=0;
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]) {
				arr[k++]=a[i++];
			}else {
				arr[k++]=b[j++];
			}
		}
		
		while(i<=a.length-1) {
			arr[k++]=a[i++];
		}
		while(j<=b.length-1) {
			arr[k++]=a[j++];
		}
		return arr;
	}

}
