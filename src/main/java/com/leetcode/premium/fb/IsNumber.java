package com.leetcode.premium.fb;

import org.junit.Test;

public class IsNumber {


    @Test
    public void test(){
        System.out.println(isNumber("e9"));
    }

    public boolean isNumber(String s) {
        if(s.length()==0) return false;
        if(s.length()==1) return Character.isDigit(s.charAt(0));

        int e=0, dot=0;
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(e >1 || dot > 1) return false;

            if(ch == 'e'){
                e++;
                if(
                        (i!=0 && i< s.length()-1 &&
                                !Character.isDigit(s.charAt(i-1)) &&
                                !Character.isDigit(s.charAt(i+1))
                        )
                                || i==s.length()-1) return false;
                continue;
            };

            if(ch == '.') {
                dot++;
                continue;
            }

            if(!Character.isDigit(ch)) return false;

        }
        return true;
    }
}
