package com.algo.problems;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDecomposition {

    String s = "amanaplanacanal";

    List<String> words = Arrays.asList("can", "apl", "ana");

    @Test
    public void findStringDecomposition() {
        List<Integer> ans = new ArrayList<>();

        //Make freq map word - count
        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //get each word size (3)
        int unit = words.get(0).length();

        //check if  the string has total word length from i
        for (int i = 0; i + (unit * words.size()) < s.length(); i++) {
            if (!match(collect, s, unit, words, i)) {
                continue;
            }
            ans.add(i);
        }

        System.out.println(ans);

    }

    private boolean match(Map<String, Long> collect, String s, int unit, List<String> words, int frm) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {

            //relatively picking 3 letter from provided start
            String sub = s.substring(frm + i * unit, frm + (i + 1) * unit);

            Long numOfFreq = collect.get(sub);

            if (numOfFreq == null) {
                return false;
            }

            freqMap.put(sub, freqMap.getOrDefault(sub,0) + 1);
            if (freqMap.get(sub) > numOfFreq) {
                return false;
            }
        }
        return true;
    }
}
