package org.comp.algo.tree;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TreeDS {

    public static class TNode {
        Integer vl;

        TNode left;

        TNode right;

        TNode parent;
        
        TNode next;

        int size=0;

        private void incr() {
            this.size = size + 1;
        }

        public static TNode get(Integer v) {
            TNode t = new TNode();
            t.size = 1;
            t.vl = v;
            return t;
        }

        public static TNode get(Integer v, TNode p) {
            TNode t = new TNode();
            t.size = 1;
            t.vl = v;
            t.parent = p;
            return t;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return String.format("%s-(%s)-%s", left == null ? "null" : left.vl, vl, right == null ? "null" : right.vl);
        }

    }

    public static class BST {

        public TNode root;

        public void print() {
            Tree.print(root, "", true, "");
            System.out.println("");
        }

        public void insert(Integer k) {
            root = insert(root, null, k);
        }

        public TNode random() {
            return random(root);
        }
        private TNode random(TNode n) {
            int leftSize = n.left == null ? 0 : n.left.size;
            Random r = new Random();
            int rand = r.nextInt(n.size==0 ? 1 : n.size);

            if (rand < leftSize) {
                return random(n.left);
            } else if (rand == leftSize) {
                return n;
            } else {
                return random(n.right);
            }

        }

        private TNode insert(TNode n, TNode p, int k) {
            if (n == null) {
                return TNode.get(k, p);
            }
            if (k > n.vl) {
                n.right = insert(n.right, n, k);
            } else if (k <= n.vl) {
                n.left = insert(n.left, n, k);
            }
            n.incr();
            return n;
        }

        public TNode search(int K) {
            return search(root, K);
        }

        private TNode search(TNode n, int k) {
            if (n == null) {
                return null;
            }
            TNode t = n;
            if (t.vl < k) {
                t = search(t.right, k);
            } else if (t.vl > k) {
                t = search(t.left, k);
            } else {
                return t;
            }
            if (t == null) {
                return n;
            }
            return t;
        }

    }

    public static class Tree {

        public static BST getBst() {
            BST bst = new BST();
            List<Integer> nodes = Arrays.asList(8, 4, 12, 5, 11, 9, 10, 3, 0, 7);

            for (Integer node : nodes) {
                bst.insert(node);
            }
            return bst;
        }

        public static BST getBst2() {
            BST bst = new BST();
            List<Integer> nodes = Arrays.asList(10, 5, 15, 4, 7, 14, 19, 6, 13);

            for (Integer node : nodes) {
                bst.insert(node);
            }
            return bst;
        }

        public static BST getBst3() {
            BST bst = new BST();
            List<Integer> nodes = Arrays.asList(30, 15, 9, 3, 22, 18, 27, 45, 52, 55, 50, 51);

            for (Integer node : nodes) {
                bst.insert(node);
            }
            return bst;
        }

        public static BST getBst4() {
            BST bst = new BST();
            List<Integer> nodes = Arrays.asList(15, 9, 22, 18, 27, 3);

            for (Integer node : nodes) {
                bst.insert(node);
            }
            return bst;
        }

        public static TNode bt() {
            TNode r = TNode.get(1);
            r.left = TNode.get(2);
            r.right = TNode.get(3);

            r.left.left = TNode.get(4);
            r.left.right = TNode.get(5);
            r.left.right.right = TNode.get(8);

            r.right.left = TNode.get(6);
            r.right.right = TNode.get(7);

            return r;
        }
        
        public static void print(TNode root) {
            Tree.print(root, "", true, "");
            System.out.println("");
        }

        public static void print(TNode n, String prefix, boolean isTail, String postfix) {
            if (n == null) {
                return;
            }
            System.out.println(prefix + (isTail ? "└── " : "├── ") + postfix + " v:" + n.vl
                    + (n.parent != null ? (" p:" + n.parent.vl) : " p:null") + " s:" + n.size);
            List<TNode> children = Arrays.asList(n.left, n.right);
            for (int i = 0; i < children.size() - 1; i++) {
                print(children.get(i), prefix + (isTail ? "    " : "│   "), false, "l-");
            }

            if (children.size() > 0) {
                TNode tNode = children.get(children.size() - 1);
                print(tNode, prefix + (isTail ? "    " : "│   "), true, "r-");
            }
        }

    }

}

/*
 * Copyright 2017 Capital One Financial Corporation All Rights Reserved.
 * 
 * This software contains valuable trade secrets and proprietary information of Capital One and is protected by law. It
 * may not be copied or distributed in any form or medium, disclosed to third parties, reverse engineered or used in any
 * manner without prior written authorization from Capital One.
 */
