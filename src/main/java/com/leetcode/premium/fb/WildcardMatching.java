package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class WildcardMatching {


    @Test
    public void wildCardMatching() {
        // System.out.println(isMatch("aa","*"));
        //System.out.println(isMatch("cb","?a"));
        //System.out.println(isMatch("adceb","*a*b"));
        System.out.println(Solution.isMatchMain("acdcb", "a*c?cb"));

        //System.out.println(isMatch("","*"));
        //System.out.println(isMatch("a","a*"));
        //System.out.println(isMatch("ho","ho**"));

    }

    public static class Solution {


        public static boolean isMatchMain(String s, String p){
            int sLen = s.length();
            int pLen = p.length();
            boolean[][] table= new boolean[sLen + 1][pLen + 1];
            boolean flag = isMatch(s,p, table);
            for(int i=0; i<table.length; i++){
                System.out.print("["+i+"]=");
                for(int j=0; j<table[i].length; j++){
                    System.out.print(" "+table[i][j]+" ");
                }
                System.out.println();
            }
            return flag;
        }

        public static boolean isMatch(String s, String p, boolean[][] table) {

            int sLen = s.length();
            int pLen = p.length();


            if (sLen == 0 && pLen == 0) return true;
            if (sLen > 0 && pLen == 0) return false;



            table[0][0] = true;

            for (int i = 1; i <= sLen; i++) {
                table[i][0] = false;
            }

            for (int i = 1; i <= pLen; i++) {
                if (p.charAt(i - 1) == '*') {
                    table[0][i] = table[0][i - 1];
                } else {
                    table[0][i] = false;
                }
            }

            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                        table[i][j] = table[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        table[i][j] = table[i][j - 1] || table[i - 1][j];
                    } else {
                        table[i][j] = false;
                    }
                }
            }

            return table[sLen][pLen];
        }

    }

    public static class BadSolution1 {

        static boolean isMatch(String s, String p) {
            if (s == null || p == null) return false;
            return isMatch(s, p, 0, 0, "00n");

        }

        static HashMap<String, Boolean> memo = new HashMap<String, Boolean>();

        static boolean isMatch(String s, String p, int is, int ip, String op) {
            if (memo.containsKey(op)) {
                return memo.get(op);
            }
            if ((s.length() == is && ip != p.length()) || (s.length() != is && ip == p.length())) {
                return checkBase(s, p, is, ip);
            }
            if (s.length() == is && p.length() == ip) {
                return true;
            }

            char sch = s.charAt(is);
            char pch = p.charAt(ip);
            boolean flag = false;
            if ((pch == '?') || (pch >= 'a' && pch <= 'z' && sch == pch)) {
                flag = isMatch(s, p, is + 1, ip + 1, "" + is + ip + "m");
            } else if (pch == '*') {
                flag = isMatch(s, p, is, ip + 1, is + ip + "*e") || //* as empty space
                        isMatch(s, p, is + 1, ip, is + ip + "*nc") || //* not consumed
                        isMatch(s, p, is + 1, ip + 1, is + ip + "*c"); //* consumed
            }
            memo.put(op, flag);
            return memo.get(op);
        }

        static boolean checkBase(String s, String p, int is, int ip) {
            String ss = s.substring(is);
            String pp = p.substring(ip);
            if (ss.isEmpty()) {
                return ifPatternHasAllStar(pp);
            }
            return false;
        }

        static private boolean ifPatternHasAllStar(String p) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
    }
}
