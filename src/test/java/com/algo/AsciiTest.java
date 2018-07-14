package com.algo;

import org.junit.Test;

import java.util.Objects;

public class AsciiTest {
	
	@Test
	public void asciiTest() {
		int[] ascii = new int[127]; 
		
		String s = "abmh2f3ghyz";
		for (int i : s.toCharArray()) {
			System.out.println(i);
			ascii[i] = ++ascii[i];
			System.out.println(ascii[i]);
		}
	}



}
