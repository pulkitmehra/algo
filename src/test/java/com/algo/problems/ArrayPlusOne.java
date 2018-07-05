package com.algo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ArrayPlusOne {
	
	@Test
	public void plusOne() {
		List<Integer> l=new ArrayList<>();
		l.add(9);
		l.add(9);
		l.add(9);
		
		Collections.reverse(l);
		
		int c=0;
		for(int i=0; i<l.size(); i++) {
			if(i==0) {
				c=1;
			}
			int v = l.get(i)+c;
			l.set(i, v%10);
			c = v/10;
		}
		if(c!=0) {
			l.add(c);
		}
		Collections.reverse(l);
		System.out.println(l);
		
	}
	

}
