package com.ds.subarray;

import org.junit.Test;

public class MaximumSubArray {


    int[] arr = {-2, 3, 2, 5,  -1};
    /**
     *  Idea is that
     *  max(max till now, or (max+A[i]))
     */

    @Test
    public void test(){
        System.out.println(kadanes(arr));
    }

    public int kadanes(int[] arr){

        int max=0;

        int globalmax = arr[0];

        for(int i=0; i< arr.length; i++){
            max=Math.max(max, max+arr[i]);
            if(max > globalmax) globalmax = max;
        }

        return globalmax;
    }
}
