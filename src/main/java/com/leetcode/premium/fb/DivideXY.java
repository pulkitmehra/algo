package com.leetcode.premium.fb;

import org.junit.Test;

public class DivideXY {


    @Test
    public void multiply(){
        System.out.println(3<<2);
    }

    @Test
    public void divide() {
        System.out.println(Integer.toBinaryString(20 << 32));
        System.out.println(divide2(24, 5));

    }

    @Test
    public void sign(){
        int x = -1;
        int y = 1;

        System.out.println(x < 0 ^ y < 0 );

        System.out.println(divide3(-2147483648 ,2));
    }


    public int divide3(int dividend, int divisor){

        if(dividend == 0 || divisor== 0) return 0;
        if((dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) && divisor==1) return dividend;
        if(dividend == Integer.MAX_VALUE && divisor==-1) return Integer.MIN_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;

        boolean isNeg = (dividend) < 0 ^ (divisor < 0);

        long up = Math.abs((long)dividend);
        long lo = Math.abs((long)divisor);
        int quot = 0;

        //O(n2)
        while (up >= lo){

            int k=0;
            while ( (lo << k+1) <= up ){
                k++;
            }
            up -= lo << k;
            quot += 1<<k;
        }
        return isNeg ? -quot : quot;
    }

    public int divide2(int dividend, int divisor) {
        //check if negative answer
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        //use long to take care of overflow
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        long res = 0, curr = 1;
        long sub = ldivisor;

        while (ldividend >= ldivisor) {
            if (ldividend >= sub) {
                res += curr;
                ldividend -= sub;
                sub = sub << 1; //sub = sub * 2
                curr = curr << 1; //curr = curr * 2
            }
            else {
                sub = sub >> 1;
                curr = curr >> 1;
            }
        }

        res = isNeg ? -res : res;

        return (int) (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? Integer.MAX_VALUE : res);
    }

    static int divide(int x, int y) {
        int res = 0;
        int pow = 32;
        int yPow = y << pow;

        while (x >= y) {

            while (yPow > x) {
                System.out.println(yPow >>> 1);
                yPow >>>= 1;
                --pow;
            }

            res += 1 << pow;
            x -= yPow;
        }
        return res;

    }
}
