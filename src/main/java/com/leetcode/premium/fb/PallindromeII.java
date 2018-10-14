package com.leetcode.premium.fb;

import org.junit.Test;

public class PallindromeII {

    @Test
    public void testPallindrome(){
        String s = "tebbem";
        System.out.println(isPallindrome(s, 0, s.length()-1, 1));
    }

    public boolean isPallindrome(String s, int lo, int hi, int i){
        if(i < 0) return false;


        while(lo < hi && s.charAt(lo) == s.charAt(hi)){
            lo++;
            hi--;
        }

        if(lo < hi){
            return isPallindrome(s, lo+1,hi, i-1 ) || isPallindrome(s, lo, hi-1, i-1);
        }
        return true;
    }
}
