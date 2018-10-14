package com.leetcode.premium.fb;

import com.ds.Tree;
import org.junit.Test;

import java.util.List;

/*
    Preorder read and write
 */
public class SerializeAndDeserializeTree {


    @Test
    public void testSerializeDeserialize(){
        Tree.TNode epi = Tree.epi();
        Tree.print(epi);
        String serialize = serialize(epi);
        System.out.println(serialize);
        Tree.print(deserialize(serialize));
    }

    String serialize(Tree.TNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(Tree.TNode root, StringBuilder sb){
        if(root==null){
            sb.append('$');
        }else{
            sb.append(root.val);
            sb.append(',');
            serialize(root.left, sb);
            sb.append(',');
            serialize(root.right, sb);
        }
    }

    Tree.TNode deserialize(String s){
        String[] strs = s.split(",");
        Counter counter = new Counter();
        return deserialize(strs, counter);
    }

    Tree.TNode deserialize(String[] chars, Counter counter){

        if(counter.get() == chars.length) return null;
        String ch = chars[counter.get()];
        counter.incr();

        if(ch.equals("$")){
            return null;
        }

        Tree.TNode left = deserialize(chars, counter);
        Tree.TNode right = deserialize(chars, counter);
        Tree.TNode center = Tree.TNode.get(Integer.parseInt(ch));
        center.left = left;
        center.right = right;
        return center;
    }

    static class Counter {
        int val;
        void incr(){val++;}
        void incr(int i){val +=i;}
        int get(){return val;}
    }

}
