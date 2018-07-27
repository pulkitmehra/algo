package com.ds;

import org.junit.Test;

import java.math.BigDecimal;

public class FloatingPoint {

    @Test
    public void floatingPoint() {
        double value = 0.585;
        System.out.println(new BigDecimal(value));
        System.out.println(BigDecimal.valueOf(value));
    }

    @Test
    public void doubleEpsilonValue() {
        System.out.println(compare(1.36d, 1.26d));
        System.out.println(compare2(1.36d, 1.26d));

    }

    /*
    https://stackoverflow.com/questions/44878288/why-does-normalization-address-precision-problems-in-comparing-doubles
     */
    @Test
    public void epsilonNormalization(){
        double a = 1.00000001233;
        double b = 1.000000233899999;

        System.out.println(a==b);
        System.out.println(compare(a, b)==0);
    }

    public int compare(double a, double b){
        double epsilon = 0.000001;
        double diff = (a-b)/Math.max(Math.abs(a), Math.abs(b));
        return diff < -epsilon ? -1 : diff > epsilon ? 1 : 0;
    }



    @Test
    public void flaotProblem() {
        double i = 0.1;
        double sum = 0;

        for (int j = 0; j < 10; ++j) {
            sum += i;
        }
        double product = i * 10;
        System.out.println(String.format("sum = %1.15f, mul = %1.15f, mul2 = %1.15f\n",
                sum, product, sum * 10));

    }

    public double compare1(double a, double b) {
        return a - b;
    }

    public double compare2(double a, double b) {
        return (a - b) / (Math.max(Math.abs(a), Math.abs(b)));
    }
}
