package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.*;

public class FlatMapIterator {


    @Test
    public void test(){
        Nested one = Nested.get(1);
        Nested two = Nested.get(2);
        Nested three = Nested.get(3);
        Nested four = Nested.get(4);
        Nested five = Nested.get(5);
        Nested six = Nested.get(6);
        Nested seven = Nested.get(7);
        Nested eight = Nested.get(8);
        Nested nine = Nested.get(9);

        Nested oneLevelA = Nested.get(Arrays.asList(two, three));
        Nested twoLevel =Nested.get( Arrays.asList(oneLevelA, four));

        Nested oneLevelB = Nested.get(Arrays.asList(five, six));

        List<Nested> nesteds = Arrays.asList(one,twoLevel, oneLevelB, seven, eight, nine);

        ComplexNesterIterator  itr = new ComplexNesterIterator(nesteds);
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }



    @Test
    public void test2(){
        //[ [ [ [] ] ],[]]
        Nested one = Nested.get(Arrays.asList());
        Nested two = Nested.get(Arrays.asList(one));

        Nested three = Nested.get(Arrays.asList(two));

        Nested four = Nested.get(Arrays.asList(three));

        Nested five = Nested.get(Arrays.asList());

        SimpleNestedIterator  itr = new SimpleNestedIterator(Arrays.asList(four, five));
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }

    static class SimpleNestedIterator implements Iterator<Integer> {
        ArrayDeque<Iterator<Nested>> stack = new ArrayDeque<>();
        Nested curr;

        SimpleNestedIterator(List<Nested> nestedList){
            stack.push(nestedList.iterator());
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()){

                if(!stack.peek().hasNext()){
                    stack.pop();
                }else if( (curr = stack.peek().next()).isInt){
                    return true;
                }else{
                    stack.push(curr.list.iterator());
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            return (curr!=null) ? curr.v : null;
        }
    }


    static class ComplexNesterIterator implements Iterator<Integer> {

        SingleValueIterator singleValueIterator = new SingleValueIterator(null);
        ArrayDeque<Iterator<Nested>> queue = new ArrayDeque<>();
        List<Nested> list;
        int idx;

        ComplexNesterIterator(List<Nested> list){
            this.list = list;
            traverseNext();
        }

        private void traverseNext() {
            if(idx < list.size() && !hasNext()){
                Nested next = list.get(idx);
                if(!queue.isEmpty()) queue.poll();
                if(next.isInt){
                    queue.offer(new SingleValueIterator(next));
                }else{
                    queue.offer(next.list.iterator());
                }
                idx++;
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty() && queue.peek().hasNext();
        }

        @Override
        public Integer next() {
            if(hasNext()){
                Nested next =  queue.peek().next();
                if(next.isInt){
                    traverseNext();
                    return next.v;
                }else{
                    queue.addFirst(next.list.iterator());
                    return next();
                }
            }else{
                if(!queue.isEmpty())
                        queue.poll();
                traverseNext();
                return next();
            }
        }
    }

    static class SingleValueIterator implements Iterator<Nested> {

        Nested value = null;

        public SingleValueIterator(Nested value){
            this.value = value;
        }

        @Override
        public boolean hasNext() {
            return value!=null;
        }

        @Override
        public Nested next() {
            Nested temp = value;
            value = null;
            return temp;
        }

        public SingleValueIterator reset(Nested value){
            this.value = value;
            return this;
        }
    }



    static class Nested {
        int v=-1;
        boolean isInt=true;
        List<Nested> list;

        static Nested get(int v){
            Nested n = new Nested();
            n.v = v;
            return n;
        }

        static Nested get(List<Nested> list){
            Nested n = new Nested();
            n.list = list;
            n.isInt = false;
            return n;
        }

        void update(List<Nested> list){
            this.list = list;
            this.isInt = false;
        }

        @Override
        public String toString() {
            return "{"+v +", "+ isInt +", " + (list != null ? list.size() : 0) +"}";
        }
    }

}
