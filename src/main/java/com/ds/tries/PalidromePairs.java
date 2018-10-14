package com.ds.tries;

import org.junit.Test;

import java.util.*;

public class PalidromePairs {


    @Test
    public void testPairs() {
        System.out.println(palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));
    }


    TrieNode root = new TrieNode();

    void insert(String word, int idx) {
        TrieNode cur = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            cur.children.putIfAbsent(word.charAt(i), new TrieNode());
            if (isPalidrome(word, 0, i)) {
                cur.palIdx.add(idx);
            }
            cur = cur.children.get(word.charAt(i));
        }

        //cur.palIdx.add(idx);
        cur.isWord = true;
        cur.idx = idx;
    }

    public void search(String word, int idx, List<List<Integer>> ans) {
        TrieNode cur = root;

        for (int j = 0; j < word.length(); j++) {

            // the trie word is shorter than the input word
            //example "ssssll" and trie word is 's' , now we should see if the rest of the word is palidrome
            if (cur.idx >= 0 && cur.idx != idx && isPalidrome(word, j, word.length() - 1)) {
                ans.add(Arrays.asList(idx, cur.idx));
            }
            cur = cur.children.get(word.charAt(j));
            if (cur == null) {
                return;
            }
        }
        // word of equal length of key present, and pals with the key
        //example abcd == dcba
        if (cur.idx >= 0 && cur.idx != idx) {
            ans.add(Arrays.asList(idx, cur.idx));
        }
        // trie word is longer than the input, see remaining parts of the trie is  palindromic by getting palIds
        //example s and ssl
        for (int j : cur.palIdx) {
            if (idx != j) {
                ans.add(Arrays.asList(idx, j));
            }
        }


    }

    public List<List<Integer>> palindromePairs(String[] words) {

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            search(words[i], i, ans);
        }

        return ans;
    }

    private TrieNode findPalidrome(TrieNode found) {

        if (found != null) {

            //found.

        }
        return null;
    }

    public boolean isPalidrome(String word, int lo, int hi) {
        while (lo < hi) {
            if (word.charAt(lo++) != word.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }


    public static class TrieNode {
        public boolean isWord;
        int idx = -1;
        List<Integer> palIdx = new ArrayList<>();
        Map<Character, TrieNode> children = new LinkedHashMap<>();
    }
}
