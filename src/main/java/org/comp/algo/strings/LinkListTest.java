package org.comp.algo.strings;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class LinkListTest {

    /*
     * a1->b1->a2->b2->a3->b3
     */
    @Test
    public void makeLLAlternate() {
        Node head = Node.get(1);
        head.next(2).next(3).next("a").next("b").next("c");
        Node a = getMid(head);
        System.out.println(Node.toStr(head));

        Node n = head;
        while (n.nxt != null && a.nxt != null) {
            Node ta = a.nxt;
            Node tn = n.nxt;
            n.nxt = a;
            a.nxt = tn;
            a = ta;
            n = tn;
        }
        n.nxt = a;
        System.out.println(Node.toStr(head));

    }

    public Node getMid(Node head) {
        Node slw = head;
        Node fst = head;

        while (slw != null && fst != null) {
            slw = slw.nxt;
            fst = fst.nxt;
            if (fst != null) {
                fst = fst.nxt;
            }
        }
        return slw;
    }

    static class Node {
        Node nxt;

        Object vl;

        static Node get(Object val) {
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
            return this.vl.toString();
        }

        public Node next(Object val) {
            Node n = new Node();
            n.vl = val;
            this.nxt = n;
            return n;
        }
    }

    @Test
    public void linkedListDupRunner() {

        Node head = Node.get(1);
        head.next(2).next(1).next(3).next(1).next(2).next(3).next(4);

        Node r = head;
        Node prev = head;
        Node p = head;

        while (p != null) {
            while (r != null) {
                if (p == r) {
                    prev = r;
                    r = r.nxt;
                    continue;
                }
                if (p.vl == r.vl) {
                    prev.nxt = r.nxt;
                    r = r.nxt;
                    continue;
                }
                prev = prev.nxt;
                r = r.nxt;
            }
            prev = r = head;
            p = p.nxt;
        }
        System.out.println(Node.toStr(head));
    }

    @Test
    public void linkedListDupRunnerHM() {
        Set<Object> set = new HashSet<>();

        Node head = Node.get(1);
        head.next(2).next(1).next(3).next(1).next(2).next(3).next(4);

        Node prev = head;
        Node p = head.nxt;
        set.add(head.vl);

        while (p != null) {
            if (set.contains(p.vl)) {
                prev.nxt = p.nxt;
                p = prev.nxt;
            } else {
                set.add(p.vl);
                prev = p;
                p = p.nxt;
            }
        }
        System.out.println(Node.toStr(head));
    }

    @Test
    public void kthelastElement() {
        Node head = Node.get(1);
        head.next(2).next(3).next(4).next(5).next(6).next(7).next(8);
        int k = 0;

        Node p = head;
        int i = 0;
        while (p != null && i < k) {
            p = p.nxt;
            i++;
        }
        if (i != k) {
            System.out.println("Small lenth");
            return;
        }

        Node r = p;
        p = head;

        while (r != null) {
            if (p.nxt != null) {
                p = p.nxt;
            }
            r = r.nxt;
        }
        System.out.println(p.vl);
    }

    @Test
    public void deleteMidElelement() {
        Node head = Node.get(1);
        // head.next(2).next(3);

        Node p = head;
        Node pp = head;
        Node r = p.nxt;

        while (r != null && r.nxt != null) {
            r = r.nxt;
            if (r == null) {
                break;
            }
            pp = p;
            r = r.nxt;
            p = p.nxt;
        }

        if (p == pp) {
            System.out.println("No middle");
            return;
        }

        pp.nxt = p.nxt;
        p.nxt = null;
        System.out.println(Node.toStr(head));
    }

    @Test
    public void partitionOnNode() {
        Node head = Node.get(1);
        head.next(5).next(2).next(7).next(1).next(3).next(6).next(4);
        int num = 5;
        Node d = Node.get("d");
        Node p = Node.get("p");
        Node newHead = findPartition(d, p, head, num);
        System.out.println(Node.toStr(d));
        System.out.println(Node.toStr(p));

        Node ld = d;
        while (ld.nxt != null) {
            ld = ld.nxt;
        }
        ld.nxt = p.nxt;
        d = d.nxt;
        System.out.println(Node.toStr(d));

    }

    private Node findPartition(Node d, Node p, Node n, int num) {
        if (n == null) {
            // System.out.println(n.vl);
            return n;
        }
        findPartition(d, p, n.nxt, num);
        if ((Integer) n.vl < num) {
            Node t = d.nxt;
            d.nxt = n;
            n.nxt = t;
        } else {
            Node t = p.nxt;
            p.nxt = n;
            n.nxt = t;
        }
        return d;
    }

    @Test
    public void addTwoNumberfwd() {
        Node p = Node.get(7);
        p.next(1).next(6);

        Node q = Node.get(5);
        q.next(9).next(2);

        Node newHead = null;
        int carry = 0;

        while (p != null && q != null) {

            int vl = (Integer) p.vl + (Integer) q.vl + carry;

            int one = vl % 10;

            if (newHead == null) {
                newHead = Node.get(one);
            } else {
                Node t = Node.get(one);
                t.nxt = newHead;
                newHead = t;
            }
            carry = (vl - one) / 10;
            p = p.nxt;
            q = q.nxt;

        }
        if (carry != 0) {
            newHead = Node.get(carry).nxt = newHead;
        }

        System.out.println(Node.toStr(newHead));
    }

    /*
     * 716 592 --- 1308
     */
    @Test
    public void addTwoNumberBkwrd() {
        Node p = Node.get(7);
        p.next(1).next(6);

        Node q = Node.get(5);
        q.next(9).next(2);

        Node n = Node.get("n");
        int carry = addNumber(p, q, n);
        n = n.nxt;

        Node f = Node.get(carry);
        f.nxt = n;

        System.out.println(Node.toStr(f));
    }

    void printReverse(Node n) {
        if (n == null) {
            return;
        }
        printReverse(n.nxt);
        System.out.println(n.vl + "->");
    }

    int addNumber(Node p, Node q, Node n) {

        if (p == null && q == null) {
            return 0;
        }

        int carry = addNumber(p.nxt, q.nxt, n);

        int vl = (Integer) p.vl + (Integer) q.vl + carry;
        int one = vl % 10;
        int ncarry = (vl - one) / 10;

        Node t = n.nxt;
        n.nxt = Node.get(one);
        n.nxt.nxt = t;

        return ncarry;

    }

    /*
     * 0>1->2->3->2->1->0 = odd 0>1->2->2->1 = even
     */
    @Test
    public void isPalindromeinLL() {

        Node oddhead = Node.get(1);
        oddhead.next(2).next(3).next(2).next(1);

        Node evnhead = Node.get(1);
        evnhead.next(2).next(2).next(1);

        System.out.println(isPalindromMain(evnhead).b);
        System.out.println(isPalindromMain(oddhead).b);
    }

    public Result isPalindromMain(Node head) {
        Node l = head;
        int len = 0;

        while (l != null) {
            l = l.nxt;
            len++;
        }

        if (len <= 2) {
            System.out.println("no palidrome");
            return new Result(null, false);
        }

        return isPalindromRecurrsive(head, len);
    }

    static class Result {
        Node r;

        boolean b;

        Result(Node r, boolean b) {
            this.r = r;
            this.b = b;
        }
    }

    public Result isPalindromRecurrsive(Node h, int len) {
        if (len <= 0) { // even
            return new Result(h, true);
        } else if (len == 1) { // odd
            return new Result(h.nxt, true);
        }

        Result res = isPalindromRecurrsive(h.nxt, len - 2);

        boolean b = h.vl == res.r.vl;
        if (!b || !res.b) {
            return new Result(h, false);
        }
        return new Result(res.r.nxt, b);
    }
 // @formatter:off
    /*
     * 
     * 1 -> 2 
     *          ->3 -> 4 -> 5 (unequal length) 
     *      0
     *       
     * 2 ->
     *      3 -> 4 -> 5 (equal length)
     * 0 ->    
     */
 // @formatter:on
    @Test
    public void intersectionLL() {
        Node phead = Node.get(1);
        Node node3 = phead.next(2).next(3);

        Node node4 = Node.get(4);
        Node node5 = Node.get(5);

        node3.nxt = node4;
        node4.nxt = node5;

        Node qhead = Node.get(0);
        qhead.nxt = node3;

        System.out.println(Node.toStr(phead));
        System.out.println(Node.toStr(qhead));

        Node pTail = null;
        int plen = 0;
        Node p = phead;
        while (p != null) {
            pTail = p;
            p = p.nxt;
            plen++;
        }

        Node qTail = null;
        int qlen = 0;
        Node q = qhead;
        while (q != null) {
            qTail = q;
            q = q.nxt;
            qlen++;
        }

        if (pTail != qTail) {
            System.out.println("no intersection");
            return;
        }
        p = phead;
        q = qhead;
        if (plen != qlen) {
            Node longer = plen > qlen ? phead : qhead;
            Node shorter = plen < qlen ? phead : qhead;

            int llen = plen > qlen ? plen : qlen;
            int slen = plen < qlen ? plen : qlen;
            while (llen != slen) {
                p = longer.nxt;
                llen--;
            }
            q = shorter;
        }

        Node ints = null;
        while (p != null && q != null) {

            if (p == q) {
                if (ints == null) {
                    ints = Node.get(p.vl);
                } else {
                    Node t = ints;
                    ints = Node.get(p.vl);
                    ints.nxt = t;
                }
            }
            p = p.nxt;
            q = q.nxt;
        }
        System.out.println(Node.toStr(ints));

    }

}


