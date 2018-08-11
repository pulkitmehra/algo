package org.comp.algo.stack;

import java.util.Stack;

import org.junit.Test;

public class SortStack {

    @Test
    public void sortStack() {
        Stack<Integer> main = new Stack<>();
        main.push(5);
        main.push(7);
        main.push(3);
        main.push(4);
        main.push(9);
        main.push(2);
        main.push(10);

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> res = new Stack<>();

        //Stack<Integer> sortStack = sortStack(main, temp, res);
        //sortStack.stream().forEach(System.out::println);
        sortUsingOneAdditionalStackOnly(main);
    }

    private Stack<Integer> sortStack(Stack<Integer> main, Stack<Integer> temp, Stack<Integer> res) {
        if (main.isEmpty()) {
            return res;
        }

        Integer num = main.pop();
        while (!main.isEmpty()) {
            Integer e = main.pop();
            if (e < num) {
                temp.push(num);
                num = e;
            } else {
                temp.push(e);
            }
        }
        res.push(num);
        return sortStack(temp, main, res);
    }

    private  void sortUsingOneAdditionalStackOnly(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        
        while(!s.isEmpty()) {
            Integer e = s.pop();
            
            while(!r.isEmpty() && r.peek() > e) {
                s.push(r.pop());
            }
            
            r.push(e);
        }
        while(!r.isEmpty()) {
            s.push(r.pop());
        }
        s.stream().forEach(System.out::println);
        
    }

}

/*
 * Copyright 2017 Capital One Financial Corporation All Rights Reserved.
 * 
 * This software contains valuable trade secrets and proprietary information of Capital One and is protected by law. It
 * may not be copied or distributed in any form or medium, disclosed to third parties, reverse engineered or used in any
 * manner without prior written authorization from Capital One.
 */
