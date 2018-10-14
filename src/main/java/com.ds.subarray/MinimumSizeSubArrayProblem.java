package com.ds.subarray;

import org.junit.Test;

public class MinimumSizeSubArrayProblem {

    /**
     * Idea is to have two pointers one at i=0 and j=0
     * increment j until sum is less than the value
     * if equal to value capture subarray size
     * else increment i ad delete from running sum.
     */

    @Test
    public void test(){
        System.out.println(minSubContiguousArray(new int[]{2,3,1,2,4,3}, 7));
    }

    private int minSubContiguousArray(int[] nums, int s) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
            //increase until sum < s
            while (end < nums.length && sum < s) sum += nums[end++];

            //you might not reach the sum
            if (sum < s) break;

            //decrease the ith pointer from sum even its equal
            while (start < end && sum >= s) sum -= nums[start++];

            //get the j variable
            if (end - start + 1 < minLen) minLen = end - start + 1;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
