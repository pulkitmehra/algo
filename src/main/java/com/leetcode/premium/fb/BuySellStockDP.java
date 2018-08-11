package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.Arrays;

public class BuySellStockDP {

    @Test
    public void buyAndSellStock(){
        int[] arr = {3,2,6,5,0,3};
        maxProfit(2, arr);
    }

    public int maxProfit(int k, int[] prices) {

        int len = prices.length;

        if (k >= len / 2)
            return quickSolve(prices);

        int[][] t = new int[k + 1][len];

        for (int i = 1; i <= k; i++) {

            int tmpMax =  -prices[0];

            for (int j = 1; j < len; j++) {
                System.out.println("old tmp "+tmpMax);
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
                System.out.println("("+i+","+j+") "+ "t[i - 1][j - 1] "+t[i - 1][j - 1]+" price[j] "+prices[j]);
                System.out.println("new tmp "+tmpMax);
                for (int[] a : t){
                    System.out.println(Arrays.toString(a));
                }
                System.out.println("------------");
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
