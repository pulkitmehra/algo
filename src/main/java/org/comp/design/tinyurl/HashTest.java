package org.comp.design.tinyurl;

import java.util.Base64;

import org.junit.Test;

public class HashTest {

    HashingKeys hashKeys = new HashingKeys();

    @Test
    public void create128BitHashUsingMD() {
        String url = "google.com";
        byte[] bytes = hashKeys.getHash(url);
        System.out.println(bytes);
        String hex = hashKeys.convertTohex(bytes);
        System.out.println(hex);
        System.out.println(hashKeys.convertTo64BitHashValue(bytes));

    }

    /**
     * 
     * Base64 encoding schemes are commonly used when there is a need to encode binary data that needs be stored and
     * transferred over media that are designed to deal with textual data. This is to ensure that the data remains
     * intact without modification during transport.
     * 
     * https://www.youtube.com/watch?v=g8OhjcudKAo
     * 
     * Decimal 101 -> base 2 -> 01100101
     * 
     * :Base16 -> 01100101 -> (break into 4 cuz 2^4=16) -> 0110 , 0101 -> 0110 in decimal is 6, 0101 in decimal is 5 =
     * 65 :Base64
     * 
     * - Binary data is arranged in continuous chunks of 24 bits (3 bytes) each.
     * 
     * - Each 24 bits chunk is grouped into four parts of 6 bit each.
     * 
     * - If not multiple of 24 pad with 0 at right
     * 
     * 
     * -> 01100101 -> convert to 3 bytes 011001, 010000, 000000, 000000 (break into 6 cuz 2^6=64) we pad at the end ->
     * -> 011001 (25 decimal), 100000 (16 decimal), 000000 (0), 000000 (0) -> ZQ==
     * 
     * 
     * http://cloudway.io/post/base64-encoded-128-bit/
     * 
     * (4 digits for hexadecimal)1111 = (2^3) + (2^2) + (2^1) + (2^0)=15
     * 
     * 0-9 -> 0-9 | 10-15 -> a,b,c,d,e,f
     * 
     * MD5 hash has 128 bits which is 16 bytes. Biggest decimal value that 1 byte (8 bits) can hold is 255. From the
     * chart above, we know hexadecimal FF represents 255 as well (16 x 15 + 15).
     *
     * We need 2 digit hexadecimal number (FF) to represent max value in a byte which is 1111 1111. To represent 16
     * bytes (128 bits), we need a 32 digit hexadecimal number. If you go back and check the output of md5 command
     * above, you will see it is exactly 32 digits long. So 128 / 4= 32
     * 
     * Same as above 128/6=24 length
     * 
     * 0-25 -> A-Z | 26-51 -> a-z | 52-61 -> 0-9 | 62 -> + | 63 -> /
     * 
     * MD5 - 16 byte data converting to base16 makes it 32 length converting to base64 makes it 24 length
     * 
     * 
     */
    @Test
    public void create128BitHashUsingMDMany() {
        String[] urls = {"htpp:sdasasd.comdasdsDDASDASDASD", "htpp:s.COM", "htpp:sdasaZDASDASDDDDDDDDDDDDDDDDDDDsd.com",
                "htpp:sdasasd.SADSDSDWQWQcom"};
        for (String url : urls) {

            byte[] md516Bytes = hashKeys.getHash(url);
            String md516BytesStr = new String(md516Bytes);
            String bas64String = hashKeys.convertTo64BitHashValue(md516Bytes);
            byte[] base64Byte = Base64.getEncoder().encode(md516Bytes);
            String convertTohexBytes = hashKeys.convertTohexBytes(md516Bytes);

            System.out.println(String.format(" md5: %s len: %d  | bas64: %s len: %d | hex: %s len: %d ", md516BytesStr, md516Bytes.length,
                    bas64String, base64Byte.length, convertTohexBytes, convertTohexBytes.getBytes().length));

        }
    }
}


