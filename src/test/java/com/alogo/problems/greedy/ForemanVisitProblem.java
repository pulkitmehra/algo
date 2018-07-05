package com.alogo.problems.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ds.ClassUtil.TwDPt;

public class ForemanVisitProblem {

	TwDPt[] arr = { TwDPt.get(0, 3), TwDPt.get(3, 4), TwDPt.get(2, 6), TwDPt.get(7, 9), TwDPt.get(10, 12) };

	@Test
	public void foremanVisitProblem() {

		Arrays.sort(arr, (a, b) -> a.x == b.x ? 0 : a.x < b.x ? -1 : 1);
		int i = 0;
		int end = arr[i].x;// end
		List<Integer> list = new ArrayList<>();
		for (TwDPt interval : arr) {
			if(interval.y > end) {//left > end
				list.add(end);
				end = interval.x;
			}
		}
		list.add(end);
		System.out.println(list);

	}
	
	

}
