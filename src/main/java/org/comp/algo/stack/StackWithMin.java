package org.comp.algo.stack;

import org.junit.Test;

public class StackWithMin {

    @Test
    public void stackWithMin() {
        Stack s = new Stack();

        s.push(5);
        s.push(4);
        s.push(6);
        s.push(2);

        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        
    }

    private static class Stack {
        Node h;

        public void push(int e) {
            Node n = Node.get(e);
            if (h == null) {
                h = n;
                h.min = n.vl;
                return;
            }

            if (n.vl < h.min) {
                n.min = n.vl;
            } else {
                n.min = h.min;
            }

            n.nxt = h;
            h = n;
        }

        public int pop() {
            if (h == null) {
                return -1;
            }
            Node n = h;
            h = h.nxt;
            return n.vl;
        }

        public int min() {
            if (h == null) {
                return -1;
            }
            return h.min;
        }
    }

    static private class Node {
        Node nxt;

        int vl;

        int min;

        static Node get(int val) {
            Node n = new Node();
            n.vl = val;
            return n;
        }

        static String toStr(Node head) {
            StringBuilder b = new StringBuilder();
            b.append(head.vl).append("->");
            while (head.nxt != null) {
                b.append(head.nxt.vl).append("->");
                head = head.nxt;
            }
            b.append("null");
            return b.toString();
        }

        public String toString() {
            return String.valueOf(this.vl);
        }

        public Node next(int val) {
            Node n = new Node();
            n.vl = val;
            this.nxt = n;
            return n;
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
