package com.ds.subarray;

import org.junit.Test;

import java.util.Arrays;

/**
 * This is very difficult question. Impossible to understand.
 */
public class MaxSumOf3NonOverlappingSubArray {



    /**
     *
     * [1, 2, 1, 2, 6, 7, 5, 1], 2
     * [0, 1, 2, 3, 4, 5, 6, 7
     * Since it's 3 non-overlapping sub-array, we can divide it into left, mid, right.
     * Suppose mid is [i, i+k-1] because it needs to hav at least k elements, then
     * we can have left is from [0,i-1] and right is from [i+k, n-1].
     *
     *  Left [0, i-1] < Mid [i, i+k-1] < Right [i+k, n-1]
     *
     *  i is mid
     *  Left should be greater than k : i>=k
     *  Right should have i<=n-2k
     *
     * Since left must have at least k elements then i-1-0+1 >= k , thus we have i>=k
     * Same thing for the right, since n-1-(i-k)+1 >= k, thus we have i<=n-2k
     * Thus we have k<=i<=n-2k , this is very important math to figure out.
     *
     * Then we have 2 arrays which stores the maximum starting index from left and from right.
     *
     * Finally, we figure out when i is in the range mentioned above, what would be the max from left and right and take
     * the global max.
     */
    @Test
    public void test_sum(){
        int[] arr = {1, 2, 1, 2, 6, 7, 5, 1};
        maxSumOfThreeSubarrays(arr, 2);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if(nums==null || nums.length==0) {
            return null;
        }
        int len = nums.length;

        // this is very important because otherwise i+k is going to out of bounds.
        int[] sum = new int[len+1];
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[3];
        int max = 0;

        // Computing the running sum
        // sum[i] stores the value from index 0 to i-1
        for (int i=0; i<len; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        //   {1, 2, 1, 2, 6, 7, 5, 1};
        //Sum[0, 1, 3, 4, 6, 12, 19, 24, 25]
        //Idx[0, 1, 2, 3, 4, 5,  6,  7,  8]

        int leftMax = sum[k]-sum[0];
        //left Max = 3-0=3

        left[k-1] = 0;
        //left [ 0, (0), 0, 0, 0, 0, 0, 0]
        //idx  [ 0, 1,   2, 3, 4, 5, 6, 7]

        for (int i=k; i<len; i++) {
            //k=2
            //i = 2, 3 , 4, 5,6,7,
            if (sum[i+1] - sum[i+1-k] > leftMax) {
                left[i] = i-k+1;
                leftMax = sum[i+1] - sum[i+1-k];
            } else {
                left[i] = left[i-1];
            }
        }

        //traversing from right to left
        int rightMax = sum[len] - sum[len-k];
        right[len-k] = len-k;
        for (int i=len-k-1; i>=0; i--) {
            if (sum[i+k] - sum[i] > rightMax) {
                right[i] = i;
                rightMax = sum[i+k] - sum[i];
            } else {
                right[i] = right[i+1];
            }
        }

        // now consider the middle part where k<=i<=n-2k
        for (int i=k; i<=len-2*k; i++) {
            int l = left[i-1];
            int r = right[i+k];
            int total = (sum[l+k] - sum[l]) + (sum[i+k] - sum[i]) + (sum[r+k] - sum[r]);
            if (total > max) {
                max = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
}
