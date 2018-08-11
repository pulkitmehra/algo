package com.algo.problems.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class MinCoinToReachSum {

    /**
     *  Reccurence
     *  DP[0]=0
     *  DP[-1]=MAX
     *
     *   Reccurence  = 1+ min { func(Sum-CoinA) + func(Sum-CoinB) + func(Sum-CoinC)
     *
     */

    @Test
    public void topDownApproach(){
        int [] coins = {1,3,5};
        int sum=4;
        int[] memo = new int[sum+1];
        Arrays.fill(memo, -1);
        System.out.println(coin(coins,sum,memo));
        Arrays.fill(memo, -1);
        System.out.println(coin(coins,sum,memo));
    }

    int coin(int[] coins, int sum, int[] memo){
        if(sum == 0) return 0;
        if(sum < 0) return -1;
        if(memo[sum] != -1)return memo[sum];

        int currSum = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            final int coin = coin(coins, sum - coins[i], memo);
            if(coin >= 0){
                currSum = Math.min(currSum, 1+coin);
            }
        }
        memo[sum]=currSum ;
        return currSum;
    }


    /**
     *  sum     0   1   2   3   4
     *  coins
     *   0      0   0   0   0   0  (0 coins required)
     *
     *   1      0   1   2   3   4
     *
     *   2      0   0   1   2   2
     *
     *   3      0   0   0   1   2
     *   ----------------------------
     *   min    0   1   1   1   2   (min coins = 2)
     **  ----------------------------
     */
    int bottomUp(int[] coins, int sum, int[] dp){


        for(int s = 1; s<sum; s++){
            int min=Integer.MAX_VALUE;
            for(int c=0; c < coins.length; c++){
                if(s >= coins[c]){
                    int ways = dp[s - coins[c]]+1;
                    min = Math.min(min, ways);
                }
                dp[s] = min;
            }
        }
        return dp[sum];
    }
}
