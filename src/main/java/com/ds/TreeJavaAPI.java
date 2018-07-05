package com.ds;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.junit.Test;

public class TreeJavaAPI {

	@Test
	public void treeSet() {
		NavigableSet<Integer> tree = new TreeSet<>();
		tree.add(1);
		tree.add(5);
		tree.add(9);
		tree.add(20);
		
		System.out.println(tree.ceiling(5));
		System.out.println(tree.floor(5));
		System.out.println(tree.higher(5));
		System.out.println(tree.lower(5));
		System.out.println(tree.first());
		System.out.println(tree.last());
		
		Iterator<Integer> it = tree.iterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.print(i+",");
		}
		System.out.println();
		it = tree.descendingIterator();
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println(tree.headSet(6));
		System.out.println(tree.tailSet(6));
		
	}

}
