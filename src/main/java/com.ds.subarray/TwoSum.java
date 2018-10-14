package com.ds.subarray;

import org.junit.*;

import java.util.*;

public class TwoSum {

    @Test
    public void testTwoSums(){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] arr, int target){
        Map<Integer, Integer>  map = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {

            int key = target - arr[i];
            if(map.containsKey(key)) return new int[]{map.get(key), i};
            map.put(arr[i], i);
        }
        return new int[]{};
    }
}
