package org.comp.algo.problems;

import org.junit.Test;

public class LongestPTOAlgorithm {
    
    @Test
    public void longestPTOAlgorithm() {
        int[] arr = {0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0};
        int pto=2;
        int i=0, j=0, rpto=pto, maxCount= Integer.MIN_VALUE;
        while(j<arr.length) {
            System.out.println("s"+i+","+j);
            while(rpto>0) {
                if(arr[j++]==0) {
                    rpto -=1;
                }
            }
            
            while(rpto==0) {
                if(arr[j]==0) {
                    rpto +=1;
                    j--;
                }else{
                    j++;
                }
            }
         
            System.out.println("e"+i+","+j);
            maxCount=Math.max(maxCount, j-i);
            i++;
            while(arr[i]!=1) {
                i++;
            }
        }
        System.out.println(maxCount);
    }

}

