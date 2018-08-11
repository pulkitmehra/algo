package com.ds.tries;

import org.junit.Test;

public class TriesTest {

    @Test
    public void inertTest(){
        Tries t = new Tries();
        t.insert("bad");
        System.out.println(t.isPresent("bad"));
        System.out.println(t.startsWith("bas"));
    }

    @Test
    public void test(){
        String[] words = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5,3,2,2};
        AutoCompleteSystem auto= new AutoCompleteSystem(words, times);
        System.out.println(auto.input('i'));
        System.out.println("---------");
        System.out.println(auto.input(' '));
        System.out.println("---------");
        System.out.println(auto.input('a'));
        System.out.println("---------");
        System.out.println(auto.input('#'));
    }

    @Test
    public void wordDictionary(){
        WordDictionary dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");

        System.out.println(dict.search("a"));
    }


}
