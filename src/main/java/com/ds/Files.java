package com.ds;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

public class Files {

	@Test
	public void readFile() throws Exception {
		FileInputStream fis = new FileInputStream(new File("/learning/algocode/src/main/resources/test.f"));

		byte[] byteArray = new byte[12];
		int bytesCount = 0;

		while ((bytesCount = fis.read(byteArray)) != -1) {
			System.out.println(new String(byteArray));
			System.out.println(bytesCount);
		}
		

		// close the stream; We don't need it now.
		fis.close();
	}

}
