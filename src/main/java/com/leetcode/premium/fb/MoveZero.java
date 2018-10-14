package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.Arrays;

public class MoveZero {

    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0){
                count++;
            }else if(count > 0){
                nums[i - count] = nums[i];
            }
        }

        Arrays.fill(nums, nums.length - count, nums.length, 0);
    }

    public void moveZeroes(int[] nums) {

        int i=0, j=0, len=nums.length;


        while(i< len && j< len){

            while(i < len && nums[i]!=0) i++;

            j=i;

            while(j < len && nums[j]==0) j++;

            if(j < len && i < len) swap(nums, i, j);
            i++; j++;
        }

    }

    void swap(int[] nums, int i, int j){
        if(i!=j){
            int t = nums[i];
            nums[i]=nums[j];
            nums[j]=t;
        }
    }
}
