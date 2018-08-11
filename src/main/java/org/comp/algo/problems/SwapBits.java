package org.comp.algo.problems;

import org.junit.Test;

public class SwapBits {

    @Test
    public void swapBits() {
        int x = 0b00000111;
        System.out.println(Integer.toBinaryString(x));
        int f = 2;
        int t = 7;

        int bitF = (x >>> f) & 1;

        int bitT = (x >>> t) & 1;
        System.out.println(bitF +","+bitT);
        if (bitF != bitT) {

            int mask = (1 << f) | (1 << t);
            System.out.println(Integer.toBinaryString(mask));
            x = mask ^ x;
        }
        System.out.println(Integer.toBinaryString(x));

    }

}


