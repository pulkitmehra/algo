package com.alogo.problems.greedy;

import java.util.Arrays;

import org.junit.Test;

public class MinimumWaitingTime {
	
	int[] jobs = {2,3,1,5};
	
	@Test
	public void findMinimumWaitingTime() {
		Arrays.sort(jobs);
		int waitingTime =0;
		for(int i=1; i<jobs.length;i++) {
			int futureJobs = jobs.length - i;
			waitingTime += futureJobs * jobs[i-1]; //future jobs * last job time;
		}
		System.out.println(waitingTime);
	}

}
