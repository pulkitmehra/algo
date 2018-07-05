package com.algo.problems;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.ds.BitInputStream;

public class BitInputStreamTest {

	@Test
	public void bitInputStreamTest() throws Exception {
		BitInputStream bs = new BitInputStream(new File("/learning/algocode/src/main/resources/test.f"));
		int readBits = bs.readBits(8);
		System.out.println(readBits);
	}

}
