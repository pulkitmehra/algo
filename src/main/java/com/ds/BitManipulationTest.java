package com.ds;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BitManipulationTest {

	@Test
	public void testInitaialCapacity() {
		int initialCapacity = 8;
		System.out.println(allocateElements(30, 15));

	}

	@Test
	public void addTest() {
		int x = 0b101;// 5
		int y = 0b1010;// 10
		System.out.println(add(x, y));
	}

	@Test
	public void negate() {
		int x = 0b101;// 5
		System.out.println(add(~x, 1));
	}
	
	@Test
	public void getBitIsOnOrOff() {
		int x = 5;
		System.out.println(x >> 2 & 1);
		System.out.println(x);
	}

	@Test
	public void sub() {
		System.out.println(add(5, add(~6, 1)));
	}

	public int add(int x, int y) {
		int xl, yl, sum = 0, cary = 0, t, i = 0;
		while (x != 0 || y != 0) {
			xl = x & 1;
			yl = y & 1;
			t = xl ^ yl ^ cary;
			cary = xl & yl | xl & cary | yl & cary;
			sum |= t << i;
			x >>>= 1;
			y >>>= 1;
			i++;
		}
		return sum | cary << i;
	}

	@Test
	public void coountBits() {
		int x = 0b110010101;
		int numBits = 0;
		while (x != 0) {
			int b = x & 1;
			numBits += b;
			x = x >>> 1;
		}
		System.out.println(numBits);
	}

	@Test
	public void swapBits() {
		int i = 3;
		int j = 6;
		int b = 0b1010010110;

		int ibit = b >>> i - 1 & 1;
		int jbit = b >>> j - 1 & 1;

		int maski = ~(1 << i - 1);
		int maskj = ~(1 << j - 1);

		b = (b & maski) | jbit << i;
		b = (b & maskj) | ibit << j;
		System.out.println(Integer.toBinaryString(b));
	}

	@Test
	public void reverseBits() {
		int b = 0b1101;
		int r = 0;
		for (int i = 0; i < 32; i++) {
			r += b & 1; // get last digit of num
			b >>>= 1; // get next digit to last
			if (i < 31)
				r <<= 1; // push result to forward
		}
		System.out.println(Integer.toBinaryString(r));
	}

	@Test
	public void reverseBitWithCaching() {
		Map<Byte, Integer> byteMap = new HashMap<>();
		int n = 0b10101101_11010111_11110000_01110111;
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) ((n >>> i * 8) & 0xFF);
		}

		int r = 0;
		for (int j = 0; j < b.length; j++) {
			r += reverse(b[j], byteMap);
			if (j < b.length - 1)
				r <<= 8;
		}

		System.out.println(Integer.toBinaryString(r));
	}

	public int reverse(byte b, Map<Byte, Integer> byteMap) {
		Integer i = byteMap.get(b);
		if (i != null) {
			return i;
		}
		int r = 0;
		for (i = 0; i < 8; i++) {
			r += b & 1;
			b >>>= 1;
			if (i < 7)
				r <<= 1;
		}
		byteMap.put(b, r);
		return r;
	}

	@Test
	public void reverseBitWithCache() {
		System.out.println(Integer.parseInt("FF", 16));
		System.out.println(Integer.toBinaryString(255));

	}

	@Test
	public void reverseBit() {
		int mask_size = 16;
		int bit_mask = 0xFFFF;

		System.out.println(Integer.toBinaryString(bit_mask));
	}

	private int allocateElements(int numElements, int initialCapacity) {

		// Find the best power of two to hold elements.
		// Tests "<=" because arrays aren't kept full.
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity |= (initialCapacity >>> 1);
			System.out.println(initialCapacity);
			initialCapacity |= (initialCapacity >>> 2);
			System.out.println(initialCapacity);
			initialCapacity |= (initialCapacity >>> 4);
			System.out.println(initialCapacity);
			initialCapacity |= (initialCapacity >>> 8);
			System.out.println(initialCapacity);
			initialCapacity |= (initialCapacity >>> 16);
			System.out.println("+" + initialCapacity);
			initialCapacity++;
			System.out.println("+" + initialCapacity);
			if (initialCapacity < 0) { // Too many elements, must back off
				System.out.println("e");
				System.out.println(initialCapacity);
				initialCapacity >>>= 1;
			} // Good luck allocating 2 ^ 30 elements
		}
		System.out.println("t" + initialCapacity);
		return initialCapacity;
	}

	@Test
	public void representInBits() {

		int num = 11;
		String alpha = "a";
		BitSet b = BitSet.valueOf(new long[] { 11L });
		System.out.println(b);
	}

	@Test
	public void charToBits() {
		char c = 'a';
		byte b = (byte) c;

		System.out.println(b);
	}

	@Test
	public void testShift() {
		System.out.println(5 << 35);
		System.out.println(5 << 35);
		System.out.println(Integer.toBinaryString(5 << 3));
		System.out.println(Integer.toBinaryString(-5 << 3));
		System.out.println(Integer.toBinaryString(40 >> 35));
	}

}
