package com.ds.tries;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word==null || word.length()==0) return;
        TrieNode curr = root;
        for(Character ch : word.toCharArray()){
            curr.children.putIfAbsent(ch, new TrieNode());
            curr =  curr.children.get(ch);
        }
        curr.isWord = true;
    }


    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null || word.length()==0) return false;
        boolean flag =false;
        return search(word, 0, root);
    }

    boolean search(String word, int idx, TrieNode cur){
        if(cur!=null){
            if(idx == word.length()) {
                return cur.isWord;
            }

            char ch = word.charAt(idx);

            if(ch != '.' && cur.children.get(ch)==null) return false;

            boolean flag = false;
            if(ch == '.'){
                for(char nxt : cur.children.keySet()){
                    if(search(word, idx+1,cur.children.get(nxt))){
                        return true;
                    }
                }
            }else{
                return search(word, idx+1,cur.children.get(ch));
            }
        }
        return false;
    }



    private static class TrieNode {
        public boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
