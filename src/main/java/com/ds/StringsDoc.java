package com.ds;

import org.junit.Test;

public class StringsDoc {
	
	@Test
	public void stringNormalMethods() {
		String s = "pulkit";
		System.out.println(s.concat(" Mehra"));
		System.out.println(s.startsWith("pul"));
		//returns ASCII value
		System.out.println(s.codePointAt(1));

		String a = new String("a");	
		String a_ = new String("a");	
		System.out.println(a.intern()== a_.intern());
		
		//not sure what does 
		System.out.println(s.offsetByCodePoints(1, 1));
		System.out.println(String.copyValueOf(s.toCharArray()));
		
		
	}
	
	@Test
	public void substringTest() {
		String s = "pulkit";
		
		System.out.println(s.substring(1));
		
		//return empty
		System.out.println(s.substring(0,0));
		
		System.out.println(s.substring(0,1));
		
	}

}
