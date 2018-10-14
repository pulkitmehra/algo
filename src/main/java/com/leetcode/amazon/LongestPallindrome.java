package com.leetcode.amazon;

import org.junit.Test;

public class LongestPallindrome {

    String max = "";

    @Test
    public void longestPallindrome(){
        String s = "babad";
        longestPalli(0, s.length()-1,s.toCharArray(), s);
        System.out.println(max);
    }



    public void longestPalli(int start, int end,char[] arr, String s){
        int lo=start;
        int hi=end;
        while(lo < hi){
            if(arr[lo] == arr[hi]){
                lo++;
                hi--;
            }else{
                longestPalli(start, hi-1,arr,s);
                longestPalli(lo+1, hi, arr,s);
            }
        }
        String sub = s.substring(start,end+1);
        if(sub.length() > max.length()){
            max = sub;
        }
    }

    public String longestPalindrome(String s) {
        if(s==null || s.isEmpty() || s.length()==1) return s;

        char[] arr = s.toCharArray();

        int aLo = -1;
        int aHi= -1;
        int max =0;

        for(int idx=0; idx < arr.length; idx++){

            int lo=idx-1;
            int hi=idx+1;
            System.out.println(idx);
            //for 3 or more
            while(lo>= 0 && hi<= arr.length-1){
                if(arr[lo] == arr[hi]) {
                    int cur = (hi - lo) + 1;
                    if (max < cur) {
                        max = cur;
                        aLo = lo;
                        aHi = hi + 1;
                        System.out.println("max " + max);
                    }
                    lo--;
                    hi++;
                }else{
                        System.out.println("break;");
                        break;
                    }
                }

            //for 2 only
            if(idx!=0 && max==0){
                if(arr[idx] == arr[idx-1]){
                    max=2;
                    aLo = idx-1;
                    aHi = idx+1;
                }
            }
        }
        return aLo!=-1 && aHi!=-1 ? s.substring(aLo, aHi) : "";
    }

}
