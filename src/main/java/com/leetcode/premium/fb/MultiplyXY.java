package com.leetcode.premium.fb;

public class MultiplyXY {


    public int multiply(int x , int y){

        int sum = 0;
        while(x > 0){
            if((x & 1) == 1){ //last bit is 1
                sum = add(y, sum);
            }

            x = x >>> 1;
            y = y << 1;
        }
        return sum;
    }

    private int add(int y, int sum) {
        return 0;
    }


}
