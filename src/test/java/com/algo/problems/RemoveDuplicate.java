package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.ds.Utils;

public class RemoveDuplicate {

	int[] arr={1,1,2,3,4,4,5,5,6,6,7};

	
	@Test
	public void removeDuplicate() {
		Integer last = null;
		int j=0,i=-1, len = arr.length;
		
		while(j<len) {
			if(last==null) {
				last = arr[j];
				++i;
			}else if(arr[j]!=last) {
				last= arr[j];
				Utils.swap(arr, ++i, j);
			}
			j++;
		}
		arr = Arrays.copyOf(arr, ++i);
		System.out.println(Arrays.toString(arr));
	}
}
