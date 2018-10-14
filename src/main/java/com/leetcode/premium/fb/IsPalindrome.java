package com.leetcode.premium.fb;

import org.junit.Test;

public class IsPalindrome {

    @Test
    public void testMe(){
        //System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return true;
        }


        int i=0, j=s.length()-1;


        while(i<j){


            //can use Character.isLetterOrDigit()
            while(i<j && !Character.isDigit(s.charAt(i)) && (s.charAt(i) < 'a' || s.charAt(i) > 'z')) {
                i++;
            }

            while(i<j && !Character.isDigit(s.charAt(j)) && (s.charAt(j) < 'a' || s.charAt(j) > 'z')) {
                j--;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;

            i++; j--;
        }

        return true;
    }

}
