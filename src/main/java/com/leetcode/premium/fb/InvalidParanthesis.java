package com.leetcode.premium.fb;


import org.junit.Test;

import java.util.*;

public class InvalidParanthesis {

    String sample1 = "()())()";
    String sample2 = "(a)())()";
    String sample3 = ")(";

    @Test
    public void removeInvalidParanthesis() {
        System.out.println(Solution3.removeInvalidParentheses(sample1));
        // System.out.println(fixParanthesis(sample2));
        // System.out.println(fixParanthesis(sample3));
    }

    public static class Solution3 {
        public static List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();

            // sanity check
            if (s == null) return res;

            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();

            // initialize
            queue.add(s);
            visited.add(s);

            boolean found = false;

            while (!queue.isEmpty()) {
                s = queue.poll();

                if (isValid(s)) {
                    // found an answer, add to the result
                    res.add(s);
                    found = true;
                }

                if (found) continue;

                // generate all possible states
                for (int i = 0; i < s.length(); i++) {
                    // we only try to remove left or right paren
                    if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                    String t = s.substring(0, i) + s.substring(i + 1);

                    if (!visited.contains(t)) {
                        // for each state, if it's not visited, add it to the queue
                        queue.add(t);
                        visited.add(t);
                    }
                }
            }

            return res;
        }

        // helper function checks if string s contains valid parantheses
        static boolean isValid(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') count++;
                if (c == ')' && count-- == 0) return false;
            }

            return count == 0;
        }
    }


    public static class Solution2{
        public static List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            remove(s, ans, 0, 0, new char[]{'(', ')'});
            return ans;
        }

        public static void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
            for (int stack = 0, i = last_i; i < s.length(); ++i) {
                if (s.charAt(i) == par[0]) stack++;
                if (s.charAt(i) == par[1]) stack--;
                if (stack >= 0) continue;
                for (int j = last_j; j <= i; ++j)
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                return;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if (par[0] == '(') // finished left to right
                remove(reversed, ans, 0, 0, new char[]{')', '('});
            else // finished right to left
                ans.add(reversed);
        }
    }

    /**
     * This is on the lines of exhausting all options
     */
    public static class Solution1 {
        public static List<String> removeInvalidParentheses(String s) {
            int rmL = 0, rmR = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    rmL++;
                } else if (s.charAt(i) == ')') {
                    if (rmL != 0) {
                        rmL--;
                    } else {
                        rmR++;
                    }
                }
            }
            Set<String> res = new HashSet<>();
            dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
            return new ArrayList<String>(res);
        }

        public static void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
            if (rmL < 0 || rmR < 0 || open < 0) {
                return;
            }
            if (i == s.length()) {
                if (rmL == 0 && rmR == 0 && open == 0) {
                    res.add(sb.toString());
                }
                return;
            }

            char c = s.charAt(i);
            int len = sb.length();

            if (c == '(') {
                dfs(s, i + 1, res, sb, rmL - 1, rmR, open);            // not use (
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

            } else if (c == ')') {
                dfs(s, i + 1, res, sb, rmL, rmR - 1, open);                // not use  )
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);        // use )

            } else {
                dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
            }

            //this is used for backtracking StringBuilder
            sb.setLength(len);
        }
    }
}
