package org.comp.algo.problems;

import org.junit.Test;

/**
 * 0 1 2 3 4 5 6 7 8 7, 9, 2, 10, 1, 12, 3, 7, 1
 * 
 * 7, 9, 2, 10, 1
 * 
 * 7, 9, 2
 * 
 * , 10, 1
 * 
 * 7, 9m[2], 2, 10[8] c=7-10= 3
 * 
 * 7m, 9=2, 2-10=8
 * 
 * 0 1 2 3 4 5 6 7 8 12, 3, 7, 1
 * 
 * 12, 3(m), 7, 1 3-7=4 12, 3 =-9 7-1=-6
 * 
 * @author hnr543 -
 * @since 1.0
 */
public class BuyAndSell {

    int[] arr = {7, 9, 2, 10, 1, 12, 3, 7, 1};

    @Test
    public void buyAndSell() {
        // nlogn
        System.out.println(dAndQ(arr, 0, arr.length - 1));
    }
    
    @Test
    public void buyAndSellOn() {
        int minSofar = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            minSofar = Math.min(minSofar, arr[i]); 
            maxProfit = Math.max(arr[i]-minSofar, maxProfit);
        }
        System.out.println(maxProfit);
    }

    public int dAndQ(int[] arr, int lo, int hi) {
        if (hi == lo) {
            return -1;
        }
        if (hi - lo == 1) {
            return arr[hi] - arr[lo];
        }
        int m = lo + (hi - lo) / 2;
        int maxR = dAndQ(arr, lo, m);
        int maxL = dAndQ(arr, m + 1, hi);
        int maxC = maxCenter(arr, lo, m, hi);

        return Math.max(maxC, Math.max(maxR, maxL));

    }

    private int maxCenter(int[] arr2, int lo, int m, int hi) {
        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= m; i++) {
            min = Math.min(min, arr[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int j = m + 1; j <= hi; j++) {
            max = Math.max(max, arr[j]);
        }
        return max - min;
    }

}

