package com.ds;

import org.junit.Test;

public class BreakingByteUsigMask {



    int firstNumber = 12;
    int secondNumber = 15;

    @Test
    public void checkInBinary() {
        System.out.println("Num1 " + Integer.toBinaryString(firstNumber));
        System.out.println("Num2 " + Integer.toBinaryString(secondNumber));


        int b = 0;
        int mask = (byte) 0xF; //is 1111 = 16^0 * 15

        System.out.println("mask " + Integer.toBinaryString(mask));

        b =  (firstNumber & mask);
        System.out.println("first number " + Integer.toBinaryString(b));

        System.out.println("Mask 4 shift number " + Integer.toBinaryString(b << 4));

        b = (secondNumber | (b << 4));

        System.out.println("Second number " + Integer.toBinaryString(b));


        int readFirst = b & 0xF;
        System.out.println("Read First number " + Integer.toBinaryString(readFirst));

        int readSecond = b>>>4 & 0xF;
        System.out.println("Read Second " + Integer.toBinaryString(readSecond));


    }



}
