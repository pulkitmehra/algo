package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.*;

public class TaskScheduler {

    @Test
    public void testMe(){
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F', 'G'};
        System.out.println(leastInterval(tasks, 2));
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, MutInt> freqMap = new HashMap<>();
        Set<Character> chars = new HashSet<>();
        for(int i=0; i< tasks.length;i++){
            freqMap.computeIfAbsent(tasks[i], e -> new MutInt()).incr();
            chars.add(tasks[i]);
        }

        int count = 0, size = freqMap.size();

        while(!freqMap.isEmpty()){

            Iterator<Character> itr = chars.iterator();

            while(itr.hasNext() && !freqMap.isEmpty()){

                Character ch = itr.next();

                if(freqMap.containsKey(ch)){
                     MutInt mut = freqMap.get(ch);
                     if(mut.val > 0) {
                         count++;
                         mut.decr();
                     }
                     if(freqMap.get(ch).val==0)
                        freqMap.remove(ch);

                }
            }
            if(!freqMap.isEmpty() && size <= n){
                count = count + (n+1) - size;
            }
            size = freqMap.size();


        }


        return count;
    }

     static class MutInt {
        int val;
        void incr(){val++;}
        void decr(){val--;}
    }
}
