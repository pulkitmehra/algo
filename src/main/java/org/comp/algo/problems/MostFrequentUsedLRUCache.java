package org.comp.algo.problems;

import java.util.Iterator;

public class MostFrequentUsedLRUCache {

    Node[] arr;

    int capacity;

    int size;

    Node head;

    Node tail;

    public MostFrequentUsedLRUCache(int capacity) {
        this.capacity = capacity;
        arr = new Node[capacity + 1];
    }

    public void put(int k, int v) {
        Node n = arr[hash(k)], p = n;
        if (n != null) {// collision
            while (p != null && p.next != null && p.k != k) {
                p = p.next;
            }
            if (p.k == k) { // update value
                p.v = v;
            }
            else { // Add new
                p.next = Node.get(k, v);
                p.next.before = p;
            }
        }
        else {
            arr[hash(k)] = Node.get(k, v);
        }
    }

    public int get(int k) {
        Node n = arr[hash(k)], p = n;
        while (p != null && p.k != k) {
            p = p.next;
        }
        if (p == null) {
            return Integer.MIN_VALUE;
        }
        return p.v;
    }

    public int hash(int k) {
        return k % capacity;
    }

    public Iterator<Node> itr() {
        CustomIterator it = new CustomIterator();
        return it;
    }

    public class CustomIterator implements Iterator<Node> {
        int curr = 0;

        Node sentinel = new Node(), p = sentinel;

        public CustomIterator() {
            sentinel.next = arr[0];
        }

        @Override
        public boolean hasNext() {
            return curr <= capacity;
        }

        @Override
        public Node next() {
            if (!hasNext() ) {
                return null;
            }
            Node e = p.next;
            if (p.next == null) {
                curr++;
                if (hasNext()) {
                    p = arr[curr];
                    e = p;
                }
                else {
                    return null;
                }
            }
            if (p != null) {
                p = p.next;
            }
            return e;
        }

    }

    static class Node {
        int k;

        int v;

        Node before, after;

        Node next, prev;

        public static Node get(int k, int v) {
            Node n = new Node();
            n.k = k;
            n.v = v;
            return n;
        }

        @Override
        public String toString() {
            return "(" + prev + ")-[" + k + "," + v + "]-(" + next + ")";
        }

    }

}

