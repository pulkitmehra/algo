package com.algo.problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class KRandomInStreamData {

	List<Integer> list = Arrays.asList(1, 8, 2, 3, 0, 4, 1, 6, 7, 9);

	@Test
	public void selectKStreamDataRandomElement() {
		int k = 3;
		Iterator<Integer> iterator = list.iterator();

		int[] arr = new int[k];
		for (int i = 0; i < k && iterator.hasNext(); i++) {
			arr[i] = iterator.next();
		}

		int numSoFar = k;
		Random r = new Random();
		while (iterator.hasNext()) {
			int x = iterator.next();
			int nextInt = r.nextInt(++numSoFar);
			if (nextInt < k) {
				arr[nextInt] = x;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
