package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.*;

public class Celebrity {

    int call = 0;
    Map<Integer, Set<Integer>> knowsMap = new HashMap<>();

    {
        knowsMap.computeIfAbsent(0, (e) -> new HashSet<>()).add(1);
        knowsMap.computeIfAbsent(2, (e) -> new HashSet<>()).add(0);
        knowsMap.computeIfAbsent(2, (e) -> new HashSet<>()).add(3);
        knowsMap.computeIfAbsent(3, (e) -> new HashSet<>()).add(4);
        knowsMap.computeIfAbsent(4, (e) -> new HashSet<>()).add(1);


    }

    boolean knows(int a, int b) {
        call++;
        return knowsMap.getOrDefault(a, Collections.emptySet()).contains(b);
    }

    @Test
    public void test() {
            int[] know = new int[5];
            findCelebrity(know, 0, 4);
            System.out.println(Arrays.toString(know));
            for (int i = 0; i < know.length; i++) {
                if(know[i]==0) System.out.println(i);
            }

        System.out.println(findCelebrity(5));
    }

    public int findCelebrity(int n) {
        // base case
        if (n <= 0) return -1;
        if (n == 1) return 0;

        Stack<Integer> stack = new Stack<>();

        // put all people to the stack
        for (int i = 0; i < n; i++) stack.push(i);

        int a = 0, b = 0;

        while (stack.size() > 1) {
            a = stack.pop(); b = stack.pop();

            if (knows(a, b))
                // a knows b, so a is not the celebrity, but b may be
                stack.push(b);
            else
                // a doesn't know b, so b is not the celebrity, but a may be
                stack.push(a);
        }

        // double check the potential celebrity
        int c = stack.pop();

        for (int i = 0; i < n; i++)
            // c should not know anyone else
            if (i != c && (knows(c, i) || !knows(i, c)))
                return -1;

        return c;
    }


    public void findCelebrity(int[] know, int lo, int hi) {

        if (lo == hi) {
             return;
        }
        int m = lo + (hi - lo) / 2;
        findCelebrity( know, lo, m);
        findCelebrity( know, m + 1, hi);
        merge( know, lo, m, hi);
    }

    private void merge( int[] know, int lo, int m, int hi) {

        while (lo <= m) {

            int j = m + 1;
            while (j <= hi) {

                if (know[lo] == 0 && knows(lo, j))
                    know[lo] += 1;
                else
                    know[j] += 1;

                j++;
            }
            lo++;
        }

    }
}
