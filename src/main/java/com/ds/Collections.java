package com.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Collections {

	@Test
	public void checkListIterator() {
		List<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(2);
		l.add(3);
		l.add(3);
		
		

		ListIterator<Integer> it = l.listIterator();
		Integer p = it.next();

		while (it.hasNext() && it.hasPrevious()) {
			Integer c = peek(it);
			if (p == c) {
				it.remove(); //it goes to next index
				continue;
			}
			//it.set(e);
			p = c;
			it.next();
		}

	}
	
	@Test
	public void listIteratorReverse() {
		List<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(4);
		l.add(5);
		l.add(6);
		
		ListIterator<Integer> listIterator = l.listIterator(l.size());
		while (listIterator.hasPrevious()) {
			Integer integer = (Integer) listIterator.previous();
			System.out.println(integer);
			
		}
	}
	
	@Test
	public void addList() {
		List<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(1+1, 10);
		System.out.println(l);
	}

	private Integer peek(ListIterator<Integer> it) {
		Integer v = it.next();
		it.previous();
		return v;
	}

}
