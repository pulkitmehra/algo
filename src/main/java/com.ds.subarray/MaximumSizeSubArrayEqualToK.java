package com.ds.subarray;

import org.junit.*;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArrayEqualToK {

    @Test
    public void test(){
        int[] arr = new int[]{2,3,2,-1,2};
        System.out.println(maxSubArrayLen2(arr,1));
    }

    /**
     *
     * Idea is that  sum at index i - sum at index j  = k (where j < i)  then the elements in between should
     * be sum up to k
     *
     * k=3
     * Arr = 1 1 2 -1 0
     * sum = 1 2 4  3 3
     * hist:(sum-index)
     *  [1-0]
     *  [2-1]
     *  [4-2]
     *
     * at sum 4 we subtract 3 = 1. Now see in history if we ever had a sum of 1, if yes, get the difference of
     * index from now to that last index + 1
     */
    public int maxSubArrayLen2(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                max = i + 1;
            }
            else if (map.containsKey(sum - k)){
                int s = i - map.get(sum - k);
                max = Math.max(max, s);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
                System.out.println(sum+"->"+i);
            }
        }
        return max;
    }

    public int maxSubArrayLen(int[] nums, int k) {
       int sum = 0, max = 0; Map<Integer, Integer> sumIndex = new HashMap<>();
       int j=0;
       while(j < nums.length){

           //running sum
           sum += nums[j];

           //sum might have reached the aim
           if (sum == k) max = j + 1;

           // sum at j(curr) - sum at history = k
           //or
           // sum at j(curr) - k = sum at history
           else if(sumIndex.containsKey(sum-k)){
               max = Math.max(max, j - (sumIndex.get(sum-k) + 1));
           }

           //we want to retain old value as its longest subarray. This might change in shortes subarray.
           if (!sumIndex.containsKey(sum))
               sumIndex.put(sum, j);
       }
       return max;
    }
}
