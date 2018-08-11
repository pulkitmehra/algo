package org.comp.algo.problems;

import org.junit.Test;

public class ParityCheck {

    @Test
    public void parityChecker() {
        int i = 0b110101;

        int c = 0;
        while (i != 0) {
            c += i & 1;
            i >>>= 1;
        }
        System.out.println(c % 2);
    }

    @Test
    public void efficientParityBit() {
        int i = 0b11010;

        short c = 0;
        while (i != 0) {
            c ^= i & 1; // this xor to keep updated value
            i >>>= 1;
        }
        System.out.println(c);

    }

    @Test
    public void efficientParityBit2UseCachine() {
        int[] cache = {0, 1, 1, 0};
        byte i = 0b00101010;

        short bit_size = 2;
        short mask = 0b11;
        // push 6 bits to get 00.[6,7] And with 11 to get last two digits only
        int j=cache[ (int) ((i >>> (bit_size* 3)) & mask)];
        
        // push 4 bits to get 10 [5,4]. And with 11 to get last two digits only
        int k=cache[ (int) ((i >>> (bit_size* 2)) & mask)];
        
        //push 2 bits to get 10  [3,2]. And with 11 to get last two digits only
        int l=cache[ (int) ((i >>> (bit_size)) & mask)];
        
      //No push because its last two bits 10  [1,0]. And with 11 to get last two digits only
        int m=cache[ (int) (i & mask)];
        
        //XOR it to keep running parity.
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
        System.out.println(m);
        System.out.println(j ^ k ^ l ^ m);

    }

}

