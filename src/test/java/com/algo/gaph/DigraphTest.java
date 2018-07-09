package com.algo.gaph;

import org.junit.Test;

import com.ds.DiGraph;

public class DigraphTest {
	
	@Test
	public void testGraphStructure() {
		DiGraph mini = DiGraph.mini();
		System.out.println(mini);
	}
	
	@Test
	public void testCLsr() {
		DiGraph clsr = DiGraph.clsr();
		System.out.println(clsr);
	}

}
