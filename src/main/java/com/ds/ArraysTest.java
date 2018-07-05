package com.ds;

import java.util.Arrays;

import org.junit.Test;

public class ArraysTest {
	
	@Test
	public void copyArange() {
		int[] arr = {1,2,3,4,5,6};
		arr = Arrays.copyOf(arr, 10);
		System.out.println(Arrays.toString(arr));
		arr = Arrays.copyOfRange(arr, 1, 10);
		System.out.println(Arrays.toString(arr));
	}

}
