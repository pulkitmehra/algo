package com.ds.tries;

import org.junit.Test;

import java.util.*;

public class AutoCompleteSystem {

    public AutoCompleteSystem(){}



    TrieNodeAC root = new TrieNodeAC();
    String query="";


    public void insert(String key, int times) {
        if(key==null || key.length()==0) return;
        TrieNodeAC curr = root;
        for(Character ch : key.toCharArray()){
            curr.children.putIfAbsent(ch, new TrieNodeAC());
            curr =  curr.children.get(ch);
        }
        curr.isWord = true;
        curr.times += times;
    }


    public TrieNodeAC search(String any){
        TrieNodeAC cur = root;
        for (Character ch : any.toCharArray()) {
            if(!cur.children.containsKey(ch)){
                return null;
            }
            cur = cur.children.get(ch);
        }
        return cur;
    }

    public TrieNodeAC search(char ch){
        TrieNodeAC cur = root;
        if(!cur.children.containsKey(ch)){
            return null;
        }
        return cur;
    }


    public AutoCompleteSystem(String[] sentences, int[] times) {
        for(int i=0; i<sentences.length; i++){
            insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c != '#'){
            query +=c;
        }
        PriorityQueue<Result> maxHeap = new PriorityQueue(3);

        TrieNodeAC found = search(query);
        List<Result> results = new ArrayList<>();
        findStrings(found, query,results);

        for(Result res : results){
            if(maxHeap.size() < 3){
                maxHeap.offer(res);
            }else if(maxHeap.peek().compareTo(res) > 0){
                maxHeap.poll();
                maxHeap.offer(res);
            }
        }
        List<String> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll().sentence);
        }
        if(c == '#'){
            insert(query, 1);
            query="";
        }
        return ans;
    }


    public void findStrings(TrieNodeAC found, String prefix, List<Result> results){
        if(found!=null){
            if(found.isWord){
                results.add(new Result(prefix, found.times));
            }

            for(Character ch : found.children.keySet()){
                findStrings(found.children.get(ch), prefix + ch, results);
            }
        }
    }

    public static class Result implements Comparable<Result> {
        String sentence;
        int times;
        public Result(String sentence,int times ){
            this.sentence = sentence;
            this.times = times;
        }

        public int compareTo(Result other){
            if(this.times == other.times){
                return this.sentence.compareTo(other.sentence);
            }
            return this.times < other.times ? -1 : 1;
        }

    }


    public static class TrieNodeAC {
        public boolean isWord;
        public int times;
        Map<Character, TrieNodeAC> children = new HashMap<>();
    }


}
