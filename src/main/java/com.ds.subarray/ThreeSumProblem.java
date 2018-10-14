package com.ds.subarray;



import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

    int[] arrnums = {-1, 0, 1, 2, -1, -4};

    @Test
    public void threeSum() {
        List<List<Integer>> ans = threeSum(arrnums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    @Test
    public void threeSum2() {
        List<List<Integer>> ans = threeSum2(arrnums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                twoSum(nums, 0 - nums[i], res, nums[i], i);
        }
        return res;
    }

    public void twoSum(int[] arr, int sum, List<List<Integer>> res, int three, int idx) {

        for (int i = idx, j = arr.length - 1; i < j; ) {


            int k = arr[i] + arr[j];

            if (k < sum || i == idx) {
                i++;
            } else if (k > sum || j == idx) {
                j--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(three);
                list.add(arr[i]);
                list.add(arr[j]);
                res.add(list);
                i++;
                j--;
                while (i < j && arr[i] == arr[i - 1]) i++;  // skip same result
                while (i < j && arr[j] == arr[j + 1]) j--;  // skip same result
            }

        }
    }
}
