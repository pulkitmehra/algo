package org.comp.algo.problems;

import java.util.Iterator;

import org.junit.Test;

import org.comp.algo.problems.MostFrequentUsedLRUCache.Node;

public class MRUTest {

    @Test
    public void testSimple() {
        MostFrequentUsedLRUCache mfc = new MostFrequentUsedLRUCache(2);

        mfc.put(1, 11);
        mfc.put(2, 11);
        mfc.put(3, 11);
        mfc.put(4, 11);
        mfc.put(1, 12);
        mfc.put(5, 11);

        System.out.println(mfc);

        Iterator<Node> it = mfc.itr();

        while (it.hasNext()) {
            Node next = it.next();
            if (next != null) {
                System.out.println("K=" + next.k + ", V=" + next.v);
            }
        }

    }

}


