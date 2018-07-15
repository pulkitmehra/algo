package com.algo;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

import com.ds.HashFunctions;

public class HashFunctionTest {
	
	@Test
	public void stringHash() {
		String s = "testfunction";
		int size = s.length();
		int hval = s.chars().reduce(0, (v, c) -> {
			int i = v * 997 + c;
			int modulo = i % size;
			return modulo;
		});
		System.out.println(hval);
		
	}

	@Test
	public void md5128BitoLong(){
		long value = HashFunctions.md5To64Bit("test");
		System.out.println(value);
	}

	@Test
	public void md5128BitoBigInteger(){
		BigInteger value = HashFunctions.md5ToBigInteger("test");
		System.out.println(value);
	}

	@Test
	public void divisionMethod() {
		String[] arr = new String[] { "abcdef", "bcdefa", "cdefab", "defabc", "absdsd", "ssdsdsa", "qDDDqwsfa",
				"dsadeqjf", "dfadfhwjq", "dsadasd" };
		int[] hashedArr = new int[10];

		for (String s : arr) {
			hashedArr[HashFunctions.hashByDivision(s, 10)] = hashedArr[HashFunctions.hashByDivision(s, 10)] + 1;
		}
		System.out.println(Arrays.toString(hashedArr));
	}

}
