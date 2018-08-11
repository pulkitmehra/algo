package org.comp.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Backtracking {
    
    @Test
    public void findSetsWithDuplicate() {
        int[] arr = new int[] {1,2,2,3,3};
        
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        findSets(ans, new ArrayList<>(), arr, 0);
        System.out.println(ans);
        
    }
    
    @Test
    public void findPermutationWithNoDuplicates() {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        permutation("", s, ans );
        
        System.out.println(ans);
        
    }
    
    public void permutation(String curr, String left, List<String> ans) {
        if(left.isEmpty()) {
            ans.add(curr);
            return;
        }
        
        for(int i=0; i < left.length(); i++) {
            String nCurr = left.substring(i, i+1);
            String fhalf = left.substring(0,i);
            String shalf = left.substring(i+1, left.length());
            String nleft = fhalf + shalf;
            permutation(curr+nCurr, nleft, ans);
        }
    }
    
    void findSets(List<List<Integer>> ans, List<Integer> trail, int[] nums, int start){
        ans.add(new ArrayList<>(trail)); //solution found
        
        for (int i=start; i < nums.length; i++) { //when loop ends no further options are available
            if( (i+1) < nums.length && nums[i] == nums[i+1]) {
                continue;
            }
            trail.add(nums[i]);
            findSets(ans, trail, nums, i+1);
            trail.remove(trail.size()-1);
        }
    }
    
    
    @Test
    public void permuteInteger() {
        permute(new int[] {1,2,3,4});
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
     }

     private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
        } else{
           for(int i = 0; i < nums.length; i++){ 
              if(tempList.contains(nums[i])) continue; // element already exists, skip
              tempList.add(nums[i]);
              backtrack(list, tempList, nums);
              tempList.remove(tempList.size() - 1);
           }
        }
     } 

}