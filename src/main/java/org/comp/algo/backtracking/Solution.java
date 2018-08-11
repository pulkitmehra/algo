package org.comp.algo.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    
    
    Map<String, String> map = new HashMap<>();
    {
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    }
     public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("22"));
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Queue<List<String>> q = new LinkedList<>();
        
        for(int i = 0; i < digits.length(); i++){
            char ch = digits.charAt(i);
            String e = map.get(String.valueOf(ch));
            List<String> l = new ArrayList<>();
            l.add(e);
            q.offer(l);    
        }
        
        while(q.size() > 1){
            List<String> a = q.poll();
            List<String> b = q.poll();
            List<String> newList = multiply(a, b);
            if(!newList.isEmpty()){
                q.offer(newList);
            }
        }
        return q.poll();
   }
    
  List<String> multiply(List<String> a, List<String> b){
    List<String> main=new ArrayList<>();
    List<String>  longer =  a.size() >= b.size() ? a : b;
    List<String>  shorter = a.size() < b.size()  ? a : b; 
    for(int i=0; i < shorter.size(); i++){
      for(int j=0; j < longer.size(); j++){
            List<String> s = multiply(shorter.get(i), longer.get(j));
           if(!s.isEmpty()){
              main.addAll(s);
           }
      }
    }
    return main;
 }

 List<String> multiply(String a, String b){
      List<String> s=new ArrayList<>();
     
      
      String longer =  a.length() >= b.length() ? a : b;
      String shorter = a.length() < b.length()  ? a : b; 

      for(int i=0; i < shorter.length(); i++){
          for(int j=0; j < longer.length(); j++){
              s.add(String.valueOf(shorter.charAt(i))+String.valueOf(longer.charAt(j)));
          }
      }
      return s;
 }
}
