package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionArray {


    @Test
    public void testMe(){
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ilen = nums1.length;
        int jlen = nums2.length;
        int i=0,j=0;


        List<Integer> list = new ArrayList<>();
        while(i < ilen && j < jlen){

            if(i < ilen && nums1[i]<nums2[j]){
                i++;
            }else if(j < jlen && nums1[i]>nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = new int[list.size()];
        for(int k=0; k < list.size(); k++){
            arr[k] = list.get(k);
        }
        return arr;
    }
}
