package org.comp.algo.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;

import org.comp.algo.tree.TreeDS.BST;
import org.comp.algo.tree.TreeDS.TNode;
import org.comp.algo.tree.TreeDS.Tree;

public class TreeTest {

    @Test
    public void bstTest() {
        BST bst = TreeDS.Tree.getBst();
        bst.print();
        TNode search = bst.search(65);
        System.out.println(search);
    }

    @Test
    public void balancedBst() {
        int[] arr = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TNode balancedBST = balancedBST(arr, 0, arr.length - 1);
        TreeDS.Tree.print(balancedBST, "", true, "");

        System.out.println(balancedBST);
    }

    private TNode balancedBST(int[] arr, int lo, int hi) {
        if (hi < lo) {
            return null;
        }

        int mid = (lo + hi) / 2;
        TNode n = TNode.get(arr[mid]);

        n.left = balancedBST(arr, lo, mid - 1);
        n.right = balancedBST(arr, mid + 1, hi);
        return n;
    }

    @Test
    public void inorder() {
        TNode r = Tree.bt();
        Tree.print(r, "", true, "");

        // 42851637
        inorderTraversal(r);
    }

    @Test
    public void preorder() {
        TNode r = Tree.bt();
        Tree.print(r, "", true, "");

        // 12458367
        preorderTraversal(r);
    }

    @Test
    public void postorder() {
        TNode r = Tree.bt();
        Tree.print(r, "", true, "");

        // 48526731
        postorder(r);
    }

    private void inorderTraversal(TNode n) {
        if (n == null) {
            return;
        }
        inorderTraversal(n.left);
        System.out.print(n.vl + ",");
        inorderTraversal(n.right);
    }

    private void preorderTraversal(TNode n) {
        if (n == null) {
            return;
        }
        System.out.print(n.vl + ",");
        preorderTraversal(n.left);
        preorderTraversal(n.right);
    }

    private void postorder(TNode n) {
        if (n == null) {
            return;
        }

        postorder(n.left);
        postorder(n.right);
        System.out.print(n.vl);
    }

    @Test
    public void depthOfTree() {
        TNode r = Tree.bt();
        System.out.println(depth(r));
    }

    public int depth(TNode n) {
        if (n == null) {
            return 0;
        }
        int l = depth(n.left) + 1;
        int r = depth(n.right) + 1;
        if (l < r) {
            return l;
        } else {
            return r;
        }
    }

    @Test
    public void linkedListAtEveryLevel() {
        Map<Integer, LinkedList<Integer>> m = new HashMap<>();
        TNode r = Tree.bt();
        toLinkedList(m, r, 1);
        System.out.println(m);
    }

    private void toLinkedList(Map<Integer, LinkedList<Integer>> m, TNode n, int d) {
        if (n == null) {
            return;
        }

        toLinkedList(m, n.left, d + 1);
        toLinkedList(m, n.right, d + 1);
        LinkedList<Integer> ll = m.get(d);
        if (ll == null) {
            ll = new LinkedList<>();
            m.put(d, ll);
        }
        ll.add(n.vl);
    }

    @Test
    public void balanceztreeTest() {
        TNode r = Tree.bt();

        System.out.println("Tree is balanced " + (isBalanced(r) != Integer.MIN_VALUE));
    }

    @Test
    public void testATreeIsBalance() {
        BST bst = TreeDS.Tree.getBst();
        bst.print();
    }

