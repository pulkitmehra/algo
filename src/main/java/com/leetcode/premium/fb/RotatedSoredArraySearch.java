package com.leetcode.premium.fb;

import org.junit.Test;

/**
 *  This looks easy but its difficult to implement
 */
public class RotatedSoredArraySearch {

    int [] arr1 = {4,5,6,7,0,1,2};
    int [] arr2 = {4,5,6,7,8,0,1,2};
    int [] arr3 = {5,1,3};


    int [] arr4 = {0,0,0,8,9,10,0,0};



    @Test
    public void arraySearchTest(){
        System.out.println(search(arr1,0));
        System.out.println(search(arr1,2));
        System.out.println(search(arr1,4));
        System.out.println(search(arr1,6));

        System.out.println(search(arr2,8));
        System.out.println(search(arr2,0));

        System.out.println(search(arr3,5));
    }

    @Test
    public void arraySearchTestInDuplicateRotate() {
        System.out.println(searchInRotatedDuplicateArray(arr4, 10));
    }

    int search(int[] arr, int k){

        int lo =0;
        int hi= arr.length-1;

        while(lo<=hi){
            int m = lo + (hi-lo)/2;
            if(arr[m] == k){
                return m;
            }
            if(arr[lo] <= arr[m]){
                //if left is sorted
                if(arr[lo] <= k && k < arr[m]){
                    //and value lies between l0<k<m -> go left
                    hi = m -1;
                }else{
                    //go right
                    lo = m+1;
                }
            }else{
                //if right is sorted
                if(arr[m] < k && k <= arr[hi]){
                    //and value lies between m<k<hi -> go right

                    lo = m+1;
                }else{
                    //go left
                    hi = m-1;
                }

            }

        }
        return -1;

    }

    public boolean searchInRotatedDuplicateArray(int[] arr, int k){
        return search(arr, k, 0, arr.length-1);
    }

    public boolean search(int[] arr, int k, int lo, int hi){
        if(hi < lo){
            return false;
        }
        int m = lo + (hi-lo)/2;

        if(arr[m]==k) return true;

        if(arr[lo] == arr[hi]){
            //if both lo and hi value are equal so we cannot decide where to go
            //so try both
            return search(arr, k, lo, m-1) || search(arr, k, m+1, hi);
        }else{

            //if left sorted
            if(arr[lo] <= arr[m]){
                if(arr[lo] <= k && k < arr[m]){
                    return  search(arr, k, lo, m-1);
                }else{
                    return search(arr, k, m+1, hi);
                }
            }else{
                //if right sorted
                if(arr[m] < k && k <= arr[hi]){
                    return search(arr, k, m+1, hi);
                }else{
                    return  search(arr, k, lo, m-1);
                }
            }
        }
    }

}
