package org.comp.algo.bitman;

import org.junit.Test;

public class BitManTest {

    
    @Test
    public void shift() {
        int b = 0b1111, size = 10; //1010
        System.out.println(size >>> 2);
    }
    
    @Test
    public void repeatAirtmeticShift() {
        int x = -93242;
        System.out.println(Integer.toBinaryString(x));
        int count = 40;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum = x >>= 1;
            System.out.println(i + "," + Integer.toBinaryString(x));
        }
        x = -93242;
        sum = 0;
        System.out.println("------------------------------------------");
        for (int i = 0; i < count; i++) {
            sum = x >>>= 1;
            System.out.println(Integer.toBinaryString(x));
        }

    }

    @Test
    public void checkIfAbitIsOn() {
        int i = 10; // 1010
        System.out.println(Integer.toBinaryString(i));

        System.out.println(Integer.toBinaryString(1 << 3));

        System.out.println("see third bit is on " + ((i & (1 << 3)) != 0));
    }

    @Test
    public void turnOnSomeBit() {
        int i = 10; // 1010
        System.out.println(Integer.toBinaryString(i));

        // we want to turn on 3 bit
        System.out.println(Integer.toBinaryString(1 << 2));
        // turn on 3 bit from 0 to 1
        System.out.println(Integer.toBinaryString(i | (1 << 2)));
    }

    @Test
    public void turnOffSomeBit() {
        int i = 10; // 1010
        System.out.println(Integer.toBinaryString(i));

        // we want to turn off 2 bit
        System.out.println(Integer.toBinaryString(1 << 1));
        // turn off 2 bit from 1 to 0
        System.out.println(Integer.toBinaryString(i & ~(1 << 1)));
    }

    @Test
    public void turnOffAllBitBeforeIthPositionInclusive() {
        int i = 15; // 1111
        System.out.println(Integer.toBinaryString(i));

        // we want to turn off from everything starting 3 to most significant bit. In 1111, bit 4 & 3
        System.out.println(Integer.toBinaryString(1 << 2));

        // subtract -1 from it
        System.out.println(Integer.toBinaryString((1 << 2) - 1));

        // turn off first 2 bits
        System.out.println(Integer.toBinaryString(i & ((1 << 2) - 1)));
    }

    @Test
    public void turnOffAllBitAfterIthPositiontoZeroInclusive() {
        int i = 15; // 1111
        System.out.println(Integer.toBinaryString(i));

        int mask = -1 << (2 + 1);
        // we want to turn off from everything starting 3 to most significant bit. In 1111, bit 4 & 3
        System.out.println(Integer.toBinaryString(mask));

        System.out.println(Integer.toBinaryString(i & mask));
    }

    @Test
    public void updateBitZeroAtPosition() {
        int num = 15;
        System.out.println(Integer.toBinaryString(num));
        int mask = ~(1 << 2);
        System.out.println(Integer.toBinaryString(mask));

        // turn off ith bit
        System.out.println(Integer.toBinaryString(num & mask));
        // set 0 on the ith bit
        System.out.println(Integer.toBinaryString((num & mask) | (0 << 2)));
        // set 1 on the ith bit
        System.out.println(Integer.toBinaryString((num & mask) | (1 << 2)));

        System.out.println(Integer.toBinaryString(10 & ~(1 << 1)));
    }

    @Test
    public void setBitsinAnumber() {
        // System.out.println(Integer.bitCount(-1));
        // System.out.println(Integer.toBinaryString(-1));

        int m = 0b1001101111;
        int n = 0b1010;
        int i = 2;
        int j = 5;

        // set bits to zero from 2 to 5
        System.out.println(Integer.toBinaryString(m));
        for (int k = i; k <= j; k++) {

            int mask = ~(1 << k);
            m = (m & mask);
        }

        System.out.println(Integer.toBinaryString(m));

        System.out.println(Integer.toBinaryString(m | (n << i)));

        // Other way of doing it
        m = 0b1001101111;
        n = 0b1010;
        System.out.println("------------------------------------");
        int left1s = ~0 << (j + 1); // 11100000
        int right1s = (1 << i) - 1; // 000000011
        int mask = left1s | right1s;
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(Integer.toBinaryString(m & mask));
        System.out.println(Integer.toBinaryString((m & mask) | (n << i)));
    }

    @Test
    public void test() {
        System.out.println(Integer.BYTES);
        System.out.println(Integer.toBinaryString(25));
        System.out.println(Integer.toBinaryString(25 >>> 1));
    }

}