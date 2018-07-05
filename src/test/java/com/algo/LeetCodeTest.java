package com.algo;

import java.util.Arrays;

import org.junit.Test;

public class LeetCodeTest {

	@Test
	public void testMe() {
		int[] arr = new int[] { 0, -1, 2, -3, 1 };
		int[] aux = new int[arr.length];

		mergeSort(arr, aux, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	public void mergeSort(int[] a, int aux[], int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + ((hi - lo) / 2);

		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);

		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int lm = lo;
		int hm = mid + 1;
		int curr = lo;
		while (lm <= mid && hm <= hi) {
			if (aux[lm] <= aux[hm]) {
				a[curr++] = aux[lm++];
			}
			if (aux[lm] > aux[hm]) {
				a[curr++] = aux[hm++];
			}
		}

		while (lm <= mid) {
			a[curr++] = aux[lm++];
		}
	}

}
