package com.leetcode.premium.fb;

import com.ds.Tree;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {


    @Test
    public void verticalOrderTest(){
        Tree.TNode root = small();
        Tree.print(root);
    }

    @Test
    public void verticalOrder(){
        Tree.TNode root = small();

        Queue<Integer> colQ = new ArrayDeque<>();
        Queue<Tree.TNode> treeQ = new ArrayDeque<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        colQ.offer(0);
        treeQ.offer(root);

        while (!treeQ.isEmpty()){
            Tree.TNode currNode = treeQ.poll();
            Integer col = colQ.poll();

            map.computeIfAbsent(col, (k) -> new ArrayList<>()).add(currNode.val);

            if(currNode.left!=null){
                colQ.offer(col-1);
                treeQ.offer(currNode.left);
            }

            if(currNode.right!=null){
                colQ.offer(col+1);
                treeQ.offer(currNode.right);
            }
        }

        Collection<List<Integer>> values = map.values();
        for (List<Integer> value : values) {
            System.out.println(value);
        }

        List<List<Integer>> collect = map.values().stream().collect(Collectors.toList());


    }

    public static Tree.TNode small(){
        Tree.TNode root = Tree.TNode.get(1);
        Tree.TNode _2 = Tree.TNode.get(2);
        Tree.TNode _3 = Tree.TNode.get(3);
        root.nodes(_2,_3);

        Tree.TNode _4 = Tree.TNode.get(4);
        Tree.TNode _5 = Tree.TNode.get(5);
        _2.nodes(_4,_5);

        Tree.TNode _6 = Tree.TNode.get(6);
        Tree.TNode _7 = Tree.TNode.get(7);
        _3.nodes(_6,_7);

        return root;
    }
}
