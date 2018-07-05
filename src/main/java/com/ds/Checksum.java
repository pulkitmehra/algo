package com.ds;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class Checksum {

	@Test
	public void byteChecksum() throws NoSuchAlgorithmException, IOException {
		System.out.println(getChecksum(new String()));
	}

	public static String getChecksum(Serializable object) throws IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(baos.toByteArray());
			return DatatypeConverter.printHexBinary(thedigest);
		} finally {
			oos.close();
			baos.close();
		}
	}

}
