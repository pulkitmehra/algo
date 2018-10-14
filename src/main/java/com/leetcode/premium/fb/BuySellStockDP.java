package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.Arrays;

public class BuySellStockDP {

    @Test
    public void buyAndSellStock(){
        int[] arr = {3,2,6,5,0,3};
        System.out.println( maxProfit(2, arr));
    }

    @Test
    public void buyAndSellStock2(){
        int[] arr = {10,22,15,75,80};
        System.out.println( maxProfit(2, arr));
    }
    public int maxProfit(int k, int[] arr){

        int[][] tab = new int[k+1][arr.length];

        for (int tran=1; tran < k+1; tran++){ //transaction

            for (int day=1; day < arr.length; day++ ){

                int maxValue = 0;
                for(int prev=1; prev< day; prev++){
                    maxValue = Math.max(maxValue, (arr[day]-arr[prev]) + tab[tran-1][prev-1]);
                }
                tab[tran][day] = Math.max(maxValue, tab[tran][day-1]);
            }
        }
        return tab[k][arr.length-1];
    }



}
