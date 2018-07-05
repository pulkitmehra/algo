package com.ds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import org.junit.Test;

public class ArrayDequeueDS {

	@Test
	public void arrayDequeueAsStack() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		stack.push(2);
		stack.offerFirst(3);
		System.out.println(stack.peek());
		System.out.println(stack);
	}
	
	@Test
	public void arrayDequeueAsStac2k() {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.addFirst(1);
		stack.addFirst(2);
		System.out.println(stack.peekFirst());
		System.out.println(stack);
	}
	
	@Test
	public void queue() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(1);
		q.offer(2);
		q.offerLast(3);
		System.out.println(q);
		System.out.println(q.peekFirst());
		System.out.println(q.peekLast());
		System.out.println(q.pollFirst());
		System.out.println(q.poll());
		System.out.println(q.pollLast());
		
		
	}
	
	@Test
	public void queue2() {
		Deque<Integer> q = new ArrayDeque<>();
		q.add(1);
		q.offer(2);
		q.offerLast(3);
		Iterator<Integer> iterator = q.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		
		Iterator<Integer> iterator2 = q.descendingIterator();
		while (iterator2.hasNext()) {
			Integer integer = (Integer) iterator2.next();
			System.out.println(integer);
		}
		
	}
	
	

}
