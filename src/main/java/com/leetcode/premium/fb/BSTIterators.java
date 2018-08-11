package com.leetcode.premium.fb;

import com.ds.Tree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Iterator;

public class BSTIterators {
    @Test
    public void testBst(){
        //[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 53]
        //2,3,5,7,11,13,17,19,23,29,31,37,41,43,53,
        Tree.TNode root = Tree.bstepi();
        Tree.print(root);
        BstIterator itr = new BstIterator(root);
        while (itr.hasNext()){
            System.out.print(itr.next()+",");
        }
    }

    static class BstIterator implements Iterator<Integer>{

        ArrayDeque<Tree.TNode> stack = new ArrayDeque<>();

        public BstIterator(Tree.TNode root){
            stack.offer(root);
            while (stack.peek().left!=null){
                stack.push(stack.peek().left);
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            Tree.TNode cur = stack.poll();
            Tree.TNode right = cur.right;
            while (right!=null){
                stack.push(right);
                right = right.left;
            }
            return cur.val;
        }
    }
}
