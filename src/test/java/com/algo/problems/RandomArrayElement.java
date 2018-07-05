package com.algo.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RandomArrayElement {

	List<Integer> list = Arrays.asList(1, 8, 2, 3, 0, 4, 1, 6, 7, 9);

	@Test
	public void randomElements() {
		int k = 4;
		Random r = new Random();
		int size = list.size();
		int i = size - 1;
		while (i >= (size - k)) {
			int n = r.nextInt(i);
			Collections.swap(list, i--, n);
		}
		System.out.println(list.subList(i + 1, size));
	}
	
	@Test
	public void generateRandomsInRange() {
		Random rn = new Random();
		int maximum=10;
		int minimum=5;
		int range = maximum - minimum + 1;
		int randomNum =  rn.nextInt(range) + minimum;
		System.out.println(randomNum);
	}
	
	

}
