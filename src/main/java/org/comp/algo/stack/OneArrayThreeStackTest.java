package org.comp.algo.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OneArrayThreeStackTest {

    @Test
    public void testOnArrThreeStack() {
        List<Stack> list = get(10);
        for (Stack stack : list) {
            System.out.println(stack.len.begin + "," + stack.len.end);
        }

        Stack stack = list.get(1);
        System.out.println(stack.len.begin + "," + stack.len.end);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
    }

    private static List<Stack> get(int arrsize) {
        Integer[] arr = new Integer[arrsize]; // not divisible by 3

        int len = arr.length;
        int itr = len / 3;
        int rem = len % 3;

        List<Stack> stacks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Len l = new Len();
            l.begin = i * itr;
            l.end = ((i + 1) * itr) - 1;

            if (i == 2) {
                l.end = l.end + rem;
            }
            Stack s = new Stack();
            s.len = l;
            s.arr = arr;
            s.curr = l.begin;
            stacks.add(s);
        }
        return stacks;
    }

    private static class Stack {
        Len len;

        int curr;

        Integer[] arr;

        public void push(int i) {
            if (curr == len.end && arr[curr] != null) {
                throw new IllegalStateException("Stack is full");
            } else if (curr == len.end && arr[curr] == null) {
                arr[curr] = i;
            } else if (curr < len.end && arr[curr] == null) {
                arr[curr++] = i;
            } else {
                throw new IllegalStateException("Illegal State push");
            }
        }

        public int pop() {
            if (curr == len.begin && arr[curr] == null) {
                throw new IllegalStateException("Stack is empty");
            } else if (curr == len.begin && arr[curr] != null) {
                int t = arr[curr];
                arr[curr] = null;
                return t;
            } else if (curr > len.begin) {
                int t = arr[curr];
                arr[curr--] = null;
                return t;
            } else {
                throw new IllegalStateException("Illegal State pop");
            }
        }

        public void print() {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static class Len {
        int begin;

        int end;
    }

}

/*
 * Copyright 2017 Capital One Financial Corporation All Rights Reserved.
 * 
 * This software contains valuable trade secrets and proprietary information of Capital One and is protected by law. It
 * may not be copied or distributed in any form or medium, disclosed to third parties, reverse engineered or used in any
 * manner without prior written authorization from Capital One.
 */
