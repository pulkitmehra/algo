package com.ds.tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    TrieNode root = new TrieNode();

    public void insert(String key) {
        if(key==null || key.length()==0) return;
        TrieNode curr = root;
        for(Character ch : key.toCharArray()){
            curr.children.putIfAbsent(ch, new TrieNode());
            curr =  curr.children.get(ch);
        }
        curr.isRoot = true;
    }

    public String findRoot(TrieNode root, String any, int idx, String bktrk){
        if(root!=null){
            if(idx == any.length()) return null;
            if(root.isRoot){
                return bktrk;
            }

            Character ch = any.charAt(idx);
            TrieNode child = root.children.get(ch);
            if(child!=null){
                return findRoot(child, any, idx+1, bktrk + ch);
            }
        }
        return null;
    }

    public String replaceWords(List<String> dict, String sentence) {
        if(dict==null || dict.size()==0) return sentence;
        if(sentence==null || sentence.length()==0) return null;

        for(String word :  dict){
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(int i=0; i< words.length; ++i){
            String found = findRoot(root, words[i], 0, "");
            if(found!=null){
                sb.append(found);
            }else{
                sb.append(words[i]);
            }
            if(i < words.length-1 ){
                sb.append(' ');
            }
        }
        return sb.toString();

    }

    public static class TrieNode {
        public boolean isRoot;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}
