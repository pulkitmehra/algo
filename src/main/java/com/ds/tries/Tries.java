package com.ds.tries;

import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tries {

    TrieNode root = new TrieNode();


    public void insert(String word) {
        insert(word, 0);
    }

    public void insert(String word, int val) {
        TrieNode cur = root;
        for (Character ch : word.toCharArray()) {
            cur.children.putIfAbsent(ch, new TrieNode());
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
        cur.val = val;
    }

    public TrieNode search(String any){
        TrieNode cur = root;
        for (Character ch : any.toCharArray()) {
            if(!cur.children.containsKey(ch)){
                return null;
            }
            cur = cur.children.get(ch);
        }
        return cur;
    }

    public boolean isPresent(String word) {
        TrieNode found = search(word);
        return found!=null ? found.isWord : false;
    }

    public boolean startsWith(String word) {
        TrieNode found = search(word);
        return found!=null ? true : false;
    }

    public int sum(String prefix){
        TrieNode found = search(prefix);
        return found!=null ? sum(found) : 0;
    }

    public int sum(TrieNode found){
        if(found!=null) {
            int sum = 0;
            for (Character ch : found.children.keySet()) {
                sum += sum(found.children.get(ch));
            }
            return sum + found.val;
        }
        return 0;
    }

    public static class TrieNode {
        public boolean isWord;
        public Integer val;
        Map<Character, TrieNode> children = new LinkedHashMap<>();

        public void put(Character c, TrieNode v) {
            children.put(c, v);
        }

        public TrieNode get(Character c) {
            return children.get(c);
        }
    }
}
