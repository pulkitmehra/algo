package com.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.junit.Test;

public class Heaps {

	@Test
	public void minHeap() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, (a, b) -> a == b ? 0 : a < b ? -1 : 0);
		for (int i = 0; i < 5; i++) {
			minHeap.add(i);
		}
		System.out.println(minHeap);
		
		Integer element = minHeap.poll();
		System.out.println(minHeap);
	}
	
	@Test
	public void changeKeyInPQ() {
		PriorityQueue<IntWrap> minHeap = new PriorityQueue<>();
		Map<Integer, IntWrap> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			IntWrap e = IntWrap.get(i);
			minHeap.add(e);
			map.put(i, e);
		}
		System.out.println(minHeap);
		//map.get(4).val=-1;//not work
		System.out.println(minHeap);
		
		minHeap.remove(IntWrap.get(4));
		minHeap.offer(IntWrap.get(-1));
		System.out.println(minHeap);
		
	}
	
	public static class IntWrap implements Comparable<IntWrap>{
		Integer val;
		
		public static IntWrap get(Integer v) {
			IntWrap intwrap = new IntWrap();
			intwrap.val=v;
			return intwrap;
		}
		
		public void adjust(int delta) {
			val += delta;
		}

		@Override
		public int compareTo(IntWrap o) {
			return val.compareTo(o.val);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((val == null) ? 0 : val.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IntWrap other = (IntWrap) obj;
			if (val == null) {
				if (other.val != null)
					return false;
			} else if (!val.equals(other.val))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + val + "]";
		}
		
		
		
	}
}
