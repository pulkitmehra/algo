package org.comp.algo.strings;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class StringsAlgo {

    @Test
    @Ignore
    public void uniqueString() {
        for (int i = 0; i <= 258; i++) {
            System.out.println(i + "-" + (char) i);
        }
    }

    @Test
    @Ignore
    public void binaryString() {

        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(-12));
        System.out.println(Integer.toHexString(12));
        System.out.println(Integer.toBinaryString(2 << 11));
        System.out.println(Integer.toHexString(100));

        // number in binary base 2
        System.out.println(Integer.parseInt("00000001", 2) >>> 2);
        System.out.println(Integer.parseInt("00101011", 2) >> 2);
        System.out.println(Integer.parseInt(Integer.toBinaryString(2 << 11), 2));

    }

    @Test
    public void isUniqueString() {
        String s = "aba";
        int checker = 0;
        char a = 'a';
        System.out.println(String.format("a is %d", (int) a));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ch = c;
            int val = (c - 'a');
            System.out.println(String.format("%c - %d - val %d", c, ch, val));
            System.out.println((1 << val) + " - " + (Integer.toBinaryString(1 << val)));
            int and = checker & (1 << val);
            System.out.println("and : " + and + " binary " + Integer.toBinaryString(and));
            if (and > 0) {
                System.out.println("Not unique");
                return;
            }

            checker = checker | (1 << val);
            System.out.println("Checker : " + Integer.toBinaryString(checker));

        }
        System.out.println("Unique");

    }

    @Test
    public void permutationinString() {
        String a = "test";
        String b = "es";
        StringBuilder sb = new StringBuilder(a);
        sb.insert(4, 'a');
        System.out.println(sb.toString());
    }

    @Test
    public void findPermutation() {
        permutation("abcd", "");

    }

    public String permutation(String org, String iter) {
        if (org == "") {
            return iter;
        }
        for (int i = 0; i < org.length(); i++) {
            String nOrg = org.substring(0, i + 1);
            String leftOver = org.substring(i + 1);
            System.out.println(nOrg + "," + leftOver);
            permutation(leftOver, nOrg + leftOver);

            char ch = iter.charAt(0);
            for (int j = 0; j < iter.length(); j++) {
                StringBuilder sb = new StringBuilder(iter.substring(1));
                sb.insert(j, ch);
                System.out.println(sb.toString());
            }
        }
        return "";
    }

    @Test
    public void test() {
        System.out.println("a".substring(0, 1));
    }

    @Test
    public void twoStringsArePermutation() {
        String s = "pulkit";
        String s1 = "tipulk";

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int diff = ch - 'a';
            checker |= 1 << diff;
        }
        System.out.println("print checker " + Integer.toBinaryString(checker));
        int checker2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int diff = ch - 'a';
            checker2 |= 1 << diff;
        }
        System.out.println("print checker2 " + Integer.toBinaryString(checker2));

        int result = checker ^ checker2;
        System.out.println(Integer.toBinaryString(result));
    }

    @Test
    public void testBits() {
        int value = 5;
        System.out.println(Integer.toBinaryString(5));
        while (value != 0) {
            int val = value >>> 1;
            System.out.println(Integer.toBinaryString(val));
            value = value >>> 1;
        }

    }

    @Test
    public void insertDecodingInsteadOfSpace() {
        String url = "http://abc.com/health api call ";

        char[] urlArr = url.toCharArray();
        int count = 0;

        for (int i = 0; i < urlArr.length-1; i++) {
            if(urlArr[i]==' ') {
                count = count + 3;
            }
            count++;
        }
        System.out.println(count);
        
        char[] nUrl =  new char[count];
        int k = count-1;
        for (int i = urlArr.length-2; i >= 0; i--) {
            if(urlArr[i] == ' ') {
                nUrl[k--] = '0';
                nUrl[k--] = '2';
                nUrl[k--] = '%';
                continue;
            }
            nUrl[k--] = urlArr[i];
        }
        
        System.out.println("nUrl"+Arrays.toString(nUrl));
    }
    
    @Test
    public void testDup() {
        System.out.println(Character.getNumericValue('a'));
        System.out.println(Character.getNumericValue('!'));
        
        
    }
    /*
     *  s = madam
     *  mask =  currentBit
     *  bitVector = totalbit seen
     */
    @Test
    public void bitVectorStringIsOneEditAway() {
        
        String s = "pdlae";
        String s2 = "palded";
        
        
        String big = "";
        String small = "";
        if(s2.length() > s.length()) {
            big=s2;
            small = s;
        }else {
            big=s;
            small = s2;
        }
        
        if ((big.length() - small.length()) > 1) {
            System.out.println(false);
            return;
        }
        
        int bitvectorBig = 0;
        for(int i=0; i< big.length(); i++) {
           int diff = big.charAt(i) - 'a';
           int mask = 1 << diff;
           
           if((bitvectorBig & mask )== 0) {
               //not seen, register in bit vector
               bitvectorBig = bitvectorBig | mask;
           }else {
               bitvectorBig = bitvectorBig & mask;
           }
            
        }
        
        int smallBitVector = 0;
        for(int i=0; i< small.length(); i++) {
            int diff = small.charAt(i) - 'a';
            int mask = 1 << diff;
            
            if((smallBitVector & mask )== 0) {
                //not seen, register in bit vector
                smallBitVector = smallBitVector | mask;
            }
             
         }
        
        int remainigVector = bitvectorBig & ~smallBitVector;
        
        //should be one
        System.out.println((remainigVector & (remainigVector - 1)) == 0);
        
        
    }
    
    @Test
    public void testMe() {
        int[][] arr = new int[][] {new int[] {1,2,3},new int[] {1,2,3}};
        System.out.println(arr.length);
        
    }
    
    @Test
    public void leftShift() {
        System.out.println(Integer.toBinaryString(1<<1));
        int num  = 5;
        System.out.println(num +","+Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(num >> 1));
        System.out.println("has c "+ (((num >> 2) & 1)==1));
        System.out.println("has b "+ (((num >> 1) & 1) == 1));
        System.out.println("has a "+ (((num >> 0) & 1) == 1));
        
        
        System.out.println(Integer.toBinaryString(1<<1));
        System.out.println(Integer.toBinaryString(1<<0));
        
        for(int i = 12 ; i > 0; i >>= 1) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

}

