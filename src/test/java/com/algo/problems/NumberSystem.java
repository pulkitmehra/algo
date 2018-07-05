package com.algo.problems;

import org.junit.Test;

public class NumberSystem {
	
	@Test
	public void numbersystem() {

		int a = 0b011; //binary number
		int b = 0xabcd; //hexa decimal number
		
		System.out.println(Integer.toString(b, 2));
	}
	
	@Test
	public void ipInButs() {
		System.out.println("192.168.129.012".getBytes().length);
		System.out.println();
		System.out.println(Integer.toBinaryString(19200));
	}
	
	@Test
	public void testBitSizeWithInt() {
		int[] arr = new int[] {101,222,333,444,555,666,12345,11123};
		byte[] b = new byte[32];
		for (int i : arr) {
			b[i/8] |= (1 << (i%8));
			System.out.println(b[i/8]);
		}
		
		
	}

}
