package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Heap_SortIncreasingDecreasingArray {

	@Test
	public void sort_IncreasingDescreasingArrayTest() {
		List<Integer> list = Arrays.asList(100, 101, 102, 103, 104, 90, 91, 92, 93, 94, 80, 81, 82, 83, 84, 85, 70, 71,
				60);

		List<List<Integer>> lists = new ArrayList<>();
		int lo = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			if (i + 1 < list.size() && list.get(i) > list.get(i + 1)) {
				lists.add(list.subList(lo, i+1));
				lo = i + 1;
			} else if (i + 1 == list.size()) {
				lists.add(list.subList(lo, list.size()));
			}
		}
		for (List<Integer> list2 : lists) {
			System.out.println(list2);
		}
		
		//use KSorted solution of heap O(nlogk)

	}

}
