package com.leetcode.premium.fb;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class RangeInKSortedList {

    List<List<Integer>> all = new ArrayList<>();

    @Before
    public void init() {
        all.add(Arrays.asList(4, 10, 15, 24, 26));
        all.add(Arrays.asList(0, 9, 12, 20));
        all.add(Arrays.asList(5, 18, 22, 30));
    }

    @Test
    public void findRange() {


        PriorityQueue<Val> minHeap = new PriorityQueue<>(all.size(), (a, b) -> Integer.compare(a.val, b.val));
        //PriorityQueue<Val> maxHeap = new PriorityQueue<>(all.size(), (a, b) -> Integer.compare(b.val, a.val));
        Val max = Val.get(-1,Integer.MIN_VALUE);
        List<Iterator<Integer>> iterators = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            Iterator<Integer> itr = all.get(i).iterator();
            if (itr.hasNext()) {
                iterators.add(itr);
                Integer v = itr.next();
                minHeap.offer(Val.get(i, v));
                max.val = Math.max(max.val, v);
                //maxHeap.offer(Val.get(i, v));
            }
        }

        Range minRange = null;

        while (!minHeap.isEmpty()) {
            Val min = minHeap.poll();
            if (minRange == null) {
                minRange = Range.get(min, max);
            } else {
                minRange = minRange.orElseMin(Range.get(min,max));
            }
            Iterator<Integer> itr = iterators.get(min.lst);
            if(itr.hasNext()){
                Integer nxtValue = itr.next();
                minHeap.offer(Val.get(min.lst, nxtValue));
                max.val = Math.max(max.val, nxtValue);
            }else{
                break;
            }

        }
        System.out.println(minRange);
    }

    static class Val {
        int lst;
        int val;

        public static Val get(int lst, int val) {
            Val v = new Val();
            v.lst = lst;
            v.val = val;
            return v;
        }

        @Override
        public String toString() {
            return "v{"+ lst +
                    "-" + val +
                    '}';
        }
    }

    static class Range implements Comparable<Range> {
        Integer lo;
        Integer hi;

        public static Range get(Val lo, Val hi) {
            Range r = new Range();
            r.lo = lo.val;
            r.hi = hi.val;
            return r;
        }

        public int diff() {
            return hi - lo;
        }

        Range orElseMin(Range other) {
            int v = this.compareTo(other);
            return v > 0 ? other : this;
        }

        @Override
        public int compareTo(Range other) {
            return Integer.compare(diff(), other.diff());
        }

        @Override
        public String toString() {
            return "{"+ lo +
                    "," + hi+'}';
        }
    }

}
