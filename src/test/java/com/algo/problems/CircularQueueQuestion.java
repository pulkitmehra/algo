package com.algo.problems;

import java.util.Arrays;

import org.junit.Test;

import com.ds.CircularQueueResize;
import com.ds.StackQueueDS.CircularQueue;
import com.ds.StackQueueDS.Stack;

public class CircularQueueQuestion {

	@Test
	public void CQoverflowTest1() {
		CircularQueue q = new CircularQueue(4);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.size());
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.enqueue(5);
		q.dequeue();
		q.enqueue(6);

		// q.enqueue(5);
		System.out.println(q);
	}

	@Test
	public void stackTest() {
		Stack s = new Stack(3);
		s.push(1);
		s.push(1);
		s.push(1);
		s.pop();
		s.pop();
		System.out.println(s.size());
		s.pop();
		System.out.println(s.size());
		// s.pop();
		System.out.println(s);
	}

	@Test
	public void testCQ() {
		CircularQueueResize cq = new CircularQueueResize(2);
		cq.enqueue(1);
		cq.enqueue(2);
		cq.enqueue(3);
		
		cq.dequeue();
		cq.dequeue();
		cq.dequeue();
		cq.enqueue(3);
		cq.enqueue(3);
		cq.dequeue();

		System.out.println(Arrays.toString(cq.arr));
	}

}
