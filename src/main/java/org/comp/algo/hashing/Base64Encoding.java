package org.comp.algo.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

public class Base64Encoding {

    @Test
    public void base64Encode() {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(encodedString);
    }

    @Test
    public void messageMD5() throws NoSuchAlgorithmException {
        String password = "ILoveJava";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        System.out.println(myHash);
        String encodedString = Base64.getEncoder().encodeToString(digest);
        System.out.println(encodedString);
    }
}


