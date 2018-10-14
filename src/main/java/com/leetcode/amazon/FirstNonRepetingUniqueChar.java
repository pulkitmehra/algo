package com.leetcode.amazon;

import org.junit.*;

public class FirstNonRepetingUniqueChar {

    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++) freq [s.charAt(i) - 'a'] ++;

        //after freq map, iterate this again and see in the map if we can find the char again.
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;

        return -1;

    }


    @Test
    public void reverseWords() {
        reverseWordsByPulkit("the sky is blue".toCharArray());
    }

    public void reverseWordsByPulkit(char[] arr) {

        int i=0, j=arr.length-1, len = arr.length;
        reverse(arr, i,j);
        System.out.println(arr);
        while(i < len && j < len){

            if(i < len && arr[i] == ' ') i++;

            j=i;

            if( (j+1) < len && arr[j+1] != ' '){
                j++;
            }

            System.out.println("reverse "+i+","+j);

            reverse(arr, i, j);

            i=j+1;
        }
    }


    public void reverse(char[] arr, int lo, int hi){
        while(lo<hi){
            char t = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = t;
            lo++; hi--;
        }
    }

}