    private int isBalanced(TNode n) {
        if (n == null) {
            return -1;
        }
        int l = isBalanced(n.left);
        if (l == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int r = isBalanced(n.right);
        if (r == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return Math.abs(l - r) < 2 ? Math.max(l, r) + 1 : Integer.MIN_VALUE;

    }

    @Test
    public void testToCheckIfaTreeIsBst() {
        BST bst = TreeDS.Tree.getBst2();
        bst.root.left.right.right = TNode.get(11);
        bst.print();
        System.out.println(isTreeBst(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public boolean isTreeBst(TNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if (n.vl >= min && n.vl > max) {
            return false;
        }

        boolean l = isTreeBst(n.left, min, n.vl);
        if (!l) {
            return false;
        }
        boolean r = isTreeBst(n.right, n.vl, max);
        if (!r) {
            return false;
        }
        return (n.left == null || n.left.vl <= n.vl) && (n.right == null || n.vl < n.right.vl);

    }

    @Test
    public void nextInOrderNode() {
        BST bst3 = Tree.getBst3();
        bst3.print();

        inorderTraversal(bst3.root);
        System.out.println("\n vl " + nextInOrderSuccessor(bst3.root, 55));
    }

    private TNode nextInOrderSuccessor(TNode n, int s) {
        if (n == null) {
            return null;
        }

        TNode l = nextInOrderSuccessor(n.left, s);
        if (n.vl == s) {
            if (n.right != null) { // get left most node of right node
                TNode t = n.right;
                while (t.left != null) {
                    t = t.left;
                }
                return t;
            } else { // get the first left node

                TNode c = n;
                TNode p = n.parent;

                while (p != null && p.right != null && p.right.vl == c.vl) {
                    c = p;
                    p = p.parent;
                }

                return p;

            }
        }
        TNode r = nextInOrderSuccessor(n.right, s);

        return l != null ? l : r;
    }

    @Test
    public void nextInPreOrderNode() {
        BST bst3 = Tree.getBst3();
        bst3.print();

        preorderTraversal(bst3.root);
        System.out.println("\n Vl is " + nextNodePreOrderTraversal(bst3.root, 18));
    }

    private TNode nextNodePreOrderTraversal(TNode n, int s) {
        if (n == null) {
            return null;
        }

        if (n.vl == s) {
            if (n.left != null) {
                return n.left;
            } else if (n.right != null) {
                return n.right;
            } else {
                // leaf
                TNode p = n.parent;
                TNode c = n;
                while (p != null && (p.right == null || p.right == c)) {
                    c = p;
                    p = p.parent;
                }
                return p != null ? p.right : null;
            }
        }

        TNode l = nextNodePreOrderTraversal(n.left, s);

        TNode r = nextNodePreOrderTraversal(n.right, s);

        return l != null ? l : r;
    }

    @Test
    public void findNodeAndLevel() {
        BST bst3 = Tree.getBst3();
        bst3.print();

        Res a = findNode(bst3.root, 22);
        System.out.println(a.found + ", at " + a.level);
        Res b = findNode(bst3.root, 15);
        System.out.println(b.found + ", at " + b.level);

        if (!a.isFound() && !b.isFound()) {
            System.out.println("not found");
            return;
        }

        TNode p = a.found;
        TNode q = b.found;
        int pl = a.level;
        int ql = b.level;

        if (pl < ql) {
            while (pl != ql) {
                q = q.parent;
                ql--;
            }
        } else if (pl > ql) {
            while (pl != ql) {
                p = p.parent;
                pl--;
            }
        }
        if (p == q) {
            System.out.println("found p==q" + p);
            return;
        }

        while (p.parent != null && q.parent != null && p.parent != q.parent) {
            p = p.parent;
            q = q.parent;
        }
        System.out.println("found parent " + p.parent);

    }

    Res findNode(TNode n, int v) {
        if (n == null) {
            return new Res(null, -1);
        }
        if (n.vl == v) {
            return new Res(n, 1);
        }

        Res l = findNode(n.left, v);
        if (l.isFound()) {
            return l.incr();
        }
        Res r = findNode(n.right, v);
        if (r.isFound()) {
            return r.incr();
        }
        return new Res(null, -1);
    }

    public static class Res {
        TNode found;

        int level;

        public Res(TNode t, int level) {
            this.found = t;
            this.level = level;
        }

        boolean isFound() {
            return found != null;
        }

        Res incr() {
            this.level = level + 1;
            return this;
        }
    }

    @Test
    public void treeOneContainsOtherTree() {
        BST bst3 = Tree.getBst3();
        bst3.print();

        BST bst4 = Tree.getBst4();
        bst4.print();

        int dt1 = findDepth(bst3.root);
        int dt2 = findDepth(bst4.root);

        TNode big = dt1 > dt2 ? bst3.root : bst4.root;
        TNode small = dt1 <= dt2 ? bst3.root : bst4.root;

        TNode n = findInBig(big, small.vl);
        System.out.println(isEqual(n, small));

    }

    @Test
    public void subTreeLikeSubString() {

        BST bst3 = Tree.getBst3();
        bst3.print();

        BST bst4 = Tree.getBst4();
        bst4.print();

        int dt1 = findDepth(bst3.root);
        int dt2 = findDepth(bst4.root);

        TNode big = dt1 > dt2 ? bst3.root : bst4.root;
        TNode small = dt1 <= dt2 ? bst3.root : bst4.root;

        System.out.println(subtree(big, small));

    }

    @Test
    public void testRandom() {
        BST bst3 = Tree.getBst3();
        bst3.print();

        System.out.println(bst3.random());
        System.out.println(bst3.random());
        System.out.println(bst3.random());
    }

    @Test
    public void randomIth() {
        BST bst3 = Tree.getBst3();
        bst3.print();
        Random r = new Random();
        int i = r.nextInt(bst3.root.size);
        System.out.println("search i" + i);
        System.out.println(getIthElementInorder(bst3.root, i == 0 ? 1 : i));
    }

    public TNode getIthElementInorder(TNode n, int i) {

        int leftSize = n != null && n.left != null ? n.left.size + 1 : 1;
        if (leftSize > i) {
            return getIthElementInorder(n.left, i);
        } else if (leftSize == i) {
            return n;
        } else {
            return getIthElementInorder(n.right, i - leftSize);
        }
    }

    private boolean subtree(TNode p, TNode q) {
        if (p == null) {
            return false;
        }
        if (p.vl == q.vl && isEqual(p, q)) {
            return true;
        }

        return subtree(p.left, q) || subtree(p.right, q);
    }

    boolean isEqual(TNode p, TNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.vl != q.vl) {
            return false;
        }

        return isEqual(p.left, q.left) && isEqual(p.right, q.right);
    }

    TNode findInBig(TNode n, int num) {
        if (n == null) {
            return null;
        }
        if (n.vl == num) {
            return n;
        }
        TNode a = findInBig(n.left, num);
        if (a != null)
            return a;
        TNode b = findInBig(n.right, num);
        if (b != null) {
            return b;
        }
        return a != null ? b : a;
    }

    private int findDepth(TNode n) {
        if (n == null) {
            return 0;
        }

        return Math.max(findDepth(n.left), findDepth(n.right)) + 1;
    }
    
    @Test
    public void sumTest() {
        
        TNode root = TNode.get(10);
        root.left = TNode.get(5);
        root.left.left=TNode.get(3);
        root.left.left.left=TNode.get(3);
        root.left.left.right=TNode.get(-2);
        root.left.right=TNode.get(2);
        root.left.right.right=TNode.get(1);
        
        root.right = TNode.get(-3);
        root.right.left = TNode.get(11);
        
        Tree.print(root);
        
        System.out.println(nodeSumPaths(root, 0, 18));
        
    }
    
    @Test
    public void nextTreeNode() {
        TNode root = TNode.get(0);
        root.left = TNode.get(1);
        root.right = TNode.get(2);
        root.left.left = TNode.get(3);
        root.left.right = TNode.get(4);
        
        root.right.left = TNode.get(5);
        root.right.right = TNode.get(6);
        
        
        buildNodesAtEachLevel(root, new ArrayList<TreeDS.TNode>(), 0);
    }
    
    void buildNodesAtEachLevel(TNode n, List<TNode> list,int level){
        if(n == null){
            return;
        }
       
        
        if( list.isEmpty() || list.size()-1 < level){
            list.add(level, n);
            System.out.println("initialize"+"level"+level+","+n.vl);
        }else{
            TNode node = list.get(level);
            node.next = n;
            
            System.out.println("at "+level+", adding "+node.vl + " -> "+n.vl+" so "+level+"="+n.vl);
            list.set(level, n);
            
        }
        
        buildNodesAtEachLevel(n.left, list, level +1);
        buildNodesAtEachLevel(n.right, list, level +1);
        
    }
    
    int nodeSumPaths(TNode n, int curr, int tar) {
        if(n == null) {
            return 0;
        }
        
        curr += n.vl;
        System.out.println(n+","+curr);
        int totalPaths = 0;
        if(curr == tar) {
            totalPaths++;
        }
        totalPaths += nodeSumPaths(n.left, curr, tar);
        totalPaths += nodeSumPaths(n.right, curr, tar);
        return totalPaths;
    }

}

/*
 * Copyright 2017 Capital One Financial Corporation All Rights Reserved.
 * 
 * This software contains valuable trade secrets and proprietary information of Capital One and is protected by law. It
 * may not be copied or distributed in any form or medium, disclosed to third parties, reverse engineered or used in any
 * manner without prior written authorization from Capital One.
 */
