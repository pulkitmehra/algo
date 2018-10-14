package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {
    Map<Character, Character> chMap = new HashMap<>();
    {
        chMap.put('(',')');
        chMap.put('{','}');
        chMap.put('[',']');
    }

    @Test
    public void test(){
        System.out.println(isValid("()"));
    }
    public boolean isValid(String s) {

        if(s.length() == 0) return true;

        ArrayDeque<Character> stack = new ArrayDeque();
        int i=0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(isOpen(ch)){
                stack.push(ch);
            }else{

                if(stack.isEmpty()) return false;

                if(ch != chMap.get(stack.peek())) {
                    stack.pop();
                    return false;
                }
                stack.pop();
            }
            i++;
        }
        return stack.isEmpty() ? false : true;
    }

    public boolean isOpen(Character ch){
        return ch == '(' || ch == '{' || ch == '[';
    }

}

