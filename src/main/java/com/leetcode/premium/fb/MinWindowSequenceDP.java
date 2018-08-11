package com.leetcode.premium.fb;

import org.junit.Test;

public class MinWindowSequenceDP {

    String S = "abcdebdde", T = "bde";

    @Test
    public void testMinSequence(){
        System.out.println(minWindow(S, T));
    }

    /**
     *
     * See pics for reference
     *
     * reccurance is
     *
     *  if(s.char != t.char) increment s and t
     *  if(s.char == t.char)
     *      find(i+1, j+1)
     *      find(i+1, j)
     *
     *  In bottom up approach its
     *      dp[i, j] = dp[i-1], dp[j-1]
     *  else
     *      dp[i][j] = dp[i][j - 1];
     *
     *
     */
    public String minWindow(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }
}
