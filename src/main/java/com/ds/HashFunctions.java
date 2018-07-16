package com.ds;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashFunctions {

    /**
     * Generally the array size should be a prime number. We determine prime number
     * by first taking the tolerance of collision, say 3. Then get the size of key
     * you foresee to load, say 2000, then 2000/3 = 666, choose the closes prime
     * number, such that its not close to 2^x, for example we can pick 661 as prime
     * number but its close to 2^9=512, so lets be far from it and choose another
     * prime 719.
     */
    public static int hashByDivision(String s, int mod) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += i * s.charAt(i);
        }
        return hash % mod;
    }

    /**
     * add the key with power of prime.Could overflow. abc -> ASCII (97) (98) (99)
     * [97 * 3^0] + [98 * 3^1] + [99 * 3^2] Use Horner method for efficient hash
     */
    public static int hashForStrings(String key, int mod) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += (Math.pow(3, i)) * key.charAt(i);
        }
        return hash % mod;
    }

    public static int hashByHorner(String key, int mod) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (32 * hash + key.charAt(i)) % mod;
        }
        return hash;
    }

    public static byte[] getMd5HashInBytes(String value) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(value.getBytes());
            return md5.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * This has loss of preision because
     * MD5 is 128 bit - 16 bytes
     * int is 32 bits - 4Bytes
     * long is 64 bit - 8 bytes
     * <p>
     * Only BigInteger could do
     *
     * @param key
     * @return
     */
    public static long md5To64Bit(String key) {
        byte[] bKey = getMd5HashInBytes(key);
        long res =
                ((long) (bKey[7] & 0xFF) << 56) |
                        ((long) (bKey[6] & 0xFF) << 48) |
                        ((long) (bKey[5] & 0xFF) << 40) |
                        ((long) (bKey[4] & 0xFF) << 32) |
                        ((long) (bKey[3] & 0xFF) << 32) |
                        ((long) (bKey[2] & 0xFF) << 16) |
                        ((long) (bKey[1] & 0xFF) << 8) |
                        bKey[0] & 0xFF;
        return res;
    }

    public static int lowerbitHash(String key, int bit){
        int mask=0, h=0;
        //for 4 bit its equivalent to 0XF
        //Can do Math.pow(2,bit)-1)
        for(int i = 0; i< bit; i++){
            mask = mask<<1 | 1;
        }
        //reduce 32 bit hash code to lower bits. ^ is to get good distribution
        //hashcode-           11001111001011111
        //(h >>> bit)         00001100111100101
        //^                   11001111001011110
        // & mask             11001111001011110 & 0000000000001111
        return ((h=key.hashCode() * 31)  ^ (h >>> bit)) & mask ;
    }

    public static BigInteger md5ToBigInteger(String key) {
        byte[] bKey = getMd5HashInBytes(key);
        //bytes to 32 bit hex to BigInteger
        return new BigInteger(DatatypeConverter.printHexBinary(bKey),16);
    }

    public static String getMd5HashInString(String value) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(value.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Hash cant be calculated");
    }

}
