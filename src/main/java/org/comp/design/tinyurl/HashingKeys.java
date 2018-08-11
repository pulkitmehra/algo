package org.comp.design.tinyurl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class HashingKeys {

    /*
     * It alsways give 128 bits hash
     */
    public byte[] getHash(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(url.getBytes(StandardCharsets.UTF_8));
            return md.digest();
        }
        catch (Exception e) {
            return new byte[0];
        }
    }
    
    public String getHashString(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(url.getBytes(StandardCharsets.UTF_8));
            return md.toString();
        }
        catch (Exception e) {
            return "";
        }
    }

    public String convertTohex(byte[] bytes) {
        StringBuffer hex = new StringBuffer();
        for (byte b : bytes) {
            hex.append(Character.forDigit((b >>> 4) & 0xF, 16));
            hex.append(Character.forDigit((b) & 0xF, 16));
        }
        return hex.toString();
    }
    
    public String convertTohexBytes(byte[] bytes) {
        StringBuffer hex = new StringBuffer();
        for (byte b : bytes) {
            hex.append(Character.forDigit((b >>> 4) & 0xF, 16));
            hex.append(Character.forDigit((b) & 0xF, 16));
        }
        return hex.toString();
    }

    public String convertTo64BitHashValue(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}


