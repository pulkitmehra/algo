package com.leetcode.premium.fb;

import org.junit.Test;

public class BinaryAdditionOnString {


    @Test
    public void addTwoBinary(){
        System.out.println(addBinary("110","111"));
    }
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int carry=0;

        int i=a.length()-1, j=b.length()-1;

        while(i >=0 || j>=0){

            int chA = i >= 0 ? a.charAt(i)-'0' : 0;
            int chB = j >= 0 ? b.charAt(j)-'0' : 0;

            int val = chA ^ chB ^ carry;

            sb.append(val);

            carry = (chA & chB) | (chA & carry) | (chB & carry);
            j--;
            i--;
        }
        if(carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
