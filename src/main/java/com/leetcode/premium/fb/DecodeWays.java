package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<String, Integer> memo = new HashMap<>();


    @Test
    public void subStrinTest(){
        System.out.println(Integer.parseInt("01"));
    }

    @Test
    public void numberOfWays(){
        System.out.println(numDecodings2("12512"));
    }

    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }

    public int numDecodings2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public int numDecodings(String s, int curr) {
        if(curr > 26 || curr <= 0){
            return 0;
        }
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(s.isEmpty()){
            return 1;
        }

        int sum = 0;
        int idx =0;
        if( idx +1 <= s.length()){
            sum += numDecodings(s.substring(idx+1),s.charAt(idx)-'0');
        }
        if(idx+2 <= s.length()){
            sum += numDecodings(s.substring(idx+2), Integer.parseInt(s.substring(idx, idx+2)));
        }
        memo.put(s, sum);
        return sum;
    }
}
